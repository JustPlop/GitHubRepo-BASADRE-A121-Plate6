import java.util.Scanner;

public class Discrete6 {

    private int[][] adjacencyMatrix;
    private int numVertices;

    public Discrete6(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        // For undirected graph
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void addDirectedEdge(int source, int destination) {
        // For directed graph
        adjacencyMatrix[source][destination] = 1;
    }

    public void display() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        Discrete6 graph = new Discrete6(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the vertex pairs associated with the edges:");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination); // For undirected graph
            // graph.addDirectedEdge(source, destination); // For directed graph
        }

        graph.display();
        scanner.close();
    }
}
