import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ArrayUtils;

public class SpiralMatrix {

    public static void main(String[] args) {
        var sample01 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        var result = spiralOrder(sample01);
        ArrayUtils.printIntList(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();

        int row = matrix.length;
        int column = matrix[0].length;

        int edgeTopRow = 0;
        int edgeLeftColumn = 0;
        int edgeRightColumn = column - 1;
        int edgeBottomRow = row - 1;

        int direction = 0;

        // Traverse the matrix with spiral way
        //  Right -> Down -> Left -> Up
        while (edgeLeftColumn <= edgeRightColumn && edgeTopRow <= edgeBottomRow) {
            // Find direction
            switch (direction) {
                case 0 -> {
                    // Keep moving right
                    for (int i = edgeLeftColumn; i <= edgeRightColumn; i++) {
                        resultList.add(matrix[edgeTopRow][i]);
                    }

                    // End with the edge, update edge to next row (move down)
                    // narrower the boundary
                    edgeTopRow++;
                }
                case 1 -> {
                    // Keep moving down
                    for (int i = edgeTopRow; i <= edgeBottomRow; i++) {
                        resultList.add(matrix[i][edgeRightColumn]);
                    }

                    // End with the edge, update edge to previous column (move left)
                    // narrower the boundary
                    edgeRightColumn--;
                }
                case 2 -> {
                    // Keep moving left
                    for (int i = edgeRightColumn; i >= edgeLeftColumn ; i--) {
                        resultList.add(matrix[edgeBottomRow][i]);
                    }

                    // End with the edge, update edge to previous row (move up)
                    // narrower the boundary
                    edgeBottomRow--;
                }
                case 3 -> {
                    // Keep moving up
                    for (int i = edgeBottomRow; i >= edgeTopRow ; i--) {
                        resultList.add(matrix[i][edgeLeftColumn]);
                    }

                    // End with the edge, update edge to next column (move right)
                    // narrower the boundary
                    edgeLeftColumn++;
                }
            }

            // update direction
            direction = (direction + 1) % 4;
        }

        return resultList;
    }
}
