import java.util.Scanner;

public class ChessboardAndQueens {
    static int count = 0;
    static boolean[] cols = new boolean[8], diag1 = new boolean[15], diag2 = new boolean[15];

    public static void solve(char[][] board, int row) {
        if (row == 8) {
            count++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (board[row][col] == '*' || cols[col] || diag1[row - col + 7] || diag2[row + col]) continue;
            cols[col] = diag1[row - col + 7] = diag2[row + col] = true;
            solve(board, row + 1);
            cols[col] = diag1[row - col + 7] = diag2[row + col] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        solve(board, 0);
        System.out.println(count);
    }
}
