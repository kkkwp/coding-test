class Solution {
    public int solution(int num) {
        long n = num;
        int cnt = 0;
        while (cnt < 500) {
            if (n==1) return cnt;
            
            n = n%2==0 ? n/2 : n*3+1;
            cnt++;
        }
        return -1;
    }
}