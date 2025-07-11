import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] a;
	static boolean[] robots;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[2*n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<2*n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		robots = new boolean[n];
		int answer = 0;
		while (true) {
			answer++;
			rotate();
			moveRobots();
			putRobot();
			if (isFinished()) {
				System.out.println(answer);
				return;
			}
		}
	}

	static void rotate() {
		int tmp = a[2*n-1];
		for (int i=2*n-1; i>0; i--)
			a[i] = a[i-1];
		a[0] = tmp;

		for (int i=n-1; i>0; i--)
			robots[i] = robots[i-1];
		robots[0] = false; // 올리는 위치 비우기
		robots[n-1] = false; // 내리는 위치에서 내리기
	}

	static void moveRobots() {
		for (int i=n-2; i>=0; i--) {
			if (robots[i] && !robots[i+1] && a[i+1]>0) {
				robots[i] = false;
				robots[i+1] = true;
				a[i+1]--;
			}
		}
		robots[n-1] =false; // 내리는 위치에서 내리기
	}

	static void putRobot() {
		if (a[0] > 0) {
			robots[0] = true;
			a[0]--;
		}
	}

	static boolean isFinished() {
		int cnt = 0;
		for (int x : a) {
			if (x == 0) cnt++;
			if (cnt >= k) return true;
		}
		return false;
	}
}
