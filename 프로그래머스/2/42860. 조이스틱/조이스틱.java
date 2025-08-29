class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 상하
        for (char ch : name.toCharArray())
            answer += Math.min(ch-'A', 'Z'-ch+1);
        
        // 좌우
        int min = n-1; // 오른쪽으로만 쭉 가는 경우
        for (int i=0; i<n; i++) {
            // 현재 위치 i 다음부터 연속되는 'A'가 끝나는 지점 찾기
            int next = i+1;
            while (next<n && name.charAt(next) == 'A')
                next++;
            
            // 오른쪽으로 i까지 갔다가 턴해서 왼쪽 끝으로 가기
            int right = i*2 + n-next;
            // 왼쪽으로 먼저 갔다가 턴해서 i+1 지점으로 가기
            int left = i + (n-next)*2;
            min = Math.min(min, right);
            min = Math.min(min, left);
        }
        answer += min;
        return answer;
    }
}