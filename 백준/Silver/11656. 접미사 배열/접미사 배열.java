import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		List<String> words = new ArrayList<>();
		int size = s.length();
		for (int i = 0; i < size; i++) {
			words.add(s.substring(i, size));
		}
		Collections.sort(words);
		words.forEach(System.out::println);
	}
}
