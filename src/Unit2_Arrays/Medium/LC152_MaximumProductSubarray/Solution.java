package Unit2_Arrays.Medium.LC152_MaximumProductSubarray;

public class Solution {
    public int maxProduct(int nums[])
    {
        int n=nums.length;
        if(n==0)
            return -1;

        //to store the largest positive product till for the current subaray possible
        int currMax=nums[0];

        //to store the smallest negative product possible
        //For eg -8 is smaller than -2
        //but (-8 * -2 = 16) is greater than (-2 * -2 = 4)
        int currMin=nums[0];
        int maxSoFar=nums[0];


        for (int i=1;i<n;i++)
        {
            int dontLoseOnUpdate=currMax;

            currMax=Math.max(nums[i],Math.max(currMax*nums[i],currMin*nums[i]));

            currMin=Math.min(nums[i],Math.min(dontLoseOnUpdate*nums[i],currMin*nums[i]));

            if(maxSoFar<currMax)
            {
                maxSoFar=currMax;
            }

        }



        return maxSoFar;
    }
}
