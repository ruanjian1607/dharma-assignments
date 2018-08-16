package com.dharma;

public class BasicFunctional {
        public static void main(String[] args) {
            Consumer<String> c1 = x -> System.out.println(x.toLowerCase());
            Consumer<String> c2 = x -> System.out.println(x.toLowerCase());
            c2.andThen(c1).accept("jhw");
        }
    }

