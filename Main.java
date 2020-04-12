import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        int left = 0;
        int right = 0;
        n = sc.nextInt(); /* 날짜 */
        m = sc.nextInt(); /* m번 */
        int i[] = new int[n]; /* 금액 */

        System.out.println(n + "일동안 사용");
        for (int j = 0; j < n; j++) {
            i[j] = sc.nextInt();
            System.out.println(j + 1 + "번째 날:" + i[j]);

            left = i[j] > left ? i[j] : left;
            System.out.println("금액: " + left);
            /* 필요금액 총합 */
            right += i[j];
        }

        /* 이진탐색 알고리즘 */
        while (left <= right) {
            int count = 0;
            int sum = 0;
            int mid = (left + right) / 2;
            for (int j = 0; j < n; j++) {
                if (sum + i[j] > mid) {
                    sum = 0;
                    count++;
                }
                sum += i[j];
            }
            if (sum != 0) {
                count++;
            }
            if (count <= m) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        System.out.println(left);
    }
}
