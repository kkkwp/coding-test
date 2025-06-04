class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n+1];
        for (int r : reserve) clothes[r]++;
        for (int l : lost) clothes[l]--;
        
        for (int i=1; i<=n; i++) {
            if (clothes[i] == -1) {
                // 앞번호에게 빌리기
                if (i > 1 && clothes[i-1] == 1) {
                    clothes[i]++;
                    clothes[i-1]--;
                // 뒷번호에게 빌리기
                } else if (i < n && clothes[i+1] == 1) {
                    clothes[i]++;
                    clothes[i+1]--;
                }
            }
        }
        
        int answer = 0;
        for (int i=1; i<=n; i++)
            if (clothes[i] >= 0)
                answer++;
        return answer;
    }
}