import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int score = sc.nextInt();
            for (int i=0; i<score/5; i++) {     
                System.out.print("++++ ");
            }
            score %= 5;
            for (int i=0; i<score; i++) {
                System.out.print("|");
            }
            System.out.println();
        }
    }
}