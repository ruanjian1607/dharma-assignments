package PokerGameDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/*需求：随机发牌，并使看牌的结果有序排列
 *分析：最后看牌的结果要用TreeSet来存储
 *	1.创建HashMap集合来存储序号和对应牌的内容
 *	2.创建ArrayList来存储序列，用于发牌
 *	3.看牌有特有的方法
*/
public class PokerDemo2 {
	public static void main(String[] args) {
		//1.创建HashMap存储内容
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		//2.创建ArrayList存储序号
		ArrayList<Integer> array = new ArrayList<Integer>();
		//3.存牌
		//首先要有color和number数组
		String[] color = {"黑桃","红桃","方片","梅花"};
		String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A","2"};
		int index = 0;
		//以3作为最小值开始拼接字符串并存入牌
		for(String n : number){
			for(String c : color){
				String s = c.concat(n);
				array.add(index);
				hm.put(index, s);
				index++;
			}
		}
		//大小王进入牌盒
		hm.put(index,"小王");
		array.add(index);
		index++;
		hm.put(index,"大王");
		array.add(index);
		
		/*System.out.println(hm);
		System.out.println(array);*/
		
		//4.洗牌
		Collections.shuffle(array);
		//5.发牌
		TreeSet<Integer> p1 = new TreeSet<Integer>();
		TreeSet<Integer> p2 = new TreeSet<Integer>();
		TreeSet<Integer> p3 = new TreeSet<Integer>();
		TreeSet<Integer> dp = new TreeSet<Integer>();
		
		for(int i  = 0;i<array.size();i++){
			if(i>= array.size()-3){
				dp.add(array.get(i));
			}else if(i%3==0){
				p1.add(array.get(i));
			}else if(i%3==1){
				p2.add(array.get(i));
			}else if(i%3==2){
				p3.add(array.get(i));
			}
		}
		//6.看牌
		LookPoker("甲",p1,hm);
		LookPoker("乙",p2,hm);
		LookPoker("丙",p3,hm);
		LookPoker("底牌",dp,hm);
	}
	//要写个看牌方法
	public static  void LookPoker(String name,TreeSet<Integer> ts,HashMap<Integer,String> hm){
		System.out.println(name+"的牌是：");
		for(Integer key: ts){
			String value = hm.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
	}
}
