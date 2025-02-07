import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] towns = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            towns[i] = Integer.parseInt(st.nextToken());

        int minDist = 1_000_001;
        int cnt = 1;
        for (int i=1; i<n; i++) {
            int dist = towns[i] - towns[i-1];
            if (minDist > dist) {
                minDist = dist;
                cnt = 1;
            } else if (minDist == dist)
                cnt++;
        }
        System.out.print(cnt);
    }
}