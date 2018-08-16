package Java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class BasicLambda {

    private static boolean isPrime(int number){
//        if(number < 2){
//            return false;
//        }
//
//        for (int i = 2;i < number;i++){
//            if(number % i == 0){
//                return false;
//            }
//        }
//        return true;

        return number > 1 && IntStream.range(2,number).allMatch(n -> number % n != 0);
    }

    public static int findSquarOfMaxOdd(List<Integer> number){
        return number.stream()
                .filter(i -> i % 2 != 0)
                .filter(i -> i > 3)
                .filter(i -> i < 100)
                .max(Comparator.naturalOrder())
                .map(i -> i * i)
                .get();
    }

    private static void o(Object o){

        System.out.println(o);
    }
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(11,2,8,7,3,4,9,6,6));

        o(findSquarOfMaxOdd(numbers));
        o(isPrime(22));
    }
}
