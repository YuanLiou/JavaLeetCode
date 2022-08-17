import utils.ArrayUtils;

public class FloodFill {
    public static void main(String[] args) {
        var sample01 = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        // Expected: {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}
        var result = floodFill(sample01, 1, 1, 2);

        var sample02 = new int[][]{{0, 0, 0}, {0, 0, 0}};
        // Expected: {{0, 0, 0}, {0, 0, 0}}
        var result02 = floodFill(sample02, 0, 0, 0);

        ArrayUtils.printMatrix(result02);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if (target == color) {
            return image;
        }

        traverse(image, sr, sc, target, color);
        return image;
    }

    private static void traverse(int[][] image, int row, int col, int target, int color) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }

        int currentSelected = image[row][col];
        if (currentSelected != target) {
            return;
        }

        image[row][col] = color;

        traverse(image, row - 1, col, target, color); // Find top
        traverse(image, row + 1, col, target, color); // Find bottom
        traverse(image, row, col - 1, target, color); // Find left
        traverse(image, row, col + 1, target, color); // Find right
    }
}
