class Solution {
    static int getDivisor(int num) {
        int cnt = 1;
        for (int i=1; i<=num/2; i++)
            if (num%i==0)
                cnt++;
        return cnt;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<=right; i++) {
            if (getDivisor(i)%2==0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}