import java.io.*;
import java.util.*;

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pos[] positions = new Pos[n];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i] = new Pos(x, y);
        }

        int southern = 1001;
        int idx = 0;
        for (int i=0; i<n; i++) {
            if (southern > positions[i].y) {
                southern = positions[i].y;
                idx = i;
            }
        }
        System.out.print(positions[idx].x + " " + positions[idx].y);
    }
}