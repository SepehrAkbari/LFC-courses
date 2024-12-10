public class Final_23 {
    public static int findVertex(int[][] adjMatrix) {
        int V = adjMatrix.length;

        // iterating over each row
        for (int i = 0; i < V; i++) {
            boolean hasOutgoingEdges = false;

            // checking for outgoing edges
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] == 1) {
                    hasOutgoingEdges = true; 
                    break; // if we find one, we can stop and move on to the next row
                }
            }

            if (!hasOutgoingEdges) {
                return i;
            }
        }

        // if all rows have outgoing edges:
        return -1;
    }

    public static void main(String[] args) {
        // i'll just test the question's example
        int[][] adjMatrix = {
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        System.out.println(findVertex(adjMatrix));
    }
}