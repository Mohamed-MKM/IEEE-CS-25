import java.util.Scanner;

public class AppleDivision {
    static int n;
    static int[] weights;
    static long totalSum;
    static long result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        weights = new int[n];
        totalSum = 0;
        result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            totalSum += weights[i];
        }

        subsetSum(0, 0);
        System.out.println(result);
    }

    static void subsetSum(int index, long currentSum) {
        if (index == n) {
            long otherSum = totalSum - currentSum;
            result = Math.min(result, Math.abs(currentSum - otherSum));
            return;
        }

        subsetSum(index + 1, currentSum + weights[index]);
        subsetSum(index + 1, currentSum);
    }
}
