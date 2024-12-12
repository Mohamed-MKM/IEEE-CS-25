import java.util.*;

public class Goal {
    static int n, m;
    static char[][] position;
    static int[][] mTime;
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
        mTime = new int[n][m];
        visited = new boolean[n][m];
        for (int[] row : mTime) Arrays.fill(row, Integer.MAX_VALUE);

        int startX = -1, startY = -1;
        Queue<int[]> monsterQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            position[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (position[i][j] == 'A') {
                    startX = i;
                    startY = j;
                } else if (position[i][j] == 'M') {
                    monsterQueue.add(new int[]{i, j});
                    mTime[i][j] = 0;
                }
            }
        }

        bfsMonsters(monsterQueue);
        String result = bfsPlayer(startX, startY);
        System.out.println(result);
        sc.close();
    }

    static void bfsMonsters(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = mTime[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && position[nx][ny] == '.' && mTime[nx][ny] > time + 1) {
                    mTime[nx][ny] = time + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static String bfsPlayer(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] parent = new int[n][m];
        char[][] direction = new char[n][m];
        for (int[] row : parent) Arrays.fill(row, -1);

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (isBoundary(x, y)) {
                StringBuilder path = new StringBuilder();
                while (parent[x][y] != -1) {
                    path.append(direction[x][y]);
                    int px = parent[x][y] / m;
                    int py = parent[x][y] % m;
                    x = px;
                    y = py;
                }
                return "YES\n" + path.length() + "\n" + path.reverse();
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && position[nx][ny] == '.' && mTime[nx][ny] > mTime[x][y] + 1) {
                    visited[nx][ny] = true;
                    parent[nx][ny] = x * m + y;
                    direction[nx][ny] = directions[i];
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return "NO";
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static boolean isBoundary(int x, int y) {
        return x == 0 || x == n - 1 || y == 0 || y == m - 1;
    }
}
