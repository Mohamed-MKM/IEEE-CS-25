import java.util.Scanner;

public class PoliceandCrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int crimes = 0;
        int officers = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x == -1){
                if (officers > 0) {
                    officers--;
                }else {
                    crimes++;
                }


            }else {
                officers+=x;
            }

        }
        System.out.println(crimes);
        sc.close();
    }
}
