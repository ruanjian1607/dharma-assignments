package Java8;

import java.io.ObjectInput;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;


public class BasicOptional {

    private static void _(Object o){
        System.out.println(o);
    }

    private static void optionalStream(){
        OptionalInt maxodd = IntStream.of(10,20,30,40).filter(n -> n % 2 == 1).max();
        if (maxodd.isPresent()){
            _(maxodd.getAsInt());
        }else{
            _("stream is null");
        }

    }

    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        _(empty);

        Optional<String> name = Optional.of("jhw");
        _(name);

        String nullString = null;
        Optional<String> nullStr  = Optional.ofNullable(nullString);
        _(nullStr);

        OptionalInt number = OptionalInt.of(2018);
        if (number.isPresent()){
            _(number.getAsInt());
        }else {
            _("number empty");
        }
    }
}
