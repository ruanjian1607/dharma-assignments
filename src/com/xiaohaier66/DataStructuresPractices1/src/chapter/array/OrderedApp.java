package chapter.array;

class OrdArray{
    private long[] a;
    private int nElems;

    public OrdArray(int max){
        a = new long[max];
        nElems = 0;
    }
    public int size(){return nElems;}
    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true){
            curIn = (lowerBound + upperBound)/2;
            if(a[curIn] == searchKey)
                return curIn;
            else if(lowerBound > upperBound)
                return nElems;
            else{
               if(a[curIn] < searchKey)
                   lowerBound = curIn + 1;
               else
                   upperBound = curIn - 1;
            }
        }
    }
    public void insert(long value){
        int j;
        for(j=0;j<nElems;j++)
            if(a[j] > value)
                break;
        for(int k = nElems; k > j;k--)
            a[k] = a[k-1];
        a[j] = value;
        nElems++;
    }
    public boolean delete(long value){
        int  j = find(value);
        if(j == nElems)
            return false;
        else{
            for(int k = j;k<nElems;k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }
    public void insert2(long value){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        if(value <= a[lowerBound])
            curIn = lowerBound;
        else if(value >= a[upperBound])
            curIn = upperBound + 1;
        else{
            while(true){
                if(lowerBound == upperBound-1){
                    curIn = upperBound;
                    break;
                }
                else {
                    curIn = (lowerBound + upperBound)/2;
                    if(value > a[curIn])
                        lowerBound = curIn;
                    else if(value < a[curIn])
                        upperBound = curIn;
                    else
                        break;
                }
            }
        }

        for(int k = nElems;k>curIn;k--){
            a[k] = a[k-1];
        }
        a[curIn] = value;
        nElems++;

    }
    public boolean delete2(long value){
        int j = find(value);
        if(j == nElems)
            return false;
        for(int k=j;k<nElems;k++){
            a[k] = a[k+1];
        }
        nElems--;
        return true;
    }
    public void display(){
        for(int  j=0;j<nElems;j++)
            System.out.print(a[j]+" ");
        System.out.println("");
    }
    public OrdArray merge(OrdArray arr1, OrdArray arr2){
        OrdArray arr = new OrdArray(arr1.size()+arr2.size());
        int i=0,j=0;
        while (i<arr1.size() && j<arr2.size()){
            if( arr1.a[i] <= arr2.a[j]){
                arr.a[arr.nElems++]=arr1.a[i++];
            }
            if( arr2.a[j] < arr1.a[i]){
                    arr.a[arr.nElems++] = arr2.a[j++];
            }
        }
        while (i<arr1.size()){
            arr.a[arr.nElems++] = arr1.a[i++];
        }
        while(j<arr2.size()){
            arr.a[arr.nElems++] = arr2.a[j++];
        }
        return arr;
    }
}
public class OrderedApp {
    public OrderedApp(){
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);
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
        /*search for item*/
        int searchKey = 55;
        if(arr.find(searchKey) != arr.size())
            System.out.println("Found "+ searchKey);
        else
            System.out.println("Can't find "+ searchKey);
        /*display items*/
        arr.display();
        /*delete 3 items*/
        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
        /*display items again*/
        arr.display();
        /*delete 3 items by delete2*/
        arr.delete2(33);
        arr.delete2(77);
        arr.delete2(11);
        /*display again*/
        arr.display();
        /*insert2 */
        arr.insert2(32);
        arr.insert2(34);
        arr.insert2(98);
        arr.insert2(0);
        arr.display();

        OrdArray array = new OrdArray(maxSize);
        array.insert(78);
        array.insert(89);
        array.insert(65);
        array.insert(37);
        array.insert(20);
        System.out.print("array: ");
        array.display();
        System.out.print("arr: ");
        arr.display();
        OrdArray arrmerge = arr.merge(arr,array);
        System.out.print("arrmerge: ");
        arrmerge.display();

    }
}
