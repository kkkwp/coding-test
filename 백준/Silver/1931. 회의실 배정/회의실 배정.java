import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Meeting {
		int start;
		int end;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		Arrays.sort(meetings, (o1, o2) -> {
			if (o1.end == o2.end) {
				return o1.start - o2.start;
			}
			return o1.end - o2.end;
		});
		int cnt = 0;
		int cur = 0;
		for (int i = 0; i < n; i++) {
			if (cur <= meetings[i].start) {
				cnt++;
				cur = meetings[i].end;
			}
		}
		System.out.println(cnt);
	}
}
