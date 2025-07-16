class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int n = sequence.length;
        
        long[] pulse1 = new long[n]; // [1, -1, 1, -1, ...]
        long[] pulse2 = new long[n]; // [-1, 1, -1, 1, ...]
        for (int i=0; i<n; i++) {
            int sign = (i%2 == 0) ? 1 : -1;
            pulse1[i] = sequence[i] * sign;
            pulse2[i] = sequence[i] * -sign;
        }
        
        answer = Math.max(getMaxSum(pulse1), getMaxSum(pulse2));
        return answer;
    }
    
    static long getMaxSum(long[] arr) {
        long sum = arr[0];
        long maxSum = arr[0];
        for (int i=1; i<arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}