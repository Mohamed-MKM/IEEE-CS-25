import java.util.Arrays;
import java.util.Scanner;

public class MaximumNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] progSkills = new int[n];
        for (int i = 0; i < n; i++) {
            progSkills[i] = in.nextInt();
        }
        Arrays.sort(progSkills);

        int max = findMaxBalancedTeam(progSkills, n);
        System.out.println(max);
    }


    private static int findMaxBalancedTeam(int[] progSkills, int n) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            while ((progSkills[i] - progSkills[start]) > 5) {
                start++;
            }
            max = Math.max(max, i - start+1);
        }
        return max;
    }
}
