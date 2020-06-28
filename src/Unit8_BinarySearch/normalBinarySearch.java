package Unit8_BinarySearch;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.failNotEquals;

public class normalBinarySearch {

    public int bs(int arr[],int target)
    {
        int left=0;
        int right=arr.length-1;
        int index=-1;
        while(left<=right)
        {

            int mid=left+(right-left)/2;

            if (target==arr[mid])
                return mid;
            else if(target<arr[mid])
            {
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return index;
    }
    // tests
    @Test
    public void singleInteger() {

        int ip[]=new int[]{3};
        final int actual=bs(ip,1);
        final int expected =-1;
        assertEquals(expected, actual);
    }
    @Test
    public void sampleTestCase() {
        int ip[]=new int[]{1,2,3,4,5,6,7};
        final int actual=bs(ip,3);
        final int expected = 2;
        assertEquals(expected, actual);

    } @Test
    public void duplicatesInArray() {
        int ip[]=new int[]{1,2,3,3,3,3,4,5,5};
        final int actual=bs(ip,4);
        System.out.println(actual);
        final int expected=6;
        assertEquals(expected, actual);
    } @Test
    public void EmptyTestCase() {
        int ip[]=new int[]{};
        final int actual=bs(ip,1);
        final int expected = -1;
        assertEquals(expected, actual);
    }
    @Test
    public void NotSortedArray() {
        int ip[]=new int[]{9,2,1,8,5,4,7};
        final int actual=bs(ip,7);
        System.out.println(actual);
        final int expected=-1;
        assertEquals(expected, actual);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Unit8_BinarySearch.normalBinarySearch.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
