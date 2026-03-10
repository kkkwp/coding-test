import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 추천 문제 리스트에 있는 문제의 개수

		TreeSet<int[]> set = new TreeSet<>((a, b) -> {
			if (a[1] == b[1]) return a[0] - b[0]; // 난이도가 같다면 문제 번호가 작은 순
			return a[1] - b[1]; // 난이도가 쉬운 순
		});
		Map<Integer, Integer> map = new HashMap<>(); // 문제번호-난이도 매핑
		while (n-->0) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 문제 번호
			int l = Integer.parseInt(st.nextToken()); // 난이도
			set.add(new int[] {p, l});
			map.put(p, l);
		}

		int m = Integer.parseInt(br.readLine()); // 입력될 명령문의 개수
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				System.out.println(x == 1 ? set.last()[0] : set.first()[0]);
			} else if (cmd.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				set.add(new int[] {p, l});
				map.put(p, l);
			} else {
				int p = Integer.parseInt(st.nextToken());
				int l = map.get(p);
				set.remove(new int[] {p, l});
				map.remove(p);
			}
		}
	}
}
