import java.util.*;

public class Discrete7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        int[][] edges = new int[numEdges][3]; // Each edge represented by {vertex1, vertex2, count}

        System.out.println("Enter the vertex pairs associated with the edges and the number of times each edge appears:");
        for (int i = 0; i < numEdges; i++) {
            edges[i][0] = scanner.nextInt(); // Vertex 1
            edges[i][1] = scanner.nextInt(); // Vertex 2
            edges[i][2] = scanner.nextInt(); // Count
        }

        int[][] incidenceMatrix = constructIncidenceMatrix(numVertices, numEdges, edges);

        // Print the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int[][] constructIncidenceMatrix(int numVertices, int numEdges, int[][] edges) {
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        for (int i = 0; i < numEdges; i++) {
            int vertex1 = edges[i][0];
            int vertex2 = edges[i][1];
            int count = edges[i][2];

            incidenceMatrix[vertex1 - 1][i] = count;
            incidenceMatrix[vertex2 - 1][i] = count;
        }

        return incidenceMatrix;
    }
}
