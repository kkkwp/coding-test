import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Queue<Integer> trucks = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			trucks.offer(Integer.parseInt(st.nextToken()));

		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++)
			bridge.add(0);

		int time = 0;
		int cur = 0;
		while (!bridge.isEmpty()) {
			time++;
			cur -= bridge.poll();
			
			if (trucks.isEmpty())
				continue;
			
			if (trucks.peek() + cur <= l) {
				int truck = trucks.poll();
				cur += truck;
				bridge.offer(truck);
			} else {
				bridge.offer(0);
			}
		}
		System.out.println(time);
	}
}
