package gof;

import com.sun.rowset.internal.Row;

class Gazillion {
    private static int num = 0;
    private int row;

    Gazillion(int row) {
        this.row = row;
    }

    void print(int col) {
        System.out.print(" " + row + col);
    }
}
//    static void makeMatrix(int rows,int cols){
//        Gazillion[][] matrix = new Gazillion[rows][cols];
//        for (int i = 0;i < rows;i++){
//            for (int j = 0;j < cols;j++){
//                matrix[i][j] = new Gazillion(cols);
//            }
//        }
//        for (int i = 0;i < rows;i++) {
//            for (int j = 0; j < cols; j++) {
//                matrix[i][j].print();
//            }
//            System.out.println(" ");
//        }
//    }
//}

class flyWeightFactory{
    private Gazillion[] pool;

    public flyWeightFactory(int maxRows) {
        this.pool = new Gazillion[maxRows];
    }

    public Gazillion getFlyWeight(int row){
        if (this.pool[row] == null){
            pool[row] = new Gazillion(row);
        }
        return pool[row];
    }


}


public class DemoFlyweight {
    private static final int ROWS =5, COLS = 10;

    public static void main(String[] args) {
        flyWeightFactory factory = new flyWeightFactory(ROWS);
        for (int i = 0; i< ROWS;i++){
            for (int j = 0;j < COLS;j++){
                factory.getFlyWeight(i).print(j);
            }
            System.out.println();
        }
    }
}
