import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        Arrays.sort(people);
        
        int left = 0, right = n-1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                answer++;
                left++;
                right--;
            } else {
                right--;
                answer++;
            }
        }
        return answer;
    }
}