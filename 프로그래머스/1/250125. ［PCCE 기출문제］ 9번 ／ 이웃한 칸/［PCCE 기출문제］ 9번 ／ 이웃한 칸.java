class Solution {
    static int n;
    static int[] dh = {0, 1, -1, 0};
    static int[] dw = {1, 0, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        n = board.length;
        int cnt = 0;
        String color = board[h][w];
        for (int dir=0; dir<4; dir++) {
            int nh = h + dh[dir];
            int nw = w + dw[dir];
            if (inRange(nh, nw) && board[nh][nw].equals(color))
                cnt++;
        }
        return cnt;
    }
    
    static boolean inRange(int h, int w) {
        return 0<=h && h<n && 0<=w && w<n;
    }
}