package Unit2_Arrays.Medium.LC56_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Approach4Based {
    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1)
            return intervals;

        ArrayList<int[]>mergedIntervals=new ArrayList<>();

        //First Sort on Intervals on basis of start time
        //IMAGINE intervals to be on number line
        Arrays.sort(intervals,new TwoDimArrayComparator());

        int currInterval[]=intervals[0];

        for(int i=1;i<intervals.length;i++)
        {
            int startOfNextInterval=intervals[i][0];
            int endOfNextInterval=intervals[i][1];

            //if next interval starts before end of current interval then overlap will occur
            if(startOfNextInterval<=currInterval[1])
            {
                //the end of the merged overlapping intervals will depend which
                //interval of two takes longest time to complete
                //sine intervals are sorted by start time we dont need to update start time of merged intervals
                currInterval[1]=Math.max(currInterval[1],endOfNextInterval);

            }
            else
            {
                //the current interval doesnt overlaps with next interval
                //store the current interval and update
                //nextInterval to act as currentInterval for next sets of intervals
                mergedIntervals.add(currInterval);
                currInterval=new int[]{startOfNextInterval,endOfNextInterval};
            }

        }
        //Add currInterval to merged interval
        //if mergedIntervals empty
        //or finally we get best possible  merged interval
        //NOTE: it doesnt come inside the for loop
        //it is to take care of last intervals
        mergedIntervals.add(currInterval);

        int res[][]=new int[mergedIntervals.size()][2];

        for(int i=0;i<mergedIntervals.size();i++)
        {
            res[i]=mergedIntervals.get(i);
        }


            return res;
    }

    public class TwoDimArrayComparator implements Comparator<int []>
    {
        public int compare(int a[],int b[])
        {
            return a[0]-b[0];
        }
    }
}