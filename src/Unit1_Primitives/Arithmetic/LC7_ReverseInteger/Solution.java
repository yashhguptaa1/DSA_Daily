package Unit1_Primitives.Arithmetic.LC7_ReverseInteger;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

public class Solution {

    public int reverse(int x) {

        /*
        Case 1: (-ve num :x) % (+ve num :y)
        Case 2: (+ve num :x) % (+ve num :y)
        Case 3: (+ve num :x) % (-ve num :y)

        In case 1 and 2 we get same answer
        only difference is a negative sign is appended in case 1

        case 1 and 2 are used in this question
         */

        int rev=0;

        //we dont consider loop cond while(x>0)
        //cauz we are dealing with -ve nums also
        while(x!=0)
        {
            int pop=x%10; //obtaining last digit
            x=x/10; //removing last digit

            /*
            According to last statement of question
            For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

            Range of int in java

            -2,147,483,648 .. 2,147,483,647
             */

            //Positive Integer Overflow check
            if(rev>Integer.MAX_VALUE/10)
                return 0;

            //Negative Integer Overflow check
            if(rev<Integer.MIN_VALUE/10)
                return 0;



            rev=rev*10+pop;
        }
        return rev;
    }

    // tests
    @Test
    public void singleInteger() {

        int ip= 3;
        final int actual = reverse(ip);
        //System.out.println(actual);
        final int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void negativeInteger() {
        int ip= -32;
        final int actual = reverse(ip);
        //System.out.println(actual);
        final int expected = -23;
        assertEquals(expected, actual);

    } @Test
    public void normalInteger() {
        int ip= 328912;
        final int actual = reverse(ip);
        //System.out.println(actual);
        final int expected = 219823;
        assertEquals(expected, actual);
    } @Test
    public void PositiveIntegerOverflow() {
        int ip= 2147483642;
        final int actual = reverse(ip);
        System.out.println(actual);
        final int expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void NegativeIntegerOverflow() {
        int ip= -2147483647;
        final int actual = reverse(ip);
        //System.out.println(actual);
        final int expected = 0;
        assertEquals(expected, actual);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Unit1_Primitives.Arithmetic.LC7_ReverseInteger.Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        } }
}
