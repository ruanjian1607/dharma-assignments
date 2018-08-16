package Java8;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitStream {
    private static Stream<String> initByBuilder(){
      return Stream.<String>builder()
                .add("web")
                .add("java")
                .add("c")
                .add("os")
                .build();
       // return stream;
    }

    private static Stream<String> initByCollection(){
        Set<String> names = new HashSet<>();
        names.add("java");
        names.add("Damo");
        names.add("2018");
        names.add("(2)");

        return names.stream();
    }

    private static void initByOf(){
        Stream<String> stream = Stream.of("we are Damo");
    }

    public static void main(String[] args) {
        Stream<String> stream = initByBuilder();
        stream.forEach(System.out::println);

        Stream<String> stream1 = initByCollection();
        stream1.forEach(System.out::println);

        Stream<String> stream2 = Stream.empty();
        stream2.forEach(System.out::println);

        IntStream stream3 = IntStream.rangeClosed(1,6);
        stream3.forEach(System.out::println);

        Stream<String> stream4 = Stream.of("we are damo");
        stream4.forEach(System.out::println);

        String[] StreamArray = {"we","are","a","Damo"};
        Stream<String> stream6 = Stream.of("we are damo");
        stream6.forEach(System.out::println);

        Stream<Integer> stream5 = Stream.generate(new Random()::nextInt);
        stream5.limit(10).forEach(System.out::println);
    }
}
