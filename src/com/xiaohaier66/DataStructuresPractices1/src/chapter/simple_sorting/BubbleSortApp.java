package chapter.simple_sorting;

import java.util.Vector;

class ArrayBub{
    private long[] a;
    private int nElems;
    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
    }
    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }
    public void display(){
        for(int j=0;j<nElems;j++)
            System.out.print(a[j] +" ");
        System.out.println(" ");
    }
    public void bubbleSort(){
        int out, in;
        for(out = nElems-1; out>1;out--)
            for(in = 0;in < out;in++)
                if(a[in]>a[in+1])
                    swap(in,in+1);
    }
    public void bubbleSort2(){
        int out, in ,out2 = 0;
        for(out = nElems-1; out>out2+1;out--){
            for(in =out2; in < out;in++)
                if(a[in]>a[in+1])
                    swap(in,in+1);
            for(in =out-1;in > out2+1;in--)
                if(a[in] < a[in-1])
                    swap(in,in-1);
        }
    }
    public int[] oddEvenSort(){
        boolean flag = true;
        int count[] = new int[]{0,0};
        while(flag){
            flag = false;
            for(int i=0;i<nElems-1;i+=2){
                if(a[i] >a[i+1]){
                    swap(i,i+1);
                    flag = true;
                }
                count[0]++;
            }
            for(int i=1;i<nElems-1;i+=2){
                if(a[i] > a[i+1]){
                    swap(i,i+1);
                    flag = true;
                }
                count[1]++;
            }
        }
        return count;
    }
    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
public class BubbleSortApp {
    public BubbleSortApp(){
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        /*insert 10 items*/
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        /*display items*/
        arr.display();
        /*bubble sort them*/
        arr.bubbleSort();
        arr.display();

        ArrayBub arr2;
        arr2 = new ArrayBub(maxSize);
        /*insert 10 items*/
        arr2.insert(77);
        arr2.insert(99);
        arr2.insert(44);
        arr2.insert(55);
        arr2.insert(22);
        arr2.insert(88);
        arr2.insert(11);
        arr2.insert(00);
        arr2.insert(66);
        arr2.insert(33);
        /*display items*/
        arr2.display();
        /*bubble sort them*/
        arr2.bubbleSort2();
        arr2.display();

         ArrayBub arr3;
        arr3 = new ArrayBub(maxSize);
        /*insert 10 items*/
        arr3.insert(77);
        arr3.insert(99);
        arr3.insert(44);
        arr3.insert(55);
        arr3.insert(22);
        arr3.insert(88);
        arr3.insert(11);
        arr3.insert(00);
        arr3.insert(66);
        arr3.insert(33);
        /*display items*/
        arr3.display();
        /*bubble sort them*/
        int[] count2 = arr3.oddEvenSort();
        arr3.display();
        System.out.println("j为偶数，循环次数："+count2[0]);
        System.out.println("j为奇数，循环次数："+count2[1]);

          ArrayBub arr4;
        arr4 = new ArrayBub(maxSize);
        /*insert 10 items*/
        arr4.insert(77);
        arr4.display();

        ArrayBub arr5;
        arr5 = new ArrayBub(maxSize);
        arr5.insert(66);
        arr5.insert(33);
        /*display items*/
        arr5.display();;

        /*bubble sort them*/
        int[] count = arr5.oddEvenSort();
        arr5.display();
        System.out.println("j为偶数，循环次数："+count[0]);
        System.out.println("j为奇数，循环次数："+count[1]);



    }
}
