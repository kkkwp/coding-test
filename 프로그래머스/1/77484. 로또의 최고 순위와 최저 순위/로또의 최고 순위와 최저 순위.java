import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int match = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : win_nums)
            set.add(num);
        
        for (int num : lottos) {
            if (num == 0) zero++;
            else if (set.contains(num)) match++;
        }
        
        int max = match + zero;
        int min = match;
        return new int[]{getRank(max), getRank(min)};
    }
    
    public int getRank(int match) {
        switch (match) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}