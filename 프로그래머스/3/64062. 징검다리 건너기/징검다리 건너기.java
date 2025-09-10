class Solution {
    private int[] stones;
    private int k;
    
    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;
        
        // n명의 학생이 다리를 건널 수 있는가? -> 이분탐색
        int left = 0, right = 200_000_000;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(mid)) {
                answer = mid;
                left = mid + 1;
            } else 
                right = mid - 1;
        }
        return answer;
    }
    
    private boolean canCross(int friends) {
        int cnt = 0; // 0인 돌이 연속으로 몇 개인지 카운트
        for (int stone : stones) {
            if (stone < friends) cnt++;
            else cnt = 0;
            
            if (cnt >= k) return false;
        }
        return true;
    }
}