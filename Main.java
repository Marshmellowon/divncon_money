import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        int left = 0;
        int right = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int i[] = new int[n];

        for (int j = 0; j < n; j++) {
            i[j] = sc.nextInt();
            left = i[j] > left ? i[j] : left;
            right += i[j];
        }

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
