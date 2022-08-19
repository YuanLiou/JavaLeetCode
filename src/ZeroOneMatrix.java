import java.util.LinkedList;
import java.util.Queue;
import utils.ArrayUtils;

public class ZeroOneMatrix {

    public static void main(String[] args) {
        var sample01 = new int[][] {
            { 0, 0, 0},
            { 0, 1, 0},
            { 1, 1, 1}
        };

        var sample02 = new int[][] {
            { 0, 0, 0},
            { 0, 1, 0},
            { 0, 0, 0}
        };

        var zeroOneMatrix = new ZeroOneMatrix();

        // Expected = { { 0, 0, 0}, {0, 1, 0}, {1, 2, 1} }
        var result01 =  zeroOneMatrix.updateMatrix(sample01);
        var result02 =  zeroOneMatrix.updateMatrix(sample02);
        ArrayUtils.printMatrix(result02);
    }

    private record Position(int row, int col) {
        Position top() {
            return new Position(row - 1, col);
        }

        Position bottom() {
            return new Position(row + 1, col);
        }

        Position left() {
            return new Position( row, col - 1);
        }

        Position right() {
            return new Position( row, col + 1);
        }

        static boolean canVisit(Position position, int rows, int columns, int[][] visited) {
            return !(position.row < 0 || position.row >= rows ||
                position.col < 0 || position.col >= columns) &&
                visited[position.row][position.col] == -1; // -1 means it hasn't been visited yet.
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        // 1) See 0 as visited, and offer these index into Queue
        // 2) Pop out an index from Queue, doing BFS on it.
        // 3) If an adjacent index of a position is visited, ignore.
        // 4) If an adjacent index not visited yet. Visit it, and offer it to the Queue.

        int rows = mat.length;
        int columns = mat[0].length;
        int[][] visited = new int[rows][columns];
        Queue<Position> queue = new LinkedList<>();

        // 1) See 0 as visited, and offer these 0 index into Queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int current = mat[i][j];
                if (current == 0) {
                    visited[i][j] = 0;
                    queue.offer(new Position(i, j));
                } else {
                    visited[i][j] = -1;
                }
            }
        }

        // 2) Pop out the index from Queue, doing DFS of it.
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentIndex = 0;
            while (currentIndex < size) {
                Position currentPosition = queue.poll();
                int levelCounts = visited[currentPosition.row][currentPosition.col];

                // 3) If an adjacent index of a position is visited, ignore.
                // 4) If an adjacent index not visited yet. Visit it, and offer it to the Queue.
                updateVisitedLevelCounts(currentPosition.top(), rows, columns, visited, levelCounts, queue);
                updateVisitedLevelCounts(currentPosition.bottom(), rows, columns, visited, levelCounts, queue);
                updateVisitedLevelCounts(currentPosition.left(), rows, columns, visited, levelCounts, queue);
                updateVisitedLevelCounts(currentPosition.right(), rows, columns, visited, levelCounts, queue);

                currentIndex++;
            }
        }
        return visited;
    }

    private void updateVisitedLevelCounts(
        Position position,
        int rows,
        int columns,
        int[][] visited,
        int levelCounts,
        Queue<Position> queue
    ) {
        if (Position.canVisit(position, rows, columns, visited)) {
            visited[position.row][position.col] = levelCounts + 1;
            queue.offer(position);
        }
    }
}
