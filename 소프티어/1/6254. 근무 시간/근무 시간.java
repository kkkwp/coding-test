import java.io.*;
import java.util.*;

public class Main {

    static int calculateMinutes(String start, String end) {
        String[] startTimes = start.split(":");
        String[] endTimes = end.split(":");
        int startHour = Integer.parseInt(startTimes[0]);
        int startMinute = Integer.parseInt(startTimes[1]);
        int endHour = Integer.parseInt(endTimes[0]);
        int endMinute = Integer.parseInt(endTimes[1]);

        return (endHour*60 + endMinute) - (startHour*60 + startMinute);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for (int i=0; i<5; i++) {
            String[] times = br.readLine().split(" ");
            answer += calculateMinutes(times[0], times[1]);
        }
        System.out.print(answer);
    }
}