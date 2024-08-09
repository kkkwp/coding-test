class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] word = s.split("");
        int idx = 0;
        for (String ch : word) {
            idx = ch.contains(" ") ? 0 : idx + 1;
            sb.append(idx % 2 == 0 ? ch.toLowerCase() : ch.toUpperCase());
        }
        return sb.toString();
    }
}