import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] playersAtStage = new int[N+2];
        for (int stage : stages)
            playersAtStage[stage]++;
        
        int players = stages.length;
        List<Failure> list = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            double rate = players == 0 ? 0 : (double)playersAtStage[i] / players;
            list.add(new Failure(i, rate));
            players -= playersAtStage[i];
        }
        
        Collections.sort(list);
        
        int[] answer = new int[N];
        for (int i=0; i<N; i++)
            answer[i] = list.get(i).stage;
        return answer;
    }
}

class Failure implements Comparable<Failure> {
    int stage;
    double rate;
    
    Failure(int stage, double rate) {
        this.stage = stage;
        this.rate = rate;
    }
    
    @Override
    public int compareTo(Failure other) {
        int result = Double.compare(other.rate, this.rate);
        if (result == 0)
            return this.stage - other.stage; // 스테이지 오름차순
        return result; // 실패율 내림차순
    }
}