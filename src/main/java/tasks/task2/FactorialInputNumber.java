package tasks.task2;

import java.util.*;

public class FactorialInputNumber {
    public static void main(String[] args) {

        int factorial = chekToNumber();
        factorialNumber(factorial);

    }

    private static Integer chekToNumber() {

        int integer;

        Scanner scanner = new Scanner(System.in);
        integer = scanner.nextInt();

        while (integer < 0) {
            System.out.println("введите положительное число");
            integer = scanner.nextInt();
        }
        return (Objects.isNull(integer)) ? 0 : integer;
    }

    private static void factorialNumber(Integer integer) {
        Integer factorial = 1;
        for (int i = 1; i <= integer; i++) {
            factorial = factorial * i;
        }
        System.out.println(factorial);
    }
}

