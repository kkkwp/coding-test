import java.util.*;

class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        return dictionary.indexOf(word);
    }
    
    static void dfs(String cur) {
        dictionary.add(cur);
        if (cur.length() == 5)
            return;
        for (char v : vowels)
            dfs(cur + v);
    }
}