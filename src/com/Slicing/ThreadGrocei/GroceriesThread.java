package ThreadGrocei;

import java.util.Scanner;

public class GroceriesThread implements Runnable {
    private static int sum = 0;
    private static int count = 0;
    @Override
    public void run() {
        Commoditys commoditys = new Commoditys();
        int index = (int)(1+Math.random()*9);
        Commodity commodity = commoditys.commodities.get(index);
        sum += commodity.getPrice();
        count ++;
        System.out.println(commodity.getName() + "  " + commodity.getPrice());
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的购物昵称：");
        String name = scanner.nextLine();
        System.out.println("请输入您即将购物个数：");
        int num = scanner.nextInt();
        GroceriesThread.thread(name,num);
        System.out.println("今天共出售了" + count+ "件物品， " + "共" + sum + "元");


    }
    public static void thread(String name,int num) throws InterruptedException {
        System.out.println("您购买了：");
        for (int i = 0;i < num;i++){
            Thread thread = new Thread(new GroceriesThread(),name);
            thread.start();
            thread.join();
        }
        System.out.println(name + " 购买了"+count+"件物品,"+"共消费：" + sum + "元") ;
    }
}
