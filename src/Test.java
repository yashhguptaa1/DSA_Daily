import java.util.Scanner;

public class Test {

    public static int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int start[] =new int[]{1,};
        int end[]=new int[]{};


        //System.out.println(numIdenticalPairs(nums));

    }
}
