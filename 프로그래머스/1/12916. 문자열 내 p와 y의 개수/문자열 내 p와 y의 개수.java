class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        int p=0, y=0;
        for (char ch : s.toCharArray()) {
            if (ch == 'P') p++;
            else if (ch == 'Y') y++;
        }
        return p==y;
    }
}