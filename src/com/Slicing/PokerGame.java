
import java.util.*;

class Poker{
    private String type;
    private  int number;

    public Poker(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String num = "";
        if(number == 1 ){
            num = "A";
        }else if(number == 11){
            num = "J";
        }else if(number == 12 ){
            num = "Q";
        }else if(number == 13){
            num = "K";
        }else{
            num = Integer.toString(number);
        }
        return "  " + type + " " + num ;
    }
}
class Pokers implements Iterable{
    List<Poker> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    public Pokers() {
        list1.add("红桃");
        list1.add("黑桃");
        list1.add("方块");
        list1.add("梅花");
        for(String type:list1){
            for(int i=1;i<14;i++){
                list.add(new Poker(type,i));
            }
        }
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
public class PokerGame {
    public static void main(String[] args) {
        Pokers pokers = new Pokers();
        Collections.shuffle(pokers.list);
        Scanner sca = new Scanner(System.in);
        System.out.println("欢迎来到Slicing游戏厅");
        System.out.print("请输入玩家个数：");
        int num = sca.nextInt();
        for(int i =1;i<=num;i++){
            System.out.println("玩家" + i + "的牌是:" + pokers.list.get(i)) ;
        }

    }
}

