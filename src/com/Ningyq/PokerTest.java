package java4;

import java.util.*;

class Poker {
    private String type;
    private Integer num;

    public Poker() {
    }

    public Poker(String type, Integer num) {
        this.type = type;
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String str = "";
        if(num == 10){
            str = "A";
        }else if(num == 11){
            str = "J";
        }else if(num == 12 ){
            str = "Q";
        }else if(num == 13){
            str = "K";
        }else{
            str = Integer.toString(num);
        }
        return type + str ;
    }
}

class Pokers implements Iterable{
    List<Poker> list = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();

    public Pokers() {

        list1.add("红桃");
        list1.add("黑桃");
        list1.add("方块");
        list1.add("梅花");
        for(String type:list1) {
            for (int i = 1; i < 14; i++) {
                list.add(new Poker(type, i));
            }
        }
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}

public class PokerTest {

    public static class myException extends Exception {
        public myException() {
        }

        public myException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws myException {
        Pokers pokers = new Pokers();
        Collections.shuffle(pokers.list);
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入玩家个数(1到13之间)：");
        int num = sc.nextInt();
        if (num < 1 || num > 13) {
            throw new myException("输入玩家不在范围之内！");
        }
        int k = 0;
        for (int i = 1 ; i <= num ; i++ ){
            System.out.print("玩家" + i + "的牌是: ");
            for (int j = 1 ; j <= 4 ;j++ ){
                System.out.print(pokers.list.get(k)+"  ");
                k ++ ;
            }
            System.out.println();
        }
    }
}
