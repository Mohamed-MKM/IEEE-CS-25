import java.util.Scanner;

public class OriginalText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);
        String sequence = sc.next();

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl;";
        String row3 = "zxcvbnm,./";

        StringBuilder OriginalText = new StringBuilder();
        for (char c : sequence.toCharArray()) {
            OriginalText.append(getOriginalChar(c, letter, row1, row2, row3));
        }


        System.out.println(OriginalText.toString());

        sc.close();

    }
    private static char getOriginalChar(char c, char direction, String row1, String row2, String row3) {

        String row = null;
        if (row1.indexOf(c) != -1) {
            row = row1;
        } else if (row2.indexOf(c) != -1) {
            row = row2;
        } else if (row3.indexOf(c) != -1) {
            row = row3;
        }

        int index = row.indexOf(c);

        if (direction == 'L') {
            return row.charAt(index + 1);
        } else {
            return row.charAt(index - 1);
        }
    }
}
