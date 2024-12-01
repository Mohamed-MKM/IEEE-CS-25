import java.util.Scanner;

public class LuckyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] luckyNumbers = {
                4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777
        };
        boolean isAlmostLucky = false;
        for (int i = 0; i < luckyNumbers.length; i++) {
            if (n % luckyNumbers[i] == 0) {
                isAlmostLucky = true;
                break;
            }
        }

        System.out.println(isAlmostLucky ? "YES" : "NO");

        sc.close();
    }
}
