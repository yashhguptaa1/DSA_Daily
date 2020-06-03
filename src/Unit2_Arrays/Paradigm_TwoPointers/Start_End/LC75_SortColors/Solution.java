//No of Attempts:1
package Unit2_Arrays.Paradigm_TwoPointers.Start_End.LC75_SortColors;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

public class Solution {
    public String sortColors(int[] nums) {

        int nRows=nums.length;

        if(nRows<=1)
        {
            throw new IllegalArgumentException("Size of array must be atleast 2");

        }
        int start=0;// ptr to segregate 0
        int end=nRows-1;//ptr to segregate 2

        //ptr to segregate 1
        //ptr to traverse whole array
        int mid=0;

        while (mid<=end)
        {
            switch (nums[mid])
            {
                case 0:
                    swap(start,mid,nums);
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(mid,end,nums);
                    end--;
                    break;

                default:
                    throw new IllegalArgumentException("Number not Allowed");

            }
        }

        StringBuffer res=new StringBuffer("");
        for(int i=0;i<nRows;i++)
        {
            res.append(Integer.toString(nums[i]));
        }
        return res.toString();
    }
    public void swap(int index1,int index2,int arr[])
    {
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

    // tests
    @Test
    public void sampleTest() {

        int ip[]={2,0,2,1,1,0};
        final String actual = sortColors(ip);
        //System.out.println(actual);
        final String expected = "001122";
        assertEquals(expected, actual);
    }
    @Test(expected = Exception.class)
    public void negativeTest() {
        int ip[]={2,0,2,1,-1,0};
        final String actual = sortColors(ip);

    } @Test
    public void onlyTwoColors01() {
        int ip[]={1,0,0,1,1,0};
        final String actual = sortColors(ip);
        final String expected = "000111";
        assertEquals(expected, actual);
    } @Test
    public void onlyTwoColors02() {
        int ip[]={2,2,2,0,2,0};
        final String actual = sortColors(ip);
        final String expected = "002222";
        assertEquals(expected, actual);
    } @Test
    public void largeSizeInput() {
        int ip[]={2,0,2,1,1,0,1,0,0,1,2,2,0,2,1,2,1,1,0,1,2,0,0,2,2,1,2,0,1,0};
        final String actual = sortColors(ip);
        final String expected = "000000000011111111112222222222";
        assertEquals(expected, actual);
    } @Test(expected = Exception.class)
    public void exceptionWithOneColor() {
        int ip[]={2};
        String temp=sortColors(ip);
    }
    @Test(expected = Exception.class)
    public void exceptionWithEmpty() {
        int ip[]={};
        String temp=sortColors(ip);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Unit2_Arrays.Paradigm_TwoPointers.Start_End.LC75_SortColors.Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        } }
}
