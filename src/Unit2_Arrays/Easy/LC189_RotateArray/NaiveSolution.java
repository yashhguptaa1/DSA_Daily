package Unit2_Arrays.Easy.LC189_RotateArray;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Arrays;

import static junit.framework.TestCase.failNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NaiveSolution {


    public int[] rotate(int[] nums, int k) {

        int n=nums.length;

        if(n==0 || k==0)
            return nums;

        k=k%n;

        while(k-- > 0)
        {
            int rotateElement=nums[n-1];

            for(int i=n-1;i>0;i--)
            {
                nums[i]=nums[i-1];

            }
            nums[0]=rotateElement;
        }
        return nums;

    }
    // tests
    @Test
    public void singleInteger() {

        int ip[]=new int[]{3};
        final int actual[]=rotate(ip,1);
        final int expected[] = new int[]{3};
        assertTrue(Arrays.equals(expected,actual));
    }
    @Test
    public void sampleTestCase() {
        int ip[]=new int[]{1,2,3,4,5,6,7};
        final int actual[]=rotate(ip,3);
        final int expected[] = new int[]{5,6,7,1,2,3,4};
        assertTrue(Arrays.equals(expected,actual));


    } @Test
    public void kBiggerThanSizeOfArray() {
        int ip[]=new int[]{1,2,3,4,5};
        final int actual[]=rotate(ip,7);
        System.out.println(Arrays.toString(actual));
        final int expected[] = new int[]{4,5,1,2,3};
        assertTrue(Arrays.equals(expected,actual));

    } @Test
    public void EmptyTestCase() {
        int ip[]=new int[]{};
        final int actual[]=rotate(ip,1);
        final int expected[] = new int[]{};
        assertTrue(Arrays.equals(expected,actual));

    }
    @Test
    public void kSameAsSize() {
        int ip[]=new int[]{1,2,3,4,5,6,7};
        final int actual[]=rotate(ip,7);
        final int expected[] = new int[]{1,2,3,4,5,6,7};
        assertTrue(Arrays.equals(expected,actual));

    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Unit2_Arrays.Easy.LC189_RotateArray.NaiveSolution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
