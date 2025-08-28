import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 다리 건설 비용을 기준으로 오름차순 정렬
        Arrays.sort(costs, Comparator.comparingInt(x -> x[2]));
        
        // union-find 초기화 (처음에는 자기 자신을 부모로 가짐)
        parent = new int[n];
        for (int i=0; i<n; i++)
            parent[i] = i;
        
        // 비용이 낮은 다리부터 순서대로 확인
        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            // 두 노드가 같은 집합에 속하지 않으면(사이클이 아니면) → 다리 건설
            if (find(a) != find(b)) {
                union(a, b); // 두 노드를 같은 집합으로 연결
                answer += cost;
            }
        }
        return answer;
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}