package Unit2_Arrays.Medium.LC334_IncreasingTripletSubsequence;

import java.util.Arrays;

public class Approach5Based {

    public boolean increasingTriplet(int[] nums) {

        int n=nums.length;
        if (n == 0) {
            return false;
        }

        int[] maxLength = new int[n];
        Arrays.fill(maxLength, 1);

        // By default the best answer is a length of 1
        int maximumSoFar = 1;

        // Test every possible end index of a longest increasing subsequence
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }

            maximumSoFar = Math.max(maximumSoFar, maxLength[i]);
            if(maximumSoFar>=3)
                return true;
        }

        return false;
    }
}

