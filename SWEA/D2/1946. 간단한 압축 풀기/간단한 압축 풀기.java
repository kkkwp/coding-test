import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();

            int cnt = 0;
            for (int i=0; i<n; i++) {
                char c = sc.next().charAt(0);
                int k = sc.nextInt();
                while (k-->0) {
                    sb.append(c);
                    cnt++;
                    if (cnt == 10) {
                        sb.append('\n');
                        cnt = 0;
                    }
                }
            }
            System.out.println("#" + test_case);
            System.out.println(sb.toString());
        }
    }
}