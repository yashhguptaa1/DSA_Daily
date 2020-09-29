package Unit2_Arrays.Hard.LC45_JumpGameII;

public class Approach1Based {
    public int jump(int[] nums) {

        return helper(nums,0,nums.length-1);

    }

    public int helper(int nums[],int possibleStart,int endOfArray)
    {
        if(possibleStart==endOfArray)
            return 0;
        //when nothing is reachable from the given source
        if(nums[possibleStart]==0)
            return Integer.MAX_VALUE;

        int minNumberOfJumpsPossible=Integer.MAX_VALUE;

        for(int i=possibleStart+1;i<=endOfArray && i<=possibleStart+nums[possibleStart];i++)
        {
            int jumps=helper(nums,i,endOfArray);
            if(jumps!=Integer.MAX_VALUE && jumps+1<minNumberOfJumpsPossible)
            minNumberOfJumpsPossible=jumps+1;
        }
        return minNumberOfJumpsPossible;
    }
}

/*
For test case
input: arr[]={1,4,3,7,1,2,6,7,6,10}
output:3(1->4->7->10)

Recursive Approach
jumps(start,end)









 */