import java.util.Scanner;

public class AirConditioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cowStart = new int[N];
        int[] cowEnd = new int[N];
        int[] cowCooling = new int[N];

        for (int i = 0; i < N; i++) {
            cowStart[i] = sc.nextInt();
            cowEnd[i] = sc.nextInt();
            cowCooling[i] = sc.nextInt();
        }

        int[] acStart = new int[M];
        int[] acEnd = new int[M];
        int[] acCooling = new int[M];
        int[] acCost = new int[M];

        for (int i = 0; i < M; i++) {
            acStart[i] = sc.nextInt();
            acEnd[i] = sc.nextInt();
            acCooling[i] = sc.nextInt();
            acCost[i] = sc.nextInt();
        }

        final int INF = Integer.MAX_VALUE;
        int[] dp = new int[1 << N];
        for (int i = 0; i < (1 << N); i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int ac = 0; ac < M; ac++) {
            for (int mask = (1 << N) - 1; mask >= 0; mask--) {
                int newMask = mask;
                int totalCooling = 0;

                for (int i = 0; i < N; i++) {
                    if (cowStart[i] <= acEnd[ac] && cowEnd[i] >= acStart[ac]) {
                        totalCooling += acCooling[ac];
                    }
                    if (totalCooling >= cowCooling[i]) {
                        newMask |= (1 << i);
                    }
                }

                dp[newMask] = Math.min(dp[newMask], dp[mask] + acCost[ac]);
            }
        }

        System.out.println(dp[(1 << N) - 1]);
    }
}
