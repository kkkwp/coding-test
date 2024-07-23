import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1)
            return new int[] {-1};
        List<Integer> list = new ArrayList<>();
        for (int a : arr)
            list.add(a);
        list.remove(Collections.min(list));
        return list.stream()
            .mapToInt(x -> x)
            .toArray();
    }
}