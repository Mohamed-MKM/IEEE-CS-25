import java.util.*;

public class RoomNumbers {
    static int n, m;
    static char[][] place;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        place = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            place[i] = sc.nextLine().toCharArray();
        }

        int roomCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (place[i][j] == '.' && !visited[i][j]) {
                    dfs(i, j);
                    roomCount++;
                }
            }
        }

        System.out.println(roomCount);

        sc.close();
    }

    static void dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0], cy = current[1];


            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValid(nx, ny) && place[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    stack.push(new int[] {nx, ny});
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
