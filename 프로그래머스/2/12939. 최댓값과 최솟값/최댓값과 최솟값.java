class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        String[] nums = s.split(" ");
        for (String num : nums) {
            max = Math.max(max, Integer.parseInt(num));
            min = Math.min(min, Integer.parseInt(num));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}