package Lesson_14_testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testCalculateFactorial(int input, long expected) {
        long result = FactorialCalculator.calculateFactorial(input);
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialNegative() {
        FactorialCalculator.calculateFactorial(-1);
    }
}