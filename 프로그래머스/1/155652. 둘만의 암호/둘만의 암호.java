class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            for (int j=0; j<index; j++) {
                ch += 1;
                if (ch > 'z')
                    ch -= 26;
                if (skip.contains(String.valueOf(ch)))
                    j--;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}