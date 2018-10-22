package chapter.simple_sorting;

class ArraySel{
    private long[] a;
    private int nElems;
    public ArraySel(int max){
        a = new long[max];
        nElems = 0;
    }
    public void insert(long value){
        a[nElems++] = value;
    }
    public void display(){
        for(int j=0;j<nElems;j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
    public void selectSort(){
        int out, in, min;
        for(out=0;out <nElems -1;out++){
            min = 0;
            for(in = out+1;in<nElems;in++)
                if(a[in] < a[min])
                    min = in;
            swap(out,min);
        }
    }
    private void swap(int one,int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
public class SelectSortApp {
    public SelectSortApp(){
        int maxSize = 100;
        ArraySel arr;
        arr = new ArraySel(maxSize);
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
        arr.display();
        /* selection-sort them*/
        arr.selectSort();
        arr.display();
    }
}
