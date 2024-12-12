import java.util.*;

public class MinNumOfRoads {
    static List<List<Integer>> vision = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            vision.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            vision.get(a).add(b);
            vision.get(b).add(a);
        }

        visited = new boolean[n + 1];
        List<Integer> representatives = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                representatives.add(i);
                dfs(i);
            }
        }

        int numNewRoads = representatives.size() - 1;
        System.out.println(numNewRoads);

        for (int i = 0; i < numNewRoads; i++) {
            System.out.println(representatives.get(i) + " " + representatives.get(i + 1));
        }

        sc.close();
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : vision.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
