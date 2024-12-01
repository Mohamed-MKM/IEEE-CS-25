import java.util.Scanner;

public class OrderPrescence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrHeights = new int[n];

        for (int i = 0; i < n; i++) {
            arrHeights[i] = sc.nextInt();
        }

        int max = 0;
        int min = n - 1;

        for (int i = 1; i < n; i++) {
            if (arrHeights[i] > arrHeights[max]) {
                max = i;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arrHeights[i] < arrHeights[min]) {
                min = i;
            }
        }

        int swaps = max + (n - 1 - min);

        if (max > min) {
            swaps -= 1;
        }

        System.out.println(swaps);

        sc.close();
    }
}
