import java.util.Scanner;

class Solution
{
    final static int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int startMonth = sc.nextInt();
            int startDate = sc.nextInt();
            int endMonth = sc.nextInt();
            int endDate = sc.nextInt();

            int answer = 0;
            for (int i=startMonth; i<endMonth; i++)
                answer += DAYS[i];
            answer += endDate - startDate + 1;
            System.out.println("#" + test_case + " " + answer);
        }
    }
}