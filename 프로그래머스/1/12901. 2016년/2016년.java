class Solution {
    public String solution(int a, int b) {
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] dates = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int total = 0;
        for (int i=1; i<a; i++)
            total += dates[i];
        total += b-1;
        return days[total%7];
    }
}