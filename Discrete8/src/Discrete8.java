import java.util.*;

public class Discrete8 {

    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        boolean isIsomorphic(Graph g) {
            int[] map = new int[this.V];
            Arrays.fill(map, -1);
            boolean[] marked = new boolean[this.V];
            return isIsomorphicUtil(g, map, marked);
        }

        boolean isIsomorphicUtil(Graph g, int[] map, boolean[] marked) {
            // Check if all vertices have been mapped
            if (Arrays.stream(map).noneMatch(val -> val == -1))
                return true;

            // Count array to keep track of mapped vertices
            int[] count = new int[this.V];

            // Iterate through each vertex of this graph
            for (int i = 0; i < this.V; i++) {
                // If the current vertex is not mapped
                if (map[i] == -1) {
                    // Iterate through each vertex of the other graph
                    for (int j = 0; j < g.V; j++) {
                        // If the vertex in the other graph is not marked and has the same degree
                        if (!marked[j] && this.adj[i].size() == g.adj[j].size()) {
                            // Check if the adjacency lists of the current and potential mapping vertices match
                            boolean flag = true;
                            for (Integer neighbor : this.adj[i]) {
                                if (!marked[neighbor] && count[neighbor] != j) {
                                    flag = false;
                                    break;
                                }
                            }
                            // If the adjacency lists match, update the mapping and recursively check
                            if (flag) {
                                map[i] = j;
                                marked[j] = true;
                                for (Integer neighbor : this.adj[i]) {
                                    count[neighbor] = j;
                                }
                                if (isIsomorphicUtil(g, map, marked))
                                    return true;
                                // Backtrack if no isomorphism found
                                map[i] = -1;
                                marked[j] = false;
                                for (Integer neighbor : this.adj[i]) {
                                    count[neighbor] = -1;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices for Graph 1:");
        int V1 = scanner.nextInt();
        Graph g1 = new Graph(V1);

        System.out.println("Enter the number of edges for Graph 1:");
        int E1 = scanner.nextInt();
        System.out.println("Enter the edges for Graph 1:");
        for (int i = 0; i < E1; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g1.addEdge(v, w);
        }

        System.out.println("Enter the number of vertices for Graph 2:");
        int V2 = scanner.nextInt();
        Graph g2 = new Graph(V2);

        System.out.println("Enter the number of edges for Graph 2:");
        int E2 = scanner.nextInt();
        System.out.println("Enter the edges for Graph 2:");
        for (int i = 0; i < E2; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g2.addEdge(v, w);
        }

        if (g1.isIsomorphic(g2))
            System.out.println("Yes, the graphs are isomorphic.");
        else
            System.out.println("No, the graphs are not isomorphic.");

        scanner.close();
    }
}
