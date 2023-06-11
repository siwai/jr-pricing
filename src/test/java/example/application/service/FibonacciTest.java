package example.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
    // f(0) = 0
    int fib(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    @Test
    public void testFibonacci(){
        int cases[][] = {
                {0,0},
                {1,1},
                {2,1},
                {3,2}
        };

        for (int i = 0; i < cases.length; i++){
            assertEquals(cases[i][1], fib(cases[i][0]));
        }
    }

    @ParameterizedTest
    @MethodSource("fibonacciProvider")
    public void testFib(int input, int expected) {
        assertEquals(expected, fib(input));
    }

    static Iterable<Integer[]> fibonacciProvider(){
        return Arrays.asList(new Integer[][]{
                {0,0},
                {1,1},
                {2,1},
                {3,2}
        });
    }
}
