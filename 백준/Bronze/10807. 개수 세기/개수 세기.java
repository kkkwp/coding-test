import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		int v = Integer.parseInt(br.readLine());
		System.out.println(map.getOrDefault(v, 0));
	}
}
