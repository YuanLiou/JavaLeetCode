import utils.ArrayUtils;

public class DiagonalTraverse {
    public static void main(String[] args) {
        var sample01 = new int[][]{ { 1, 2, 3 }, {4, 5, 6}, {7, 8, 9} };
        var sample02 = new int[][]{ { 1, 2 }, {3, 4} };

        var result = findDiagonalOrder(sample01);
        ArrayUtils.printArray(result);
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        // Base case
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }

        // Base case, if only has one row
        if (mat.length == 1) {
            return mat[0];
        }

        int row = mat.length;
        int column = mat[0].length;
        int[] returnArray = new int[row * column];

        // traverse the matrix
        int index = 0;
        int currentRow = 0;
        int currentColumn = 0;
        while (index < returnArray.length) {
            returnArray[index] = mat[currentRow][currentColumn];
            // Find direction of maxtrix
            if ((currentRow + currentColumn) % 2 == 0) {
                // Move up

                // is current calculation in the edge?
                //  先檢查 currentColumn == column - 1，是為了防止溢位
                //  例如一個 3 * 3 矩陣，目前位置在 0, 2，計算下一個位置時
                //  會因為 currentRow == 0 先檢查，導致 currentColumn + 1 變成 3，
                //  最後溢位 Crash。
                if (currentColumn == column - 1) {
                    // move to bottom
                    currentRow++;
                } else if (currentRow == 0) {
                    // move to right
                    currentColumn++;
                } else {
                    // Somewhere in the middle, keep moving top-right direction
                    currentRow--;
                    currentColumn++;
                }
            } else {
                // Move down

                // is current calculation in the edge?
                //  先檢查 currentRow == row - 1，是為了防止溢位 (如果計算的方向與題目相反)
                //  例如一個 3 * 3 矩陣，目前位置在 2, 0，計算下一個位置時
                //  會因為 currentColumn == 0 先檢查，導致 currentRow + 1 變成 3，
                //  最後溢位 Crash。
                if (currentRow == row - 1) {
                    // move to right
                    currentColumn++;
                } else if (currentColumn == 0) {
                    // move to bottom
                    currentRow++;
                } else {
                    // Somewhere in the middle, keep moving bottom-left direction
                    currentRow++;
                    currentColumn--;
                }
            }

            index++;
        }
        return returnArray;
    }
}
