import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); // 과목의 수강 가능 인원
		int l = Integer.parseInt(st.nextToken()); // 대기목록의 길이

		// 중복을 허용하지 않음 → Set
		// 순서가 있음 → LinkedHashSet
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for (int i=0; i<l; i++) {
			String id = br.readLine();
			set.remove(id);
			set.add(id);
		}

		// set은 인덱스 접근이 안되므로 count 변수 이용
		int cnt = 0;
		for (String id : set) {
			if (cnt == k) break;
			System.out.println(id);
			cnt++;
		}
	}
}
