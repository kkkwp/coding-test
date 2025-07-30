import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100_001;
	static int n, k;
	static int[] time = new int[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Arrays.fill(time, -1);
		bfs(n);
		System.out.println(time[k]);
	}

	static void bfs(int start) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(start);
		time[start] = 0;

		while (!dq.isEmpty()) {
			int x = dq.poll();
			
			int[] dx = {x*2, x-1, x+1};
			for (int d=0; d<3; d++) {
				int nx = dx[d];

				if (!inRange(nx)) continue;
				if (time[nx] != -1) continue;

				if (d == 0) { // 순간이동인 경우 0초
					time[nx] = time[x];
					dq.addFirst(nx);
				} else { // 걷기인 경우 1초
					time[nx] = time[x] + 1;
					dq.addLast(nx);
				}
			}
		}
	}

	static boolean inRange(int x) {
		return 0<=x && x<MAX;
	}
}
