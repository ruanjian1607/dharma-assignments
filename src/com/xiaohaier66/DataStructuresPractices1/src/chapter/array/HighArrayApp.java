package chapter.array;

class HighArray{
    private long[] a;
    private int nElems;
    public HighArray(int max){
        a = new long[max];
        nElems = 0;
    }
    public boolean find(long searchKey){
        int j;
        for(j =0;j<nElems;j++)
            if(a[j] == searchKey)
                break;
        if(j == nElems)
            return false;
        else
            return true;
    }
    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }
    public boolean delete(long value){
        int j;
        for(j = 0;j<nElems;j++)
            if(value == a[j])
                break;
        if(j == nElems)
            return false;
        else{
            for(int k = j; k<nElems;k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }
    public void display(){
        for(int j=0;j<nElems;j++)
            System.out.print(a[j]+ " ");
        System.out.println("");
    }
    public long getMax(){
        if(0 == nElems)
            return -1;
        long max = a[0];
        for(int i=1;i<nElems;i++){
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }
    public long removeMax(){
        long max = getMax();
        delete(getMax());
        return max;
    }
    public void noDup(){
        HighArray a2 = new HighArray(nElems);
        for(int i=0;i<nElems;i++){
            if(!a2.find(a[i]))
                a2.insert(a[i]);
        }
        for(int i=0;i<a2.nElems;i++){
            if(i<a2.nElems)
                a[i] = a2.a[i];
        }
        nElems = a2.nElems;
    }
}
public class HighArrayApp {
    public HighArrayApp(){
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);
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
        /*search for item*/
        int searchKey = 35;
        if(arr.find(searchKey))
            System.out.println("Found "+ searchKey);
        else
            System.out.println("Can't find "+searchKey);
        /*delete 3 items*/

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
        /*display items again*/
        arr.display();
        /*get max*/
        System.out.println("max of arr: "+arr.getMax());
        /*remove max*/
        arr.removeMax();
        /*display array*/
        arr.display();
        /*order by remove_max*/
        HighArray arr2 = new HighArray(maxSize);
        long max = arr.removeMax();
        while(-1 != max){
            arr2.insert(max);
            max = arr.removeMax();
        }
        /*display arr2*/
        arr2.display();
        /*test noDup*/
        arr2.insert(33);
        arr2.insert(33);
        arr2.insert(88);
        arr2.insert(88);
        arr2.insert(77);
        arr2.display();
        arr2.noDup();
        arr2.display();

    }
}
