import java.util.Scanner;

public class FarthestPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int [] x_Cooridnates = new int [n];
        for (int i = 0; i < n; i++) {
            x_Cooridnates[i] = sc.nextInt();
        }

        long numOfGroups = 0;
        int clmPointer = 0;
        for (int i = 0; i < n; i++) {
            while (clmPointer < n && x_Cooridnates[clmPointer] - x_Cooridnates[i] <= d) {
                clmPointer++;
            }

            int range = clmPointer - i - 1;
            if (range >= 2) {
                numOfGroups += ((long) range * (range - 1) / 2);
            }
        }

        System.out.println(numOfGroups);
    }


    }

