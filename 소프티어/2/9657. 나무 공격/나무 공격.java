import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int answer;
    static int[][] grid;

    static void attack(int l, int r) {
        for (int i=l; i<=r; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    answer--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1)
                    answer++;
            }
        }

        for (int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            attack(l-1, r-1);
        }
        System.out.print(answer);
    }
}