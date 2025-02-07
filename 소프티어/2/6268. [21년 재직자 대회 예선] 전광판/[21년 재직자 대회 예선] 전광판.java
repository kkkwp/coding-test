import java.io.*;
import java.util.*;

public class Main {
    static int getDiff(String a, String b) {
        int cnt = 0;
        char[] numA = a.toCharArray();
        char[] numB = b.toCharArray();
        for (int i=0; i<7; i++)
            if (numA[i] != numB[i])
                cnt++;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        Map<Character, String> lights = new HashMap<>();
        lights.put(' ', "0000000");
        lights.put('0', "1110111");
        lights.put('1', "0010010");
        lights.put('2', "1011101");
        lights.put('3', "1011011");
        lights.put('4', "0111010");
        lights.put('5', "1101011");
        lights.put('6', "1101111");
        lights.put('7', "1110010");
        lights.put('8', "1111111");
        lights.put('9', "1111011");

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int diff = 0;
            String numA = String.format("%5s", a);
            String numB = String.format("%5s", b);
            for (int i=0; i<5; i++)
                diff += getDiff(lights.get(numA.charAt(i)), lights.get(numB.charAt(i)));
            sb.append(diff).append('\n');
        }
        System.out.print(sb.toString());
    }
}