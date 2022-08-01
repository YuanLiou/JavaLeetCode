public class NumberOfIslands {

    private static final char[][] SAMPLE_00 = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };

    private static final char[][] SAMPLE_01 = {
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
    };
    
    public static void main(String[] args) {
        int result = numIslands02(SAMPLE_00);
        System.out.println("Result is " + result);
    }

    //region Second Try
    public static int numIslands02(char[][] grid) {
        int islandCounts = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char currentChar = grid[i][j];
                if (currentChar == '1') {
                    traverse(grid, i, j); // Flip the nearby '1'
                    islandCounts++;
                }
            }
        }
        return islandCounts;
    }

    private static void traverse(char[][] grid, int i, int j) {
        // base case
        if ((i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)) {
            return;
        }

        char currentChar = grid[i][j];
        if (currentChar == '0') {
            return;
        }

        // flip the result
        if (currentChar == '1') {
            grid[i][j] = '0';
        }

        // start traverse
        traverse(grid, i - 1, j); // find top
        traverse(grid, i + 1, j); // find bottom
        traverse(grid, i, j - 1); // find left
        traverse(grid, i, j + 1); // find left
    }
    //endregion

    public static int numIslands(char[][] grid) {
        // 先處理極值 grid is null or 根本沒長度
        // 圖形問題免不俗需要走過全部的個子，需要兩個 for 迴圈
        // 我們對 0 完全沒興趣
        // 透過 dfs 來走格子，並且將自己這格設為 0 避免重複走過
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // ignore any 0, not interested.
                if (grid[i][j] == '1') {
                    // calculation, 可能是個 Recursion，因為是 dsf 要遍歷
                    numberOfIslands += dsf(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    private static int dsf(char[][] grid, int i, int j) {
        // i, j 是座標
        // 先處理極值，及 **base case** (stop condition)
        //   走到底，就停。或者是碰到 0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        // 先把選到的設為 0，以免重複計算
        grid[i][j] = '0';

        // 走他的上下左右
        // 題目：connecting adjacent lands horizontally or vertically.
        dsf(grid, i + 1, j); // move down
        dsf(grid, i - 1, j); // move up
        dsf(grid, i, j + 1); // move right
        dsf(grid, i, j - 1); // move left
        
        return 1;
    }

}
