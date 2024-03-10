import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Staff {
		String name;
		int vote;
		int chip = 0;

		public Staff(String name, int vote) {
			this.name = name;
			this.vote = vote;
		}
	}

	static class Score {
		int idx;
		double vote = 0;

		public Score(int idx, double vote) {
			this.idx = idx;
			this.vote = vote;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		List<Staff> staffs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int vote = Integer.parseInt(st.nextToken());
			if (vote < x * 0.05)
				continue;
			staffs.add(new Staff(name, vote));
		}

		List<Score> scores = new ArrayList<>();
		for (int i = 0; i < staffs.size(); i++) {
			for (int j = 1; j <= 14; j++) {
				scores.add(new Score(i, (double)staffs.get(i).vote / j));
			}
		}

		scores.sort((o1, o2) -> Double.compare(o2.vote, o1.vote));
		for (int i = 0; i < 14; i++) {
			staffs.get(scores.get(i).idx).chip++;
		}

		staffs.sort((o1, o2) -> {
			if (o1.name.compareTo(o2.name) < 0)
				return -1;
			else if (o1.name.equals(o2.name))
				return 0;
			else
				return 1;
		});

		for (Staff staff : staffs) {
			System.out.println(staff.name + " " + staff.chip);
		}
	}
}
