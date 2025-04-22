class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int first = 0, other = 0;
        for (int i=0; i<s.length(); i++) {
            if (first == other) {
                answer++;
                x = s.charAt(i);
            }
            if (s.charAt(i) == x) first++;
            else other++;
        }
        return answer;
    }
}