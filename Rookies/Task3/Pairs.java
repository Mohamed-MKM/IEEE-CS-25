import java.util.Arrays;
import java.util.Scanner;

public class DiffAndTarget {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int diff = in.nextInt();
        int[] numberArray = new int[n];
        for (int i = 0; i < n; i++) {
            numberArray[i] = in.nextInt();
        }
        Arrays.sort(numberArray);
        int result = pair(diff, numberArray);
        System.out.println(result);
    }

    public static int pair(int k, int[] arr) {
        int start = 0, end = 1, count = 0;

        while (end < arr.length) {
            int diff = arr[end] - arr[start];

            if (diff == k) {
                count++;
                start++;
            } else if (diff < k) {
                end++;
            } else {
                start++;
            }

            if (start == end) {
                end++;
            }
        }

        return count;
    }
}
