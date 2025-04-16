class Solution {
    static int getDivisors(int num) {
        int cnt = 0;
        for (int i=1; i<=(int)Math.sqrt(num); i++) {
            if (i*i == num)
                cnt++;
            else if (num % i == 0)
                cnt += 2;
        }
        return cnt;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int divisors = getDivisors(i);
            if (divisors <= limit)
                answer += divisors;
            else
                answer += power;
        }
        return answer;
    }
}