package Java8;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperateStream {
    private static void runMan(){
        DoubleStream.of(1.5,1.8,3.2,10,90)
                .map(Math::cos)
                .forEach(System.out::println);
    }



    private static void runFlatMap(){
        IntStream.range(1,5)
                .flatMap(n -> IntStream.of(n,n * n))
                .forEach(System.out::println);
    }
    private static void runPeek(){
        IntStream.rangeClosed(1,5)
                .peek(System.out::println)
                .filter(n -> n %2 == 1)
                .peek(System.out::println)
                .mapToDouble(Math::sqrt)
                .peek(System.out::println)
                .sum();
    }

    private static void runReduce() {
        int sum = IntStream.rangeClosed(1, 5)
                .reduce(0, (left, right) -> left + right);
        System.out.println(sum);

    }

    private static void runStat(){
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(100.0);
        stats.accept(2035.0);
        stats.accept(5028.0);
        stats.accept(82.0);
        stats.accept(81.0);
        stats.accept(83.0);
        stats.accept(2018.0);

        long count = stats.getCount();
        double sum = stats.getSum();
        double avarage = stats.getAverage();
        double min = stats.getMin();
        double max = stats.getMax();

        System.out.printf("count = %d,sum = %.2f,min = %.2f,max = %.2f,avarange = %.2f",count,sum,min,max,avarage);
    }

    public static void main(String[] args) {
        runMan();
        runFlatMap();
        runPeek();

    }
}
