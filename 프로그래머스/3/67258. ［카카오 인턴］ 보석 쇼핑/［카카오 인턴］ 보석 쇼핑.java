import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> types = new HashSet<>(Arrays.asList(gems));
        int n = types.size();
        
        int left = 0;
        int bestLeft = 0, bestRight = gems.length-1;
        int bestLen = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int right=0; right<gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
            
            while (map.size() == n) {
                int len = right - left + 1;
                if (len < bestLen || (len == bestLen && left < bestLeft)) {
                    bestLen = len;
                    bestLeft = left;
                    bestRight = right;
                }
                
                String gem = gems[left];
                int c = map.get(gem) - 1;
                if (c == 0) map.remove(gem);
                else map.put(gem, c);
                left++;
            }
        }
        return new int[]{bestLeft+1, bestRight+1};
    }
}