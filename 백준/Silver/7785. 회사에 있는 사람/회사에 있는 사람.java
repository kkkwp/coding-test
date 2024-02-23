import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String state = st.nextToken();
			map.put(name, state);
		}

		ArrayList<String> keys = new ArrayList<>(map.keySet());
		keys.sort(Collections.reverseOrder());
		for (String key : keys) {
			if (map.get(key).equals("enter")) {
				System.out.println(key);
			}
		}
	}
}
