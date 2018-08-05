import java.util.*;

public class PokerForFun {
    public static void main(String[] args) {
        List list = new ArrayList();
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        String color[] = {"♦️", "♣️", "♥️", "♠️"};
        String num[] = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int count = 0;

        for (int i = 0; i < num.length; i ++){
            for (int j = 0; j < color.length; j ++){
                map.put(count, color[j] + num[i]);
                list.add(count);
                count ++;
            }
        }
        System.out.println(list.size());

        Collections.shuffle(list);

        List play1 = new ArrayList();
        List play2 = new ArrayList();
        List play3 = new ArrayList();
        List play4 = new ArrayList();

        for (int i = 0; i<list.size(); i ++){
            if (i % 4 == 0){
                play1.add(list.get(i));
            }else if (i % 4 == 1){
                play2.add(list.get(i));
            }else if (i % 4 == 2){
                play3.add(list.get(i));
            }else if (i % 4 == 3){
                play4.add(list.get(i));
            }
        }

        Collections.sort(play1);
        Collections.sort(play2);
        Collections.sort(play3);
        Collections.sort(play4);

        change(map, play1);
        change(map, play2);
        change(map, play3);
        change(map, play4);

        System.out.println(play1);
        System.out.println(play2);
        System.out.println(play3);
        System.out.println(play4);


    }

    public static void change(HashMap<Integer, String> map, List list){
        for (int i = 0; i <list.size(); i ++){
            list.set(i, map.get(list.get(i)));
        }
    }

}
