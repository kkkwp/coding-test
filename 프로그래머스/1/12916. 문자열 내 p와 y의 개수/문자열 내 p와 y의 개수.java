class Solution {
    boolean solution(String s) {
        char[] array = s.toCharArray();
        int p = 0;
        int y = 0;
        for (char c : array) {
            if (c == 'P' || c == 'p')
                p++;
            else if (c == 'Y' || c == 'y')
                y++;
        }
        return p == y;
    }
}