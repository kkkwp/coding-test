import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 걸그룹의 수
		int m = Integer.parseInt(st.nextToken()); // 맞혀야 할 문제의 수

		HashMap<String, TreeSet<String>> teamToMembers = new HashMap<>();
		HashMap<String, String> memberToTeam = new HashMap<>();
		while (n-->0) {
			String team = br.readLine(); // 팀의 이름
			int num = Integer.parseInt(br.readLine()); // 인원 수
			TreeSet<String> members = new TreeSet<>();
			while (num-->0) {
				String name = br.readLine();
				members.add(name);
				memberToTeam.put(name, team);
			}
			teamToMembers.put(team, members);
		}

		while (m-->0) {
			String quiz = br.readLine();
			int type = Integer.parseInt(br.readLine());
			if (type == 0) {
				for (String member : teamToMembers.get(quiz))
					System.out.println(member);
			} else
				System.out.println(memberToTeam.get(quiz));
		}
	}
}
