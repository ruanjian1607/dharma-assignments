package chapter.simple_sorting;

class ArrayIns{
    private long[] a;
    private int nElems;
    public ArrayIns(int max){
        a = new long[max];
        nElems = 0;
    }
    public void insert(long value){
        a[nElems++] = value;
    }
    public void display(){
        for(int j=0;j<nElems;j++)
            System.out.print(a[j]+ " ");
        System.out.println(" ");
    }
    public void insertionSort(){
        int in,out;
        int cop = 0,comp = 1;
        int[] count = new int[]{0,0};
        for(out = 1;out<nElems;out++){
            count[comp]++;
            long temp = a[out];
            in = out;
            count[cop] += 2;
            while(in>0){
                count[comp]++;
                if (a[in-1] > temp) {
                    count[comp]++;
                a[in] = a[in-1];
                in--;
                count[cop]++;
// note:a[in]=a[in-1];in--;<=> a[in--]=a[in]
                }
                else
                    break;
            }
            a[in] = temp;
            count[0]++;
        }
        System.out.println("count of copy: "+count[cop]);
        System.out.println("count of compare: " + count[comp]);
        System.out.println("count of all: "+(count[cop]+count[comp]));
    }
    public void insertionSort2(){
        int in,out;
        int count=0;
        for(out = 1;out<nElems;out++){
            long temp = a[out];
            boolean flag = false;
            in = out;
            while(in>0){
                if(a[in-1]>temp){
                    in--;
                }
                else if(a[in-1] == temp){
                    count++;
                    in = 0;
                    break;
                }
                else
                    break;
            }
            for(int i=out;i>in;i--){
                a[i] = a[i-1];
            }
            a[in] = temp;
            for(int i=0;i<count;i++){
                a[i] = a[i+count];
            }
        }
        for(int i = count ;i<nElems;i++){
            a[i-count] = a[i];
        }
        nElems -= count;
   }
    public long median(){
        insertionSort();
        return a[(nElems-1)/2];
    }
    public void noDups(){
        int n=0;
        for(int i=0;i<nElems;i++){
            if(a[i] == a[i+1]){
                n++;
            }
            else{
                a[i-n] = a[i];
            }
        }
        nElems -= n;
    }
}
public class InsertSortApp {
    public InsertSortApp(){
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        /*insert 10 items*/
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(00);
        arr.insert(66);
        arr.insert(99);
        arr.insert(33);
        arr.insert(33);
        arr.display();
        /* insertion-sort them*/
        arr.insertionSort();
        arr.display();
        System.out.println("Median: "+arr.median());
        arr.noDups();
        arr.display();

        ArrayIns arr2;
        arr2 = new ArrayIns(maxSize);
        /*insert 10 items*/
        arr2.insert(77);
        arr2.insert(99);
        arr2.insert(44);
        arr2.insert(55);
        arr2.insert(22);
        arr2.insert(88);
        arr2.insert(11);
        arr2.insert(00);
        arr2.insert(00);
        arr2.insert(66);
        arr2.insert(99);
        arr2.insert(33);
        arr2.insert(33);
        arr2.display();
        /* insertion-sort them*/
        arr2.insertionSort2();
        arr2.display();
    }


}
