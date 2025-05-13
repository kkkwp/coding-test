import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int cnt = sc.nextInt();
            int min = 100, max = 1;
            int[] boxes = new int[101];
            for (int i=1; i<=100; i++) {
                int h = sc.nextInt();
                boxes[h]++;
                min = Math.min(min, h);
                max = Math.max(max, h);
            }

            while (cnt>0 && max-min>1) {
                // 평탄화 진행
                // 최고 높이의 건물 개수는 -1, 그 다음으로 높은 건물 개수가 +1 된다.
                // 최저 높이의 건물 개수도 -1, 그 다음으로 높은 건물 개수가 +1 된다.
                boxes[max]--;
                boxes[max-1]++;
                boxes[min]--;
                boxes[min+1]++;
                cnt--;

                // min과 max 값을 업데이트한다.
                while (boxes[min] == 0) min++;
                while (boxes[max] == 0) max--;
            }
            System.out.println("#" + test_case + " " + (max-min));
        }
    }
}