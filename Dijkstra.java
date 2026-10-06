
import java.util.*;

class Dijkstra {

    static int[] dijkstra(int[][] graph, int source, int n) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distance[source] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < minDistance) {
                    minDistance = distance[i];
                    u = i;
                }
            }

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        int[] distance = dijkstra(graph, source, n);

        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " = INF");
            } else {
                System.out.println("Vertex " + i + " = " + distance[i]);
            }
        }

        sc.close();
    }
}
