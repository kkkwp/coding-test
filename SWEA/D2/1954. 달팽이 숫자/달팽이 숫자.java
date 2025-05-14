import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int n;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            int[][] grid = new int[n][n];
            int dir = 0;
            int r = 0, c = 0;
            int num = 1;
            grid[r][c] = num;
            while (num < n*n) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (inRange(nr, nc) && grid[nr][nc]==0) {
                    grid[nr][nc] = ++num;
                    r = nr;
                    c = nc;
                } else
                    dir = (dir + 1) % 4;
            }

            System.out.println("#" + test_case);
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++)
                    System.out.print(grid[i][j] + " ");
                System.out.println();
            }
        }
    }

    static boolean inRange(int r, int c) {
        return 0<=r && r<n && 0<=c && c<n;
    }
}