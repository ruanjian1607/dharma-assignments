package ThreadGrocei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Commoditys implements Iterable{
    public List<Commodity> commodities = new ArrayList<>();

    public Commoditys() {
        commodities.add(new Commodity("哈根达斯",1,30,40));
        commodities.add(new Commodity("老冰棍",2,3,20));
        commodities.add(new Commodity("巧乐兹",3,10,30));
        commodities.add(new Commodity("糯米团子",4,1,14));
        commodities.add(new Commodity("方便面",5,5,60));
        commodities.add(new Commodity("奥利奥",6,17,30));
        commodities.add(new Commodity("棉花糖",7,6,10));
        commodities.add(new Commodity("卫龙",8,4,20));
        commodities.add(new Commodity("巧克力",9,100,100));
        commodities.add(new Commodity("依能",10,2,100));
    }

    public void remove(int index) {
        if(commodities.get(index).getNumber() == 0){
            System.out.println("该物品已售空");
        }else {
            int num = commodities.get(index).getNumber()-1;
            commodities.get(index).setNumber(num);
            System.out.println(commodities.get(index));
        }

    }


    @Override
    public Iterator iterator() {
        return commodities.iterator();
    }
}
