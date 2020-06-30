package Unit9_Strings.LC5_LongestPalindromicSubstring;

/*
IN this solution we optimized on the dp solution
space complexity from
O(n^2) to O(1)

But The Time Complexity remains same O(n^2)
 */
public class Optimized {
    public String longestPalindrome(String s) {

        int n=s.length();
        if(n==0)
            return "";

        int startOfPalindromicSubstring=0;
        int endOfPalindromicSubstring=0;
        int currMax=0;


        for(int i=0;i<n;i++)
        {
            int OddLenPalin=expandFromMiddleOfCurrentSubstring(s,i,i);//for input: racecar
            int EvenLenPalin=expandFromMiddleOfCurrentSubstring(s,i,i+1);
            currMax=Math.max(OddLenPalin,EvenLenPalin);
            int maxSoFar=endOfPalindromicSubstring-startOfPalindromicSubstring;
            if(currMax>maxSoFar)
            {
                startOfPalindromicSubstring=i-((currMax-1)/2);
                endOfPalindromicSubstring=i+(currMax/2);
            }

        }

        return s.substring(startOfPalindromicSubstring,endOfPalindromicSubstring+1);
    }
    public int expandFromMiddleOfCurrentSubstring(String str,int left,int right)
    {
        if(str==null || left>right)
            return 0;

        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right))
        {
            left--;
            right++;
        }

        return right-left-1;
    }
}
