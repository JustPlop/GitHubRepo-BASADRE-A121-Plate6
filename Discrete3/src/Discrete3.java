import java.util.*;

public class Discrete3 {

    // class to represent a graph
    static class Graph {
        private final int V;  // Number of vertices
        private final LinkedList<Integer>[] adj;  // Adjacency list

        // constructor
        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        // add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        // utility method to check for cycle in a graph
        private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
            visited[v] = true;

            // recur for all the vertices adjacent to this vertex
            for (Integer adjVertex : adj[v]) {
                // If an adjacent vertex is not visited, then recur for that adjacent vertex
                if (!visited[adjVertex]) {
                    if (isCyclicUtil(adjVertex, visited, v)) {
                        return true;
                    }
                }
                // if an adjacent vertex is visited and not the parent of the current vertex, then there is a cycle
                else if (adjVertex != parent) {
                    return true;
                }
            }
            return false;
        }

        // check if the graph contains a cycle
        boolean isCyclic() {
            // mark all the vertices as not visited and not part of the recursion stack
            boolean[] visited = new boolean[V];

            // call the recursive helper function to detect cycle in different DFS trees
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {  // dont recur for 'i' if already visited
                    if (isCyclicUtil(i, visited, -1)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    // driver method to test the above methods
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read number of vertices and edges
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();

        // create a graph with V vertices
        Graph graph = new Graph(V);

        // read each edge
        System.out.println("Enter the edges (pair of vertices separated by space):");
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        // check if the graph contains a cycle
        if (graph.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }

        scanner.close();
    }
}
