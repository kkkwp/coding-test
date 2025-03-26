class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("");
        int idx = 0;
        for (String word:words) {
            idx = word.contains(" ") ? 0 : idx+1;
            sb.append(idx%2==0 ? word.toLowerCase() : word.toUpperCase());
        }
        return sb.toString();
    }
}