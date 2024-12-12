import java.util.*;

public class Main {
    static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); // Number of test cases
        sc.nextLine();

        while (testCases-- > 0) {
            String[] positions = sc.nextLine().split(" ");
            System.out.println(minMoves(positions[0], positions[1]));
        }

        sc.close();
    }

    static int minMoves(String start, String destination) {
        int sX = start.charAt(0) - 'a';
        int sY = start.charAt(1) - '1';
        int dX = destination.charAt(0) - 'a';
        int dY = destination.charAt(1) - '1';

        if (sX == dX && sY == dY) return 0;

        boolean[][] visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sX, sY, 0}); // {x, y, moves}
        visited[sX][sY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], moves = current[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == dX && ny == dY) return moves + 1;

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, moves + 1});
                }
            }
        }

        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
