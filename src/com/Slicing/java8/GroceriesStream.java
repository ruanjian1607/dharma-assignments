package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceriesStream {
    public static List<Commodity> commodities = Commoditys.create();
    private static int sum = 0;

    static double shopping(int num){
        List<Commodity> list = new ArrayList<>();
        System.out.println("您购买了：");
        for (int i=0;i<num;i++){
            int index = (int)(1+Math.random()*9);
            remove(index);
            Commodity good = Commoditys.goods.get(index);
            list.add(good);
            System.out.println("name = "+good.getName() + " price = "+ good.getPrice());
        }
        double totalsum = list.stream()
                .mapToDouble(Commodity::getPrice)
                .sum();
        return totalsum;
    }
    public static void remove(int index) {
        if(Commoditys.goods.get(index).getNumber() == 0){
            System.out.println("该物品已售空");
        }else {
            int num = Commoditys.goods.get(index).getNumber()-1;
            Commoditys.goods.get(index).setNumber(num);
        }

    }
    public static void main(String[] args) {
        //Commoditys._(Commoditys.sum(commodities));
        //Commoditys._(Commoditys.maxPrice(commodities).get());
        System.out.println("请输入购物数量：");
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        double total = shopping(num);
        System.out.println("这是你消费的总额");
        Commoditys._(total);
    }

}
