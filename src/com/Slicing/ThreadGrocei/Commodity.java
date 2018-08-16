package ThreadGrocei;

import java.util.Random;

public class Commodity {
    private String name;
    private int id;
    private double price;
    private int number;

    public Commodity(String name, int id, double price, int number) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
