import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        for (int i=0; i<jobs.length; i++)
            jobList.add(new Job(i, jobs[i][0], jobs[i][1]));
        jobList.sort(Comparator.comparingInt(x -> x.request));
        
        // 작업의 소요시간이 짧은 것 → 작업의 요청 시각이 빠른 것 → 작업의 번호가 작은 것
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.duration != b.duration)
                return a.duration - b.duration;
            if (a.request != b.request)
                return a.request - b.request;
            return a.num - b.num;
        });
        
        int n = 0, idx = 0, sum = 0, time = 0;
        while (n < jobs.length) {
            while (idx < jobs.length && jobList.get(idx).request <= time) {
                pq.offer(jobList.get(idx));
                idx++;
            }
            
            if (!pq.isEmpty()) {
                Job cur = pq.poll();
                int complete = time + cur.duration;
                sum += complete - cur.request;
                time = complete;
                n++;
            } else {
                if (idx < jobs.length)
                    time = jobList.get(idx).request;
            }
        }
        return sum / jobs.length;
    }
}

class Job {
    int num, request, duration;
    
    Job(int num, int request, int duration) {
        this.num = num;
        this.request = request;
        this.duration = duration;
    }
}