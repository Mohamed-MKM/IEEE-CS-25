import java.util.Scanner;

public class ValeraFreeTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfBooks = sc.nextInt();
        int freeTime = sc.nextInt();

        int [] numOfMinutes = new int[numOfBooks];
        for (int i = 0; i < numOfBooks; i++) {
            numOfMinutes[i] = sc.nextInt();
        }

        int firstBook = 0;
        int lastBook = 0;
        int consumedTime = 0;
        int numOfBooksread = 0;

        while (lastBook < numOfBooks) {
            consumedTime += numOfMinutes[lastBook];

            while (consumedTime > freeTime) {
                consumedTime -= numOfMinutes[firstBook];
                firstBook++;
            }

            numOfBooksread = Math.max(numOfBooksread, lastBook - firstBook + 1);

            lastBook++;
        }
        System.out.println(numOfBooksread);



    }
}
