class Solution {
    public int solution(String dartResult) {
        int[] dart = new int[3];
        int idx = 0;
        int size = dartResult.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<size; i++) {
            char ch = dartResult.charAt(i);
            
            // 숫자인 경우
            if (ch >= '0' && ch <= '9')
                sb.append(ch);
            
            // 보너스인 경우
            else if (ch == 'S' || ch == 'D' || ch == 'T') {
                int num = Integer.parseInt(sb.toString());
                if (ch == 'S')
                    dart[idx] = num;
                else if (ch == 'D') 
                    dart[idx] = (int)Math.pow(num, 2);
                else 
                    dart[idx] = (int)Math.pow(num, 3);
                sb.setLength(0);
                idx++;
            }
            
            // 옵션인 경우
            else if (ch == '*') {
                dart[idx-1] *= 2;
                if (idx-2 >= 0) dart[idx-2] *= 2;
            } else if (ch == '#')
                dart[idx-1] *= -1;
        }
        return dart[0] + dart[1] + dart[2];
    }
}