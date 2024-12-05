import java.util.Scanner;

public class CellularDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] nSequence = new int[n];
        int [] mSequence = new int[m];
        for (int i = 0; i < n; i++) {
            nSequence[i] = sc.nextInt();
        }



        for (int i = 0; i < m; i++) {
            mSequence[i] = sc.nextInt();
        }



        int citiesPoint = 0;
        int cellularPoint = 0;
        int r_Radius = 0;

        while (citiesPoint < n) {
            while (cellularPoint < m - 1 && Math.abs(nSequence[citiesPoint] - mSequence[cellularPoint + 1]) <= Math.abs(nSequence[citiesPoint] - mSequence[cellularPoint])) {
                cellularPoint++;
            }

            r_Radius = Math.max(r_Radius, Math.abs(nSequence[citiesPoint] - mSequence[cellularPoint]));
            citiesPoint++;
        }

        System.out.println(r_Radius);
    }

    }

