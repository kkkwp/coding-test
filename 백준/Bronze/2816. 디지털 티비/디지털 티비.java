import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i=0; i<n; i++)
            list.add(br.readLine());

        StringBuilder sb = new StringBuilder();
        int idx = list.indexOf("KBS1");
        for (int i=0; i<idx; i++)
            sb.append('1');
        for (int i=idx-1; i>=0; i--) {
            String tmp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, tmp);
            sb.append('4');
        }

        idx = list.indexOf("KBS2");
        for (int i=0; i<idx; i++)
            sb.append('1');
        for (int i=idx-1; i>=1; i--) {
            sb.append('4');
            String tmp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, tmp);
        }
        System.out.println(sb);
    }
}
