import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int max = -1;
		long answer = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			long card = Long.parseLong(br.readLine());
			map.put(card, map.getOrDefault(card, 0) + 1);

			if (map.get(card) > max) {
				max = map.get(card);
				answer = card;
			} else if (map.get(card) == max) {
				answer = Math.min(answer, card);
			}
		}
		System.out.println(answer);
	}
}
