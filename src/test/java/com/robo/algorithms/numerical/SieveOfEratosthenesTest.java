package com.robo.algorithms.numerical;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.*;

public class SieveOfEratosthenesTest {
    private SieveOfEratosthenes sieveOfEratosthenes;
    private static long MINUTE_IN_MILLISECONDS = 60000;
    private static Integer LARGE_INT = 10000000;

    @Before
    public void setUp() {
        this.sieveOfEratosthenes = new SieveOfEratosthenes();
    }

    @Test
    public void testGetPrimeWithSmallRange() {
        List<Integer> primes = this.sieveOfEratosthenes.getPrimes(1, 20);
        Integer[] expected = {2, 3, 5, 7, 11, 13, 17, 19};
        assertArrayEquals(expected, primes.toArray());
    }

    @Test
    public void testGetPrimeWithOffset() {
        List<Integer> primes = this.sieveOfEratosthenes.getPrimes(10, 20);
        Integer[] expected = {11, 13, 17, 19};
        assertArrayEquals(expected, primes.toArray());
    }

    /**
     * Test the time getPrimes takes to compute
     * primes from 1 to 10 million should be 
     * less than a minute
     */
    @Test
    public void testGetPrimeWithLargeRange() {
        long start = Calendar.getInstance().getTimeInMillis();
        this.sieveOfEratosthenes.getPrimes(1, LARGE_INT);
        long stop = Calendar.getInstance().getTimeInMillis();
        long timeTaken = stop - start;
        assertTrue(timeTaken <= MINUTE_IN_MILLISECONDS);
    }

    @Test
    public void testGetPrimeWithZeroRangeAndExistingPrime() {
        List<Integer> primes = this.sieveOfEratosthenes.getPrimes(3, 3);
        Integer[] expected = {3};
        assertArrayEquals(expected, primes.toArray());
    }

    @Test
    public void testGetPrimeWithZeroRangeAndNoPrime() {
        List<Integer> primes = this.sieveOfEratosthenes.getPrimes(6, 6);
        assertTrue(primes.isEmpty());;
    }
}