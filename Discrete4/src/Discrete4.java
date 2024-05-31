import java.util.*;

public class Discrete4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of edges:");
        int edgesCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Map<Integer, Integer> degreeMap = new HashMap<>();

        System.out.println("Enter the pairs of vertices (one pair per line, separated by space):");
        for (int i = 0; i < edgesCount; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            // Increment the degree count for vertex u
            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);

            // Increment the degree count for vertex v
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }

        System.out.println("Degrees of vertices:");
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " has degree " + entry.getValue());
        }

        scanner.close();
    }
}
