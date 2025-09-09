import java.util.*;

class Solution {
    private String[] user_id, banned_id;
    private Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        // banned_id 아이디 하나씩 dfs 돌려보기
        Set<String> visited = new HashSet<>();
        dfs(0, visited);
        
        return result.size();
    }
    
    private void dfs(int cur, Set<String> visited) {
        if (cur == banned_id.length) {
            result.add(new HashSet<>(visited));
            return;
        }
        
        String pattern = "^" + banned_id[cur].replace("*", ".") + "$";
        
        // 모든 user_id를 확인하면서 현재 banned와 매칭되는지 확인
        for (String user : user_id) {
            if (!visited.contains(user) && user.matches(pattern)) {
                visited.add(user);
                dfs(cur+1, visited);
                visited.remove(user);
            }
        }
    }
    
}