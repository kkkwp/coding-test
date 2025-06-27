import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word cur = q.poll();
            if (cur.word.equals(target))
                return cur.step;
            for (int i=0; i<n; i++) {
                if (!visited[i] && canConvert(cur.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Word(words[i], cur.step+1));
                }
            }
        }
        return 0;
    }
    
    static boolean canConvert(String a, String b) {
        int cnt = 0;
        for (int i=0; i<a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) 
                cnt++;
        return cnt == 1;
    }
}

class Word {
    String word;
    int step;
    
    Word(String word, int step) {
        this.word = word;
        this.step = step;
    }
}