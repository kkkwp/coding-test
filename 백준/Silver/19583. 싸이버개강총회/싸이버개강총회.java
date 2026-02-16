import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = toMinute(st.nextToken()); // 개강총회를 시작한 시간
		int e = toMinute(st.nextToken()); // 개강총회를 끝낸 시간
		int q = toMinute(st.nextToken()); // 개강총회 스트리밍을 끝낸 시간

		HashSet<String> entered = new HashSet<>();
		HashSet<String> exited = new HashSet<>();
		String input;
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input);
			int time = toMinute(st.nextToken()); // 시간
			String nickname = st.nextToken(); // 학회원 닉네임

			// 1. 개강총회를 시작하기 전에, 학회원의 입장 확인 여부를 확인
			if (time <= s)
				entered.add(nickname);
			// 2. 개강총회를 끝내고 나서, 스트리밍을 끝낼 때까지 학회원의 퇴장 확인 여부를 확인
			if (e <= time && time <= q)
				exited.add(nickname);
		}

		int answer = 0;
		for (String nickname : entered)
			if (exited.contains(nickname))
				answer++;
		System.out.println(answer);
	}

	static int toMinute(String s) {
		String hour = s.substring(0, 2);
		String minute = s.substring(3, 5);
		return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
	}
}
