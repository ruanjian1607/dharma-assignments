
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokeCard {
    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap();
        ArrayList<Integer> A = new ArrayList<>();
        String[] Kind = new String[]{"黑桃","梅花","红桃","方块"};
        String[] Array = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        int count = 0;
        int c = 0;
        for (String i : Kind){
            for (String j : Array){
                String s = i.concat(j);
                hm.put(c,s);
                A.add(c);
                c++;
            }
        }
        //System.out.println(hm);
        Collections.shuffle(A);
        System.out.println("发到的4张牌分别是：");
        while(count < 4){
            System.out.print(hm.get(A.get(count)));
            System.out.print(" ");
            count++;
        }
    }
}
