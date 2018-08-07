import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

}

class Products {
    Product product1 = new Product(1,"Iphone",8000);
    Product product2 = new Product(2,"Huawei",7000);
    Product product3 = new Product(3,"Xiaomi",6000);
    Product product4 = new Product(4,"Oppo",5000);

    public Products() {
        Map<Integer,List<Object>> map = new HashMap<>();

        List<Object> list1 = new ArrayList<Object>();
        list1.add(product1.getName());
        list1.add(product1.getPrice());

        List<Object> list2 = new ArrayList<Object>();
        list2.add(product2.getName());
        list2.add(product2.getPrice());

        List<Object> list3 = new ArrayList<Object>();
        list3.add(product3.getName());
        list3.add(product3.getPrice());

        List<Object> list4 = new ArrayList<Object>();
        list4.add(product4.getName());
        list4.add(product4.getPrice());

        map.put(product1.getId(),list1);
        map.put(product2.getId(),list2);
        map.put(product3.getId(),list3);
        map.put(product4.getId(),list4);

        Set<Map.Entry<Integer,List<Object>>> entrySet = map.entrySet();
        System.out.println(entrySet);
    }
}

public class GroceryHashMap {

    public static void main(String[] args) {
        new Products();
    }
}
