import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점
        m = Integer.parseInt(st.nextToken()); // 간선
        int v = Integer.parseInt(st.nextToken()); // 시작점

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 정점 번호가 작은 것부터 방문하도록 정렬
        for (int i=1; i<=n; i++)
            Collections.sort(graph[i]);

        StringBuilder sb = new StringBuilder();
        visited = new boolean[n+1];
        dfs(v, sb);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v, sb);
        System.out.println(sb);
    }

    static void dfs(int cur, StringBuilder sb) {
        visited[cur] = true;
        sb.append(cur).append(" ");
        for (int next : graph[cur])
            if (!visited[next])
                dfs(next, sb);
    }

    static void bfs(int start, StringBuilder sb) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
