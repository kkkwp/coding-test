import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n, l;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지도의 크기
		l = Integer.parseInt(st.nextToken()); // 경사로의 길이
		board = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int i=0; i<n; i++) {
			if (isPath(board[i])) answer++; // 행 검사
			if (isPath(getColumn(i))) answer++; // 열 검사
		}
		System.out.println(answer);
	}

	static int[] getColumn(int i) {
		int[] col = new int[n];
		for (int j=0; j<n; j++)
			col[j] = board[j][i];
		return col;
	}

	static boolean isPath(int[] arr) {
		boolean[] used = new boolean[n];
		for (int i=0; i<n-1; i++) {
			int cur = arr[i];
			int next = arr[i+1];

			// 높이가 같다면 → pass
			if (cur == next) continue;

			// 높이 차이가 1이 아니면 → 불가
			if (Math.abs(next - cur) > 1) return false;

			if (cur < next) { // ◢ 모양이면 높이 차이 발생 지점 이전을 검사
				for (int j=i; j>=i-l+1; j--) {
					if (j<0 || arr[j]!=cur || used[j]) return false;
					used[j] = true;
				}
			} else { // ◣ 모양이면 높이 차이 발생 지점 다음을 검사
				for (int j=i+1; j<=i+l; j++) {
					if (j>=n || arr[j]!=next || used[j]) return false;
					used[j] = true;
				}
			}
		}
		return true;
	}
}
