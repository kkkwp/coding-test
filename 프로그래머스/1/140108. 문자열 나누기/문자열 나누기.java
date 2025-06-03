class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int yes = 0, no = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (yes == no) {
                answer++;
                x = s.charAt(i);
            }
            if (s.charAt(i) == x) yes++;
            else no++;
        }
        return answer;
    }
}