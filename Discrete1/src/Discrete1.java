import java.util.*;

public class Discrete1 {
    private int vertices; // number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list representation of the graph

    // constructor
    public Discrete1(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList<>();
    }

    // add an edge to the graph
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    // perform a DFS traversal from a given vertex
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adjacencyList[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    //check if the graph is connected and to find the number of connected components
    void isConnected() {
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited, false);

        // perform DFS from the first vertex
        DFSUtil(0, visited);

        // check if all vertices are visited
        boolean isConnected = true;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                isConnected = false;
                break;
            }
        }

        if (isConnected) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            int count = 0;
            Arrays.fill(visited, false);
            for (int v = 0; v < vertices; v++) {
                if (!visited[v]) {
                    DFSUtil(v, visited);
                    count++;
                }
            }
            System.out.println("Number of connected components: " + count);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();

        Discrete1 g = new Discrete1(V);

        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (format: u v for an edge between vertex u and vertex v):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.addEdge(u, v);
        }

        g.isConnected();
    }
}
