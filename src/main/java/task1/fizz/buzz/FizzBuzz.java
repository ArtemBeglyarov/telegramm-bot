package task1.fizz.buzz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FizzBuzz {

    public static void main(String[] args) {
        moduleDivision();
    }

    private static void moduleDivision() {

        List<Integer> ints = new ArrayList<>(100);

        int test = 1;
        while (test <= 100) {
            ints.add(test);
            test++;
        }

        ints.forEach((x) -> {
            Object t = unknown(x);
            System.out.println(t);
        });
    }

    private static Object unknown(Integer integer) {
        Object t;
        if (integer % 15 == 0) {
            t = OutWord.FizzBuzz;
            return t;
        }
        if ((integer % 5 == 0)) {
            t = OutWord.Buzz;
            return t;
        }
        if (integer % 3 == 0) {
            t = OutWord.Fizz;
            return t;
        } else return (t = integer);
    }

    enum OutWord {
        Fizz,
        Buzz,
        FizzBuzz;
    }
}
