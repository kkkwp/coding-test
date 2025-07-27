import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>(); // 장르별 총 재생수
        Map<String, List<int[]>> playlist = new HashMap<>(); // 장르별 노래 목록
        
        for (int i=0; i<genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            playlist
                .computeIfAbsent(genres[i], x -> new ArrayList<>())
                .add(new int[]{i, plays[i]});
        }
        
        // 장르를 총 재생 수 기준으로 정렬
        List<String> sorted = new ArrayList<>(total.keySet());
        sorted.sort((a, b) -> total.get(b) - total.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : sorted) {
            List<int[]> songs = playlist.get(genre);
            
            // 노래를 재생 수 내림차순, 고유 번호 오름차순 정렬
            songs.sort((a, b) -> {
                if (b[1] == a[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            // 노래 최대 2개 선택
            for (int i=0; i<Math.min(2, songs.size()); i++)
                result.add(songs.get(i)[0]);
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}