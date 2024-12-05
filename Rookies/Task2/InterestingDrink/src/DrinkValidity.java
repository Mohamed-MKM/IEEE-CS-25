import java.util.Arrays;
import java.util.Scanner;

public class DrinkValidity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] pricesArray = new int[n];
        for (int i = 0; i < n; i++) {
            pricesArray[i] = sc.nextInt();
        }

        Arrays.sort(pricesArray);

        int numOfDays = sc.nextInt();
        for (int i = 0; i < numOfDays; i++) {
            int budget = sc.nextInt();
            int numOfShops = BinarySearch(pricesArray, budget);
            System.out.println(numOfShops);
        }


    }
    private static int BinarySearch(int[] pricesArray, int budget) {
        int low = 0;
        int high = pricesArray.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (pricesArray[mid] <= budget) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
