import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] f = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            f[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(f);

        System.out.print(Math.max(f[0]*f[1], f[n-2]*f[n-1]));
    }
}