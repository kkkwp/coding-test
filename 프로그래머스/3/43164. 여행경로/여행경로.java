import java.util.*;

class Solution {
    static List<String> route = new ArrayList<>();
    static Map<String, PriorityQueue<String>> map = new HashMap<>();
    
    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets)
            map.computeIfAbsent(ticket[0], x -> new PriorityQueue<>()).add(ticket[1]);
        
        dfs("ICN");
        
        Collections.reverse(route);
        return route.stream().toArray(String[]::new);
    }
    
    static void dfs(String airport) {
        PriorityQueue<String> pq = map.get(airport);
        while (pq != null && !pq.isEmpty())
            dfs(pq.poll());
        route.add(airport);
    }
}