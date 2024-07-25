import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
		for (int[] command : commands) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = command[0] - 1; j < command[1]; j++)
				list.add(array[j]);
			Collections.sort(list);
			answer.add(list.get(command[2] - 1));
		}
		return answer.stream()
			.mapToInt(x -> x)
			.toArray();
    }
}