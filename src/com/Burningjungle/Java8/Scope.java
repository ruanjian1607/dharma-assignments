package Java8;

import java.util.function.Function;

public class Scope {
    private Scope(){
        Function<String,String> func = x -> {
            System.out.println(this);
            return x;
        };
        System.out.println(func.apply("Damo"));
    }

    public static void main(String[] args) {
        new Scope();
    }
}
