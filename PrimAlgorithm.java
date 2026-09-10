import java.util.*;

public class PrimAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int n = graph.length;
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mst = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;

            for (int v = 0; v < n; v++) {
                if (!mst[v] && (u == -1 || key[v] < key[u])) {
                    u = v;
                }
            }

            mst[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mst[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
        }
    }
}
