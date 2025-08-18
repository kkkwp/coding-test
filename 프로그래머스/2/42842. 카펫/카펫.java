class Solution {
    public int[] solution(int brown, int yellow) {
        for (int h=1; h<=Math.sqrt(yellow); h++) {
            if (yellow % h == 0) {
                int w = yellow / h;
                int tmp = w*2 + h*2 + 4;
                if (tmp == brown)
                    return new int[]{w+2, h+2};
            }
        }
        return null;
    }
}