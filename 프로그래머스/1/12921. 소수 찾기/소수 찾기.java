class Solution {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n+1];
        for (int i=2; i*i<=n; i++)
            if (!isNotPrime[i])
                for (int j=i*i; j<=n; j+=i)
                    isNotPrime[j] = true;
        
        int answer = 0;
        for (int i=2; i<=n; i++)
            if (!isNotPrime[i]) answer++;
        return answer;
    }
}