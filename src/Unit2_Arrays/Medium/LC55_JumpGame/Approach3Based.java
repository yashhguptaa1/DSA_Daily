package Unit2_Arrays.Medium.LC55_JumpGame;

public class Approach3Based {
    public boolean canJump(int[] nums) {
    int lastGoodPosition=nums.length-1;

    for(int currPos=nums.length-2;currPos>=0;currPos--)
    {
       if(currPos+nums[currPos]>=lastGoodPosition)
           lastGoodPosition=currPos;
    }

    return lastGoodPosition==0;
    }

}
