package com.dharma;

import static com.dharma.Iformula.positive;

interface Iformula {
    double caculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(positive(a));
    }

    static positive(int a) {
        return a > 0 ? a : 0;
    }

    default void log(Number result) {
        System.out.println(result);
    }
}

class Formula implements Iformula{
    @Override
    public double calculate(int a){
        double result = sqrt((int) sqrt(a));
    }
}


public class DefaultMethod{
    public static void main(String[] args) {
        Iformula formula = new Iformula() {
            @Override
            public double caculate(int a) {
                double result = sqrt((int) sqrt(a));
                log(result);
                return result;
            }
        };
        formula.caculate(100);
        formula.log(123.45);
        formula.log(positive(-10));

        Iformula fomula2 = new Formula();
        formula.caculate(100);
        formula.log(123.45);
        formula.log(positive(-10));

        Iformula formula3 = Math::abs;



    }
}