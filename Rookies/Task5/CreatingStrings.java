import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CreatingStrings {

        public static void generateStrings(String str, String perm, Set<String> result) {
            if (str.length() == 0) {
                result.add(perm);
                return;
            }

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String remaining = str.substring(0, i) + str.substring(i + 1);
                generateStrings(remaining, perm + ch, result);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().trim();
            Set<String> result = new TreeSet<>();

            generateStrings(input, "", result);

            System.out.println(result.size());
            for (String s : result) {
                System.out.println(s);
            }
        }


}
