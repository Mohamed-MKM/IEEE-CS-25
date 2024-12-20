import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        StringBuilder result = new StringBuilder();
        while (n != 1) {
            result.append(n).append(" ");
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        result.append(n);
        System.out.println(result);
    }
}
