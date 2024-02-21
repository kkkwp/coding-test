import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int getTimes(String time) {
		int hh = Integer.parseInt(time.substring(0, 2));
		int mm = Integer.parseInt(time.substring(3, 5));
		int ss = Integer.parseInt(time.substring(6, 8));
		return hh * 3600 + mm * 60 + ss;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String now = br.readLine();
		String goal = br.readLine();

		int need = getTimes(goal) - getTimes(now);
		if (need <= 0) {
			need += 3600 * 24;
		}
		int hh = need / 3600;
		int mm = (need % 3600) / 60;
		int ss = need % 60;
		System.out.printf("%02d:%02d:%02d", hh, mm, ss);
	}
}
