package Second;

import java.util.Random;
import java.util.Vector;

public class Pokers {
    private final int amount = 52;
    private int[] order = new int[52];

    private Vector<Poker> pokers = new Vector<Poker>();
    public Pokers(){
        for(int i = 0;i<amount;i++){
            order[i] = i;
        }
        for(int i = 1;i<=4;i++){
            String patten = null;
            String color = null;
            switch (i){
                case 1:patten = "♥️️";color = "red";break;
                case 3:patten = "♠️";color = "black";break;
                case 2:patten = "♦️";color = "red";break;
                case 4:patten = "♣️";color = "black";break;
            }
            for(int j = 1; j <= 10;j++){
                pokers.add(new Poker(""+j,patten,color));
            }
            pokers.add(new Poker("J",patten,color));
            pokers.add(new Poker("Q",patten,color));
            pokers.add(new Poker("K",patten,color));
        }
    }
    public int getAmount(){
        return amount;
    }
    public Poker getPoker(int index){
        System.out.print(pokers.get(index).getNumber()+pokers.get(index).getPattern()+"\t");
        return pokers.get(index);
    }
    private Poker getPoker(String number, String patten) {
        for (int i = 0; i < amount; i++) {
            Poker poker = getPoker(i);
            if (poker.getNumber().equals(number) && poker.getPattern().equals(patten))
                return poker;
        }
        return null;
    }

    public void shuffle(){
        Random r = new Random();
        for(int i=amount-1;i>0;i--){
            int index = r.nextInt() % i;
            if(index < 0)
                index = 0 -index;
            int temp = order[i];
            order[i] = order[index];
            order[index] = temp;
        }
    }

    public void reSet(){
        for(int i=0;i<amount;i++){
            order[i] = i;
        }
    }
    public void showPokers(int col){
        for(int i=0;i<amount;i++){
            Poker poker = getPoker(order[i]);
            if(i % col == col-1)
                System.out.println();
        }
    }

    public Vector<Vector<Poker>> distribute(int groupNum ){
        if(groupNum < 1)
            return null;
        Vector<Vector<Poker>> pokers2 = new Vector<>();
        for(int i=0;i<groupNum;i++){
            pokers2.add(new Vector<Poker>());
        }
        for(int i=0;i<amount;i++){
            pokers2.get(i%groupNum).add(pokers.get(order[i]));
        }
        return pokers2;
    }


    public static void main(String[] args){
        Pokers pokers = new Pokers();
        for(int i=0; i<pokers.amount;i++){
            pokers.getPoker(i);
            if(i%13 == 12)
                System.out.println();
        }

        System.out.println();
        pokers.showPokers(12);
        System.out.println();
        pokers.shuffle();
        pokers.showPokers(10);
        System.out.println();

        Vector<Vector<Poker>> pokers2 = pokers.distribute(13);
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                System.out.print(pokers2.get(i).get(j).getNumber()+pokers2.get(i).get(j).getPattern()+"\t");
            }
            System.out.println();
        }
    }
}
