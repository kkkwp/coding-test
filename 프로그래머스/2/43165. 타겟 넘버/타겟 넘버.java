class Solution {
    static int n, answer = 0;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    private void dfs(int depth, int sum, int[] numbers, int target) {
        if (depth == n) {
            if (sum == target)
                answer++;
            return;
        }
        dfs(depth+1, sum+numbers[depth], numbers, target);
        dfs(depth+1, sum-numbers[depth], numbers, target);
    }
}
