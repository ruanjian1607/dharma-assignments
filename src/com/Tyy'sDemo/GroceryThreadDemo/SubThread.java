package GroceryThreadDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class SubThread  implements Runnable {
    static Collection<produce> grocery;
    ReentrantLock lock = new ReentrantLock();
    static {
        grocery  = new ArrayList();
        produce p1 =  new produce("蛋糕",2);
        produce p2 =  new produce("牛奶",1);
        produce p3 =  new produce("洁面乳",1);
        produce p4 =  new produce("水杯",2);
        produce p5 =  new produce("皮带",0);
        produce p6 =  new produce("电脑",2);
        produce p7 =  new produce("手机",1);
        produce p8 =  new produce("巧克力",2);
        grocery.add(p1);
        grocery.add(p2);
        grocery.add(p3);
        grocery.add(p4);
        grocery.add(p5);
        grocery.add(p6);
        grocery.add(p7);
        grocery.add(p8);
        Iterator it  = grocery.iterator();
        while(it.hasNext()){
            produce p  = (produce)it.next();
            if(p.getPro_count()==0){
                grocery.remove(p.getPro_name());
            }else {
                //p.setPro_count(p.getPro_count()-1);
                System.out.println("商品名：" + p.getPro_name() + "----" + "库存：" + p.getPro_count());
            }
        }
        System.out.println("----------------所有商品信息如上--------------");

    }
    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "开始购物");
        for (produce p : grocery) {
            if (p.getPro_count() > 0) {
                System.out.println(Thread.currentThread().getName() + "成功购买：" + p.getPro_name());
                p.setPro_count(p.getPro_count()-1);
            }else{
                System.out.println(Thread.currentThread().getName() + "购买" + p.getPro_name()+"失败" );
            }
        }
        lock.unlock();
    }
}