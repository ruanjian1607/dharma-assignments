package com.zhanghanwen;

import java.util.*;

public class PokerTest{
    private List pokers = null;
    public PokerTest(){
        pokers = new ArrayList<>();
        for(int i =1;i<=13;i++){
            for(int j=0;j<4;j++){
                pokers.add(i);
            }
        }
    }
    public List ShuffleTest(){
        Collections.shuffle(pokers);
        return  pokers;
    }
    public void DealTest(List list){
        int roundIndex = 0;
        Random r = new Random();
        roundIndex = r.nextInt(pokers.size());
        Object object = pokers.get(roundIndex);
        if(object ==(Object)1){
            list.add("A");
            pokers.remove(roundIndex);
        }else if (object == (Object)11){
            list.add("J");
            pokers.remove(roundIndex);
        }else if (object == (Object)12) {
            list.add("Q");
            pokers.remove(roundIndex);
        }else if (object == (Object)13) {
            list.add("K");
            pokers.remove(roundIndex);
        }else{
            list.add(object);
            pokers.remove(roundIndex);
        }
    }
}

class Test{
    public static void main(String[] args) {
        List person1 = new ArrayList<>();
        List person2 = new ArrayList<>();
        List person3 = new ArrayList<>();
        List person4 = new ArrayList<>();
        PokerTest pokers = new PokerTest();
        pokers.ShuffleTest();
        for(int i =0;i<13;i++){
            pokers.DealTest(person1);
            pokers.DealTest(person2);
            pokers.DealTest(person3);
            pokers.DealTest(person4);
        }
        System.out.println("No.1: "+person1);
        System.out.println("No.2: "+person2);
        System.out.println("No.3: "+person3);
        System.out.println("No.4: "+person4);
    }
}
