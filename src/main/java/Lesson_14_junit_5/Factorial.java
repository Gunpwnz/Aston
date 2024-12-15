package Lesson_14_junit_5;

public class Factorial {
    public static int calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не должно быть отрицательным");
        }

        int factorial = number;
        for (int i = (number - 1); i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }
}