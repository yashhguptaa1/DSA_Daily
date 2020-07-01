package Unit2_Arrays.Medium.LC134_GasStation;

import java.util.Arrays;

public class Approach7Based {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        if(Arrays.stream(gas).sum()<Arrays.stream(cost).sum())
            return -1;

        //if -1 is not returned at this step we are sure that there will be one station possible
        //from where we can start and end at any station
        //we just need to find that station

        int tank=0;
        int startSttn=0;
        for(int currSttn=0;currSttn<gas.length;currSttn++)
        {
            tank+=gas[currSttn]-cost[currSttn];

            if(tank<0)
            {
                tank=0;
                startSttn=currSttn+1;
            }
        }
        return startSttn;
    }
}
