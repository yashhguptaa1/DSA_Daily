package Unit9_Strings.LC5_LongestPalindromicSubstring;

public class Approach1_Based {

    public String longestPalindrome(String s) {

        int start=0;
        int maxlen=0;

        int strlen=s.length();

        //base case
        if(strlen==0)
            return "";

        //table[i][j]is false if
        //substring s[i...j] is not palindrome
        //else its true
        boolean table[][]=new boolean[strlen][strlen];

        //Single Characters are always Palindrome

        maxlen=1;
        for(int i=0;i<strlen;i++){
            table[i][i]=true;
        }

        //check for substrings of length 2

        for(int i=0;i<strlen-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                table[i][i+1]=true;
                start=i;
                maxlen=2;
            }
        }

        //Check for substrings greater than length 2

        //here K denotes lengths of substring being currently considered

        /*k was being looped till k<strlen
        i didnt use k<=strlen
        which resulted in failure for testcase
        Your input :"ccc"
        Output:"cc"
        Expected:"ccc"
         */
        for(int k=3;k<=strlen;k++)
        {
            //fixing starting index
            for (int i=0;i<strlen-k+1;i++)
            {
                //get ending index
                int j=i+k-1;

                //if substring in between the two endpoints{ i+1 ......j-1} is palindrome
                //AND
                //the two endpoints {i , j} of current substring match
                //then the whole substring including endpoints is a PALINDROME
                if(table[i+1][j-1] && s.charAt(i)==s.charAt(j))
                {
                    table[i][j]=true;

                    //if current palindrome substring length is greater than max considered so far
                    //update starting index to current substring and maxlen
                    if(k>maxlen)
                    {
                        start=i;
                        maxlen=k;

                    }
                }
            }
        }
        return s.substring(start,start+maxlen);
    }
}



/*
Brute Force
The obvious brute force solution is to pick all possible starting and ending positions for a substring, and verify if it is a palindrome.

Complexity Analysis

Time complexity : O(n^3)O(n
3
 ). Assume that nn is the length of the input string, there are a total of \binom{n}{2} = \frac{n(n-1)}{2}(
2
n
​
 )=
2
n(n−1)
​
  such substrings (excluding the trivial solution where a character itself is a palindrome). Since verifying each substring takes O(n)O(n) time, the run time complexity is O(n^3)O(n
3
 ).

Space complexity : O(1)O(1).


Approach 3: Dynamic Programming
To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation while validating palindromes. Consider the case "ababa". If we already knew that "bab" is a palindrome, it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.

We define P(i,j)P(i,j) as following:

P(i,j)={true,false,if the substring Si…Sj is a palindromeotherwise.
Therefore,

P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j )
P(i,j)=(P(i+1,j−1) and S
i
​
 ==S
j
​
 )

The base cases are:

P(i, i) = true
P(i,i)=true

P(i, i+1) = ( S_i == S_{i+1} )
P(i,i+1)=(S
i
​
 ==S
i+1
​
 )

This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...

Complexity Analysis

Time complexity : O(n^2)O(n
2
 ). This gives us a runtime complexity of O(n^2)O(n
2
 ).

Space complexity : O(n^2)O(n
2
 ). It uses O(n^2)O(n
2
 ) space to store the table.
 */
