import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] buildings = new int[n];
            for (int i=0; i<n; i++)
                buildings[i] = sc.nextInt();

            int answer = 0;
            for (int i=2; i<n-2; i++) {
                int highest = Math.max(Math.max(buildings[i-2], buildings[i-1]), Math.max(buildings[i+1], buildings[i+2]));
                if (buildings[i] > highest)
                    answer += buildings[i] - highest;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}