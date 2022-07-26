package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class NumberWorkerTest {
    NumberWorker number = new NumberWorker();
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 17, 31, 79, 97, 131})
    public void isPrimeForPrimes(int num) {
     assertTrue(number.isPrime(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {222, 4, 6, 8, 10, 20, 40, 132})
    public void isPrimeForNotPrimes(int num) {
        assertFalse(number.isPrime(num));
    }
    @ParameterizedTest
    @ValueSource(ints = {-54875, 0, 1, -1})
    public void isPrimeForIncorrectNumbers(int num) {
        assertThrows(NumberWorker.IllegalNumberException.class, () -> {number.isPrime(num);});
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/data.csv", numLinesToSkip = 1)
    public void checkDigitsSum(int input, int expected) {
        assertEquals(expected, number.digitsSum(input));
    }
}
