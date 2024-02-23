import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, (o1, o2) -> map.get(o2) - map.get(o1));
		StringBuilder sb = new StringBuilder();
		for (int key : keys) {
			int cnt = map.get(key);
			while (cnt-- > 0) {
				System.out.print(key + " ");
			}
		}
		System.out.println();
	}
}
