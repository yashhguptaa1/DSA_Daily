import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Practice {

    public String setZeroes(int[][] matrix) {

        StringBuilder res=new StringBuilder();
        int nRows=matrix.length;
        int nCols=matrix[0].length;

        Set<Integer> rowIndex=new HashSet<>();
        Set<Integer> colIndex=new HashSet<>();
        for(int i=0;i<nRows;i++)
        {
            for(int j=0;j<nCols;j++)
            {
                if(matrix[i][j]==0)
                {
                    rowIndex.add(i);
                    colIndex.add(j);
                }
            }
        }

        for(Integer r:rowIndex)
        {
            for(int col=0;col<nCols;col++)
            {
                matrix[r][col]=0;
            }
        }
        System.out.println(rowIndex);
        System.out.println(colIndex);
        for(Integer c:colIndex)
        {
            for(int row=0;row<nRows;row++)
            {
                matrix[row][c]=0;
            }
        }
        for(int i=0;i<nRows;i++)
        {
            for(int j=0;j<nCols;j++)
            {
                res.append(Integer.toString(matrix[i][j]));
            }
        }
        return res.toString();
    }

    @Test
    public void singleInteger() {

        int ip[][]=new int[][]{{1,1,1},{1,0,1},{1,1,1,}};
        final String actual=setZeroes(ip);
        System.out.println(actual);
        final String expected= "3";
        assertEquals(expected,actual);

    }
    @Test
    public void sampleTestCase() {
        int ip[][]=new int[][]{{3}};
        final String actual=setZeroes(ip);
        final String expected= "3";
        assertEquals(expected,actual);
    } @Test
    public void kBiggerThanSizeOfArray() {
        int ip[][]=new int[][]{{3}};
        final String actual=setZeroes(ip);
        final String expected= "3";
        assertEquals(expected,actual);

    } @Test
    public void EmptyTestCase() {
        int ip[][]=new int[][]{{3}};
        final String actual=setZeroes(ip);
        final String expected= "3";
        assertEquals(expected,actual);
    }
    @Test
    public void kSameAsSize() {
        int ip[][]=new int[][]{{3}};
        final String actual=setZeroes(ip);
        final String expected= "3";
        assertEquals(expected,actual);

    }
    @Test
    public void kZero() {
        int ip[][]=new int[][]{{3}};
        final String actual=setZeroes(ip);
        final String expected= "3";
        assertEquals(expected,actual);

    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Practice.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        } if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
