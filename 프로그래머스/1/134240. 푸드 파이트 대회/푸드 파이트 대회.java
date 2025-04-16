class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        int n = food.length;
        for (int i=1; i<food.length; i++) {
            int cnt = food[i]/2;
            sb.append(String.valueOf(i).repeat(cnt));
        }
        String answer = sb + "0";
        answer += sb.reverse();
        return answer;
    }
}