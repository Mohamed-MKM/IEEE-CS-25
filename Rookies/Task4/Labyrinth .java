import java.util.*;

public class Path {
    static int n, m;
    static char[][] position;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[] directions = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        position = new char[n][m];
        visited = new boolean[n][m];
        int startX = -1, startY = -1, endX = -1, endY = -1;

        for (int i = 0; i < n; i++) {
            position[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (position[i][j] == 'A') {
                    startX = i;
                    startY = j;
                } else if (position[i][j] == 'B') {
                    endX = i;
                    endY = j;
                }
            }
        }

        String result = bfs(startX, startY, endX, endY);
        System.out.println(result);

        sc.close();
    }
    static String bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;

        char[][] parentDir = new char[n][m];
        int[][] parentX = new int[n][m];
        int[][] parentY = new int[n][m];

        queue.add(new int[]{startX, startY});
        parentX[startX][startY] = -1;
        parentY[startX][startY] = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                StringBuilder path = new StringBuilder();
                while (parentX[x][y] != -1) { // Backtrack from B to A
                    path.append(parentDir[x][y]);
                    int tempX = parentX[x][y];
                    int tempY = parentY[x][y];
                    x = tempX;
                    y = tempY;
                }
                return "YES\n" + path.length() + "\n" + path.reverse();
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && position[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});

                    parentX[nx][ny] = x;
                    parentY[nx][ny] = y;
                    parentDir[nx][ny] = directions[i];
                }
            }
        }

        return "NO";
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
