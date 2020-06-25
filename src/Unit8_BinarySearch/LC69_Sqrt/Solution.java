package Unit8_BinarySearch.LC69_Sqrt;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

public class Solution {

    public int mySqrt(int x) {

        if(x<=0)
        {
            throw new IllegalArgumentException("SquareRoot cant be found for given input");
        }


        int low=1;
        int high=x;
        int ans=0;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            long tempProd=(long)mid*(long)mid;
            if(tempProd<=(long)x)
            {
                //our current best possible ans
                //as we are not considering decimal part
                ans=mid;

                //check further if we can still come more closer to actual answer
                low=mid+1;
            }
            else
                high=mid-1;//if we overshot
        }
        return ans;
    }

    // tests
    @Test
    public void singleInteger() {

        int ip= 3;
        final int actual = mySqrt(ip);
        //System.out.println(actual);
        final int expected = 1;
        assertEquals(expected, actual);
    }
    @Test(expected = Exception.class)
    public void negativeInteger() {
        int ip= -3;
        final int actual = mySqrt(ip);
        //System.out.println(actual);


    } @Test
    public void PrimeInteger() {
        int ip= 97;
        final int actual = mySqrt(ip);
        //System.out.println(actual);
        final int expected = 9;
        assertEquals(expected, actual);
    } @Test
    public void MaxIntegerPossible() {
        int ip= 2147483647;
        final int actual = mySqrt(ip);
        //System.out.println(actual);
        final int expected = 46340;
        assertEquals(expected, actual);
    }
    @Test
    public void PerfectSquare() {
        int ip= 625;
        final int actual = mySqrt(ip);
        //System.out.println(actual);
        final int expected = 25;
        assertEquals(expected, actual);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Unit8_BinarySearch.LC69_Sqrt.Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
