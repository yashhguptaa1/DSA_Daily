package Unit2_Arrays.Medium.LC300_LongestIncreasingSubsequence;

import java.util.Arrays;

public class Approach5Based {
    public int lengthOfLIS(int[] nums) {

        int maxSoFar=1;
        int n= nums.length;
        if(n==0)
            return 0;

        int maxlen[]=new int[n];
        Arrays.fill(maxlen,1);


        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    maxlen[i]=Math.max(maxlen[i],maxlen[j]+1);
                }
            }
            maxSoFar=Math.max(maxSoFar,maxlen[i]);

        }

        return maxSoFar;
    }
}
