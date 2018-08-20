package ThreadGrocei;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;

public class GroceriesThread implements Runnable {
    private static int sum = 0;
    private static int onesum = 0;
    private static int count = 0;
    private final Object MUTEX = new Object();
    private static Commoditys commoditys = new Commoditys();
    @Override
    public void run() {
        synchronized (MUTEX){
            GroceriesThread.buy();
        }
    }
    public static void buy(){
        int index = (int)(1+Math.random()*9);
        Commodity commodity = commoditys.commodities.get(index);
        commoditys.remove(index);
        onesum += commodity.getPrice();
        sum += commodity.getPrice();
        count ++;
        System.out.println(commodity.getName() + "  " + commodity.getPrice());
    }

    public static void main(String[] args) throws InterruptedException {
        int time = 0;
        commoditys.commodities.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        while (time == 0){
            System.out.println("请输入您的购物昵称：");
            String name = scanner.nextLine();
            System.out.println("请输入您即将购物个数：");
            int num = scanner.nextInt();
            GroceriesThread.thread(name,num);
            System.out.println("是否继续结账？");
            System.out.println(" 0 ：是");
            System.out.println(" 1 ：否");
            time = scanner.nextInt();
        }
        commoditys.commodities.forEach(System.out::println);

        System.out.println("今天共出售了" + count+ "件物品， " + "共" + sum + "元");



    }
    public static void thread(String name,int num) throws InterruptedException {
        System.out.println("您购买了：");
        onesum = 0;
        for (int i = 0;i < num;i++){
            Thread thread = new Thread(new GroceriesThread(),name);
            thread.start();
            thread.join();
        }
        System.out.println(name + " 购买了"+num+"件物品,"+"共消费：" + onesum + "元") ;
    }
}
