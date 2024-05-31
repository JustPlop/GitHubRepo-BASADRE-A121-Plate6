import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Discrete2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int n = scanner.nextInt();
        
        
        int [][] adjacencyMatrix = new int [n][n];
        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        
        Map<String, Integer> edgeCountMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j]>0) {
                    String edge = "(" + i + "," + j + ")";
                    edgeCountMap.put(edge, adjacencyMatrix[i][j]);
                }
            }
        }
        System.out.println("Edges and their counts: ");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + " time(s)");
        }
        scanner.close();
    }

}