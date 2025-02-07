import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int time = 0;
        int go = d>a ? d/a : 0;   // 가는 길에 술래가 돌아본 횟수
        int come = d>b ? d/b : 0; // 오는 길에 술래가 돌아본 횟수
        time = 2*d + a*come + b*go;
        System.out.print(time);
    }
}