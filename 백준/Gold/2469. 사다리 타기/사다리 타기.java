import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int k, n;
	static char[] result;
	static String[] ladder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine()); // 참가한 사람의 수
		n = Integer.parseInt(br.readLine()); // 전체 가로 줄의 수
		result = br.readLine().toCharArray(); // 참가자들의 최종 순서
		ladder = new String[n]; // 사다리
		int idx = -1;
		for (int i=0; i<n; i++) {
			ladder[i] = br.readLine();
			if (ladder[i].charAt(0) == '?') idx = i;
		}

		// 위에서 ? 전까지 시뮬레이션
		char[] top = new char[k];
		for (int i=0; i<k; i++)
			top[i] = (char)('A' + i);
		for (int i=0; i<idx; i++)
			simulateDown(top, i);

		// 아래에서 ? 전까지 시뮬레이션
		char[] bottom = Arrays.copyOf(result, k);
		for (int i=n-1; i>idx; i--)
			simulateUp(bottom, i);

		char[] answer = new char[k-1];
		for (int i=0; i<k-1; i++) {
			if (top[i] == bottom[i]) {
				answer[i] = '*';
			} else if (top[i] == bottom[i+1] && top[i+1] == bottom[i]) {
				answer[i] = '-';
				// swap
				char tmp = top[i];
				top[i] = top[i+1];
				top[i+1] = tmp;
			} else { // 불가능한 경우
				for (int j=0; j<k-1; j++)
					System.out.print('x');
				return;
			}
		}
		System.out.println(new String(answer));
	}

	static void simulateDown(char[] arr, int idx) {
		for (int i=0; i<k-1; i++) {
			// - 이면 자리 바꾸기
			if (ladder[idx].charAt(i) == '-') {
				char tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
			}
		}
	}

	static void simulateUp(char[] arr, int idx) {
		for (int i=k-2; i>=0; i--) {
			if (ladder[idx].charAt(i) == '-') {
				char tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
			}
		}
	}
}
