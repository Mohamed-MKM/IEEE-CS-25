import java.util.Scanner;

public class ConsumedPars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] timeArray = new int[n];
        for (int i = 0; i < n; i++) {
            timeArray[i] = sc.nextInt();


        }


        int firstPos = 0;
        int secondPos = n - 1;
        int tAlice = 0;
        int tBob = 0;

        while (firstPos <= secondPos) {
            if (tAlice <= tBob) {
                tAlice += timeArray[firstPos];
                firstPos++;

            } else {
                tBob += timeArray[secondPos];
                secondPos--;

            }
        }

        System.out.println(firstPos + " " + (n - firstPos));


    }
}

