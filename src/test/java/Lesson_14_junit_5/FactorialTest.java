package Lesson_14_junit_5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FactorialTest {
    @BeforeAll
    public static void setUpAll() {
        System.out.println("Выполняется до запуска всех тестов");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Выполняется перед каждым тестом");
    }

     @DisplayName("Позитивные проверки на получение факториала числа")
     @ParameterizedTest // Аннотация теста с параметрами
     @ValueSource(ints = { 0, 1, 2, 3, 4, 5 }) // Передаваемые значения
     public void testCalculateFactorial(int input) {
     // Ожидаемые результаты для различных входных значений
     int[] expectedResults = { 0, 1, 2, 6, 24, 120 };

     int result = Factorial.calculate(input);
     Assertions.assertEquals(expectedResults[input], result);
     }

    // @Test
    // public void testCalculate() {
    // assertEquals(1, Factorial.calculate(0));
    // assertEquals(1, Factorial.calculate(1));
    // assertEquals(2, Factorial.calculate(2));
    // assertEquals(6, Factorial.calculate(3));
    // assertEquals(24, Factorial.calculate(4));
    // assertEquals(120, Factorial.calculate(5));
    // }

    // @Test
    // public void testCalculateNegative() {
    // assertThrows(IllegalArgumentException.class, () -> {
    // Factorial.calculate(-1);
    // });
    // }
}
