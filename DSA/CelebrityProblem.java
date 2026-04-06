public class CelebrityProblem {

    
    
    private static int[][] matrix = {
        {0, 1, 1, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 0},
        {1, 1, 1, 0}
    };

    private static boolean knows(int a, int b) {
        return matrix[a][b] == 1;
    }

    public static int findCelebrity(int n) {
        int candidate = 0;

        
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                
                candidate = i;
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;

            
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);

        if (result != -1) {
            System.out.println("The celebrity is at index: " + result);
        } else {
            System.out.println("No celebrity found in the party.");
        }
    }
}