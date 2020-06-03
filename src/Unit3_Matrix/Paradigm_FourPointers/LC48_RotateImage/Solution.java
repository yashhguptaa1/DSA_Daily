package Unit3_Matrix.Paradigm_FourPointers.LC48_RotateImage;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
public class Solution {
    public String rotate(int[][] matrix) {

        int nRows=matrix[0].length;
        int nCols=matrix.length;




        StringBuffer res=new StringBuffer("");
        for(int i=0;i<nRows;i++)
        {
            for (int j=0;j<nCols;j++)
            {
                res.append(Integer.toString(matrix[i][j]));
            }
        }
        return res.toString();
    }

    // tests
    @Test
    public void priceGoesUpThenDownTest() {
        int ip[][]={{1,2,3},{4,5,6},{7,8,9}};
        final String actual = rotate(ip);
        final String expected = "  ";
        assertEquals(expected, actual);
    } @Test
    public void priceGoesDownThenUpTest() {
    int ip[][]={{2}};
    final String actual = rotate(ip);
    final String expected = "";
        assertEquals(expected, actual);
    } @Test
    public void priceGoesUpAllDayTest() {
    int ip[][]={{2}};
    final String actual = rotate(ip);
    final String expected = "";
        assertEquals(expected, actual);
    } @Test
    public void priceGoesDownAllDayTest() {
    int ip[][]={{2}};
    final String actual = rotate(ip);
    final String expected = "";
        assertEquals(expected, actual);
    } @Test
    public void priceStaysTheSameAllDayTest() {
    int ip[][]={{2}};
    final String actual = rotate(ip);
    final String expected = "";
        assertEquals(expected, actual);
    } @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
    int ip[][]={{2}};
    String temp=rotate(ip);
    }
    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        int ip[][]={{}};
        String temp=rotate(ip);    }
        public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        } }
}
