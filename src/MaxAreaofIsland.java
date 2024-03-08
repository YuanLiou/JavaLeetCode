public class MaxAreaofIsland {

	public static void main(String[] args) {
		var sampleClass = new MaxAreaofIsland();
		int[][] sampleInput001 = {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		var result01 = sampleClass.maxAreaOfIsland(sampleInput001);
		System.out.println("Result 01 is " + result01);
	}

	private int total = 0;
	private int previous = 0;
	public int maxAreaOfIsland(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1)  {
					traverse(grid, i, j);
					previous = Math.max(previous, total);
					total = 0;
				}
			}
		}
		return previous;
	}

	private void traverse(int[][] grid,
	                      int x,
	                      int y) {
		if (x >= grid.length || x < 0 || y >= grid[x].length || y < 0) {
			return;
		}

		if (grid[x][y] == 0) {
			return;
		}
		grid[x][y] = 0;
		total++;

		traverse(grid, x + 1, y);
		traverse(grid, x - 1, y);
		traverse(grid, x, y + 1);
		traverse(grid, x, y - 1);
	}
}
