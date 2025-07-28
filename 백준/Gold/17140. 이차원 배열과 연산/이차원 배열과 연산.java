import java.io.*;
import java.util.*;

public class Main {
	static int r, c, k;
	static int[][] a = new int[101][101];
	static int row = 3, col = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i=1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=3; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}

		int time = 0;
		while (time <= 100) {
			if (a[r][c] == k) {
				System.out.println(time);
				return;
			}
			if (row >= col) rOperation();
			else cOperation();
			time++;
		}
		System.out.println(-1);
	}

	static void rOperation() {
		int max = 0;
		for (int i=1; i<=row; i++) {
			// 각각의 수가 몇 번 나왔는지
			Map<Integer, Integer> map = new HashMap<>();
			for (int j=1; j<=col; j++) {
				// 수를 정렬할 때 0은 무시
				if (a[i][j] == 0) continue;
				map.put(a[i][j], map.getOrDefault(a[i][j], 0) + 1);
			}

			// 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬
			List<int[]> list = new ArrayList<>();
			for (int key : map.keySet())
				list.add(new int[]{key, map.get(key)});
			list.sort((a, b) -> {
				if (a[1] == b[1]) return a[0] - b[0];
				return a[1] - b[1];
			});

			// 정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저
			int idx = 1;
			for (int[] pair : list) {
				// 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버림
				if (idx > 100) break;
				a[i][idx++] = pair[0];
				if (idx > 100) break;
				a[i][idx++] = pair[1];
			}

			// 행 또는 열의 크기가 커진 곳에는 0이 채워짐
			for (int j=idx; j<=100; j++) a[i][j] = 0;
			max = Math.max(max, idx-1);
		}
		col = max;
	}

	static void cOperation() {
		int max = 0;
		for (int j=1; j<=col; j++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i=1; i<=row; i++) {
				if (a[i][j] == 0) continue;
				map.put(a[i][j], map.getOrDefault(a[i][j], 0) + 1);
			}

			List<int[]> list = new ArrayList<>();
			for (int key : map.keySet())
				list.add(new int[]{key, map.get(key)});
			list.sort((a, b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);

			int idx = 1;
			for (int[] pair : list) {
				if (idx > 100) break;
				a[idx++][j] = pair[0];
				if (idx > 100) break;
				a[idx++][j] = pair[1];
			}

			for (int i=idx; i<=100; i++) a[i][j] = 0;
			max = Math.max(max, idx-1);
		}
		row = max;
	}
}
