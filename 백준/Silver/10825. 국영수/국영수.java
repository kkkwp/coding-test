import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Student> students = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			students.add(new Student(name, korean, english, math));
		}

		Collections.sort(students, (o1, o2) -> {
			if (o1.korean != o2.korean)
				return o2.korean - o1.korean;
			if (o1.english != o2.english)
				return o1.english - o2.english;
			if (o1.math != o2.math)
				return o2.math - o1.math;
			return o1.name.compareTo(o2.name);
		});

		StringBuilder sb = new StringBuilder();
		for (Student s : students) {
			sb.append(s.name).append('\n');
		}
		System.out.println(sb);
	}

	static class Student {
		String name;
		int korean;
		int english;
		int math;

		Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
	}
}
