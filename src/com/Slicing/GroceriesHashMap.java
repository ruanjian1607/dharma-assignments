package com.Slicing;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Commodity {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Commodity(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int hashCode() {
        if (this.id < 10) {
            return 1;
        } else if (this.id < 20) {
            return 2;
        } else {
            return 3;
        }
    }
    @Override
    public String toString() {
        String type = "";
        if(hashCode() == 1){
            type = "零食";
        }else if(hashCode() == 2){
            type = "饮料";
        }else
            type = "生活用品";
        return   type + "  {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}

public class GroceriesHashMap {
    public static void main(String[] args) {
        Map<Integer,Commodity> groceries = new HashMap<>();
        groceries.put(1,new Commodity(1,"薯片",5));
        groceries.put(2,new Commodity(2,"奶片",8));
        groceries.put(3,new Commodity(11,"果粒橙",3.5));
        groceries.put(4,new Commodity(12,"可乐",3));
        groceries.put(5,new Commodity(21,"牙刷",5));
        groceries.put(6,new Commodity(22,"牙膏",8));
        for(int key : groceries.keySet())
            System.out.println(groceries.get(key));
    }



}

