class Solution {
    public int[] solution(long n) {
        char[] numbers = Long.toString(n).toCharArray();
        int[] answer = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            answer[numbers.length - 1 - i] = numbers[i] - '0';
        }
        return answer;
    }
}