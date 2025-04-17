class Solution {
    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int answer = 1;
        int size = section.length;
        for (int i=1; i<size; i++) {
            if (start+m-1 < section[i]) {
                start = section[i];
                answer++;
            }
        }
        return answer;
    }
}