package Unit1_Primitives.PrimeNumbers.LC204_CountPrimes;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

public class Solution {

    public int countPrimes(int n) {

        //Case for all -ve nums
        //including num=0
        //and num=1
        if(n<=1)
            return 0;

        //Positive Integer Overflow check
        if(n>Integer.MAX_VALUE/10)
            return 0;

        //Negative Integer Overflow check
        if(n<Integer.MIN_VALUE/10)
            return 0;

        //since in question it is asked to tell less than n
        //we create primes of size n
        //if we had to tell primes numbers inclusive of n
        //then primes size would be n+1
        boolean primes[]=new boolean[n];

        //we denote prime numbers by placing true on their respective indices
        for(int i=0;i<n;i++)
            primes[i]=true;

        /*
        Reducing Time complexity by checking till square root
        the maximum smallest root of a number is its squareroot
        for all the roots greater than squareroot they have already been checked
        by roots less than the squareroot
         */
        for(int i=2;i*i<n;i++)
        {
            //allocating multiples of any number not prime

            for(int j=i;j*i<n;j++)
            {
                primes[j*i]=false;
            }
        }

        int count=0;

        for(int i=2;i<n;i++)
            if(primes[i])
                count++;

        return count;
    }


    // tests
    @Test
    public void singleIntegerNotPrime() {

        int ip=1 ;
        final int actual = countPrimes(ip);
        //System.out.println(actual);
        final int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void singleIntegerPrime() {

        int ip= 3;
        final int actual = countPrimes(ip);
        System.out.println(actual);
        //note the ans is = 1 and not 2 .i.e we want prime numbers less than n=3
        final int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void negativeInteger() {
        int ip= -32;
        final int actual = countPrimes(ip);
        //System.out.println(actual);
        final int expected = 0;
        assertEquals(expected, actual);

    } @Test
    public void normalInteger() {
        int ip= 100;
        final int actual = countPrimes(ip);
        //System.out.println(actual);
        final int expected =25 ;
        assertEquals(expected, actual);
    } @Test
    public void PositiveIntegerOverflow() {
        int ip= 2147483647;
        final int actual = countPrimes(ip);
        System.out.println(actual);
        final int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void NegativeIntegerOverflow() {
        int ip= -2147483647;
        final int actual = countPrimes(ip);
        //System.out.println(actual);
        final int expected = 0;
        assertEquals(expected, actual);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Unit1_Primitives.PrimeNumbers.LC204_CountPrimes.Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        } }
}