import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    public static void main(String[] args) {
        // expected = 3
        var sample01 = 12;

        // expected = 2
        var sample02 = 13;

        var result = numSquares(sample01);
        System.out.println("Result is " + result);
    }

    public static int numSquares(int n) {
        if (n == 1) {
            return 1;
        }

        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(n);

        // BFS to find shortest path
        int height = 1;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Integer currentNumber = nodes.poll();
                if (currentNumber == null) {
                    continue;
                }

                // Generate the reminder of the top nodes
                for (int j = 1; j * j <= currentNumber; j++) {
                    int remainder = currentNumber - (j * j);
                    if (remainder == 0) {
                        return height;
                    }
                    nodes.offer(remainder);
                }
            }

            height++;
        }
        return -1;
    }
}
