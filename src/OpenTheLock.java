import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    public static void main(String[] args) {
        var sample01Deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        var target01 = "0202";

        var sample02Deadends = new String[]{"8888"};
        var target02 = "0009";

        var sample03Deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        var target03 = "8888";

        var result02 = openLock(sample03Deadends, target03);
        System.out.println("Result is " + result02);
    }

    public static int openLock(String[] deadends, String target) {
        // base case
        if (target.equals("0000")) {
            return 1;
        }

        Set<String> visited = new HashSet<>(Arrays.asList(deadends)); // reuse
        if (visited.contains("0000")) {
            return -1;
        }

        // Setup
        Queue<String> nodes = new LinkedList<>();

        // Add first one
        nodes.offer("0000");
        visited.add("0000");

        // Start doing BFS
        int height = 1;
        while (!nodes.isEmpty()) {
            int size = nodes.size();

            // Poll nodes from a layer
            for (int i = 0; i < size; i++) {
                String currentNumber = nodes.poll();
                if (currentNumber.equals(target)) {
                    return height - 1; // ignore "0000"
                }

                // Adjust the number
                for (int j = 0; j < 4; j++) {
                    char currentChar = currentNumber.charAt(j);

                    // increase, char - '0' to transform into a int
                    String increasedNumber = currentNumber.substring(0, j) + (currentChar == '9' ? 0 : currentChar - '0' + 1) + currentNumber.substring(j + 1);
                    if (visited.contains(increasedNumber)) {
                        continue;
                    }

                    visited.add(increasedNumber);
                    nodes.offer(increasedNumber);

                    // decrease
                    String decreasedNumber = currentNumber.substring(0, j) + (currentChar == '0' ? 9 : currentChar - '0' - 1) + currentNumber.substring(j + 1);
                    if (visited.contains(decreasedNumber)) {
                        continue;
                    }

                    visited.add(decreasedNumber);
                    nodes.offer(decreasedNumber);
                }
            }

            height++;
        }
        return -1;
    }
}
