import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 시간 기준으로 이분 탐색을 위해 정렬
        Arrays.sort(times);
        
        long l = 1; // 최소 시간
        long r = (long)n * times[times.length-1]; // 최대 시간
        long answer = r;
        while (l <= r) {
            // mid 시간동안 처리할 수 있는 사람 수 구하기
            long mid = l + (r-l)/2;
            long cnt = 0;
            for (int time : times) {
                cnt += mid/time;
                // 처리한 사람 수가 n을 넘으면 더 계산할 필요 없음
                if (cnt >= n) break;
            }
    
            // n명 이상 처리 가능하다면 시간을 줄여보기
            // n명 이상 처리 불가하다면 시간을 늘려보기
            if (cnt >= n) {
                answer = mid;
                r = mid-1;
            } else
                l = mid+1;
        }
        return answer;
    }
}