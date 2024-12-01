import java.util.Scanner;

public class ParticlesMeet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        String directions = sc.next();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }

        int minTime = Integer.MAX_VALUE;
        boolean collided = false;

        for (int i = 0; i < n - 1; i++) {
            if (directions.charAt(i) == 'R' && directions.charAt(i + 1) == 'L') {
                int time = (positions[i + 1] - positions[i]) / 2;
                minTime = Math.min(minTime, time);
                collided = true;
            }
        }

        System.out.println(collided ? minTime : -1);

        sc.close();
    }
}
