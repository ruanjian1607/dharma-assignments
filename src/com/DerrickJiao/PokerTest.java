import java.util.*;

class Pokers {
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    List<Integer> list = new ArrayList();
    public Pokers(){
        int count = 0;

        String color[] = {"♦️", "♣️", "♥️", "♠️"};
        String num[] = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (int i = 0; i < num.length; i ++){
            for (int j = 0; j < color.length; j ++) {
                map.put(count, color[j] + num[i]);
                list.add(count);
                count ++;
            }
        }

    }
}

public class PokerTest {
    public static void main(String[] args) {
        Pokers po = new Pokers();
        List list = po.list;
        Collections.shuffle(list);
        List<List> lists=new ArrayList<>();
        for(int j = 0; j < 4; j ++){
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i ++){
                if (i % 4 == j ){
                    list1.add((Integer) list.get(i));
                }

            }
            change(po.map, list1);
            lists.add(list1);
        }

        for (int i = 0; i < lists.size(); i ++){
            if (i % 13 == 0)
                System.out.println();
                System.out.println("player" +  ":" + lists.get(i));
        }

    }

    public static void change(HashMap<Integer, String> map, List list){
        for (int i = 0; i <list.size(); i ++){
            list.set(i, map.get(list.get(i)));
        }
    }
}
