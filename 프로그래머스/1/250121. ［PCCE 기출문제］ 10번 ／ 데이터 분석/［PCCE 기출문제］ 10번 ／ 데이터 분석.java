import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int extIdx = getIdx(ext);
        for (int[] d : data)
            if (d[extIdx] < val_ext)
                list.add(d);
        
        int sortIdx = getIdx(sort_by);
        list.sort(Comparator.comparingInt(x -> x[sortIdx]));
        
        int[][] answer = new int[list.size()][4];
        for (int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
    
    private int getIdx(String key) {
        switch (key) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
        }
        return -1;
    }
}