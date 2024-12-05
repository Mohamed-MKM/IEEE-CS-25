import java.util.Scanner;

public class ProgramCodeTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeOfProgram = sc.nextInt();
        int productivity = sc.nextInt();


        int left = 1;
        int right = sizeOfProgram;

        while (left <= right) {
            int mid = (left + right) / 2;
            int totalLines = 0, current = mid;

            while (current > 0) {
                totalLines += current;
                current /= productivity;
            }

            if (totalLines >= sizeOfProgram) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
