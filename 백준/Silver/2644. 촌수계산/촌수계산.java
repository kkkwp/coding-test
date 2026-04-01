import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람의 수 n
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 서로 다른 두 사람 from, to
        int to = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 수 m

        // adj 초기화
        adj = new ArrayList<>();
        for (int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
        int x, y;
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); // 부모 x
            y = Integer.parseInt(st.nextToken()); // 자식 y
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        // dist 초기화
        dist = new int[n+1];
        Arrays.fill(dist, -1);

        bfs(from);
        System.out.println(dist[to]);
    }

    static void bfs(int from) {
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        dist[from] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur]+1;
                    q.add(next);
                }
            }
        }
    }
}
