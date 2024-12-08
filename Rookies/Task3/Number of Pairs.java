import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            long count = 0;
            for (int i = 0; i < n - 1; i++) {
                int left = l - arr[i];
                int right = r - arr[i];

                count += findPairs(arr, left, right, i + 1, n);
            }

            System.out.println(count);
        }
        sc.close();
    }

    private static int findPairs(int[] arr, int left, int right, int low, int high) {
        return binarySearch(arr, right, low, high) - binarySearch(arr, left - 1, low, high);
    }

    private static int binarySearch(int[] arr, int value, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= value) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
