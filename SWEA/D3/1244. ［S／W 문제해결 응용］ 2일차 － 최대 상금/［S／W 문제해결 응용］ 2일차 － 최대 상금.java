import java.util.Scanner;

class Solution
{
    static char[] numbers;
    static int n, answer;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            numbers = sc.next().toCharArray();
            n = sc.nextInt();
            answer = 0;
            
            dfs(0, 0);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void dfs(int depth, int start) {
        if (depth == n) {
            answer = Math.max(answer, Integer.parseInt(String.valueOf(numbers)));
            return;
        }

        int len = numbers.length;
        for (int i=start; i<len-1; i++) {
            for (int j=i+1; j<len; j++) {
                swap(i, j);
                dfs(depth+1, i);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        char tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}