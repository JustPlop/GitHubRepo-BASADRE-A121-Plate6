import java.util.*;

public class Discrete5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of edges:");
        int numberOfEdges = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();

        System.out.println("Enter the edges in the format 'src dest':");
        for (int i = 0; i < numberOfEdges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            edges.add(new Edge(src, dest));
        }

        scanner.close();

        // Determine if the graph is bipartite
        boolean isBipartite = isGraphBipartite(edges);
        System.out.println("The graph is " + (isBipartite ? "bipartite" : "not bipartite"));
    }

    static class Edge {
        int src, dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean isGraphBipartite(List<Edge> edges) {
        // Find the maximum vertex number to determine the number of vertices
        int maxVertex = 0;
        for (Edge edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge.src, edge.dest));
        }

        // Create an adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= maxVertex; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (Edge edge : edges) {
            adjList.get(edge.src).add(edge.dest);
            adjList.get(edge.dest).add(edge.src);
        }

        // Array to store colors assigned to each vertex
        int[] colors = new int[maxVertex + 1];
        Arrays.fill(colors, -1); // -1 means no color

        // Perform BFS for each component
        for (int i = 0; i <= maxVertex; i++) {
            if (colors[i] == -1) { // Not colored yet
                if (!bfsCheck(adjList, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(List<List<Integer>> adjList, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0; // Start coloring with 0

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adjList.get(u)) {
                if (colors[v] == -1) {
                    // If not colored, assign opposite color to the current vertex
                    colors[v] = 1 - colors[u];
                    queue.add(v);
                } else if (colors[v] == colors[u]) {
                    // If the adjacent vertex has the same color, graph is not bipartite
                    return false;
                }
            }
        }
        return true;
    }
}
