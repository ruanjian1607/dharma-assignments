package com.Tyy'sDemo.GroceryThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class grocery {
    public static void main(String[] args) {
       ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new SubThread());
        pool.submit(new SubThread());
    }
}
