class Solution {
    static int gcd(int n, int m) {
        if (m == 0)
            return n;
        return gcd(m, n%m);
    }
    
    public int[] solution(int n, int m) {
        int num = gcd(n, m);
        return new int[]{num, n*m/num};
    }
}