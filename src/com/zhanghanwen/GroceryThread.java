package com.zhanghanwen;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Grocery{
    public  Map<String,Integer> map = new HashMap<>();
    public static int money = 0;

    public Grocery() {
        map.put("HUAWEI P20",3788);
        map.put("HUAWEI nova3",2999);
        map.put("HUAWEI Mate RS",9999);
        map.put("HUAWEI 麦芒6",2199);
        map.put("HUAWEI 畅想8e",999);
    }
}

class DemoThread implements Runnable{
    private Map<String,Integer> map1 = new Grocery().map;

    private synchronized static void buy(Map<String,Integer> maptest) {
        Set set = maptest.keySet();
        Object [] array = set.toArray();
        Random r = new Random();
        int roundIndex = r.nextInt(array.length);
        Object name = array[roundIndex];
        Grocery.money+= maptest.get(name);
        System.out.println("收银员 "+Thread.currentThread().getName()+" 卖出一款"+name+" , 收获"+maptest.get(name)+"元");
    }

    @Override
    public void run() {
        buy(map1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class GroceryThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i = 0;i<5;i++){
            executor.execute(new DemoThread());
        }
        Thread.sleep(5000);
        executor.shutdown();
        System.out.println("\n杂货店今日总共赚了"+Grocery.money+"元");
    }
}

