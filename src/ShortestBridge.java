import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
	public static void main(String[] args) {
		// expected: 2
		var sampleClass01 = new ShortestBridge();
		int[][] grid01 = {{0,1,0},{0,0,0},{0,0,1}};
		var result01 = sampleClass01.shortestBridge(grid01);
		System.out.println("Result 01 is " + result01);
		// expected: 1, init a new class to prevent state issue
		var sampleClass02 = new ShortestBridge();
		int[][] grid02 = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
		var result02 = sampleClass02.shortestBridge(grid02);
		System.out.println("Result 02 is " + result02);
	}
	private record Coordinate(int row, int column) {}
	private boolean[][] visited;
	private final Queue<Coordinate> queue = new LinkedList<>();
	private final int[][] directions = new int[][]{
		{1, 0},
		{-1, 0},
		{0, 1},
		{0, -1},
	};

	public int shortestBridge(int[][] grid) {
		visited = new boolean[grid.length][grid.length];

		// 1.) find one of the island using DFS
		firstLoop:
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				// 找到島
				if (grid[r][c] == 1) {
					dfs(grid, r, c); // 把島包圍起來
					break firstLoop;
				}
			}
		}

		// 2.) use BFS to find the shortest path between two islands.
		return bfs(grid);
	}

	private boolean isInvalid(
		int[][] grid,
		int row,
		int column
	) {
		return row < 0 || column < 0 || row >= grid.length || column >= grid[row].length;
	}

	// 只為了圈出陸地
	private void dfs(
		int[][] grid,
		int row,
		int column
	) {
		// 越界了
		if (isInvalid(grid, row, column)) {
			return;
		}

		// 來過了
		if (visited[row][column]) {
			return;
		}

		// 不在乎是海
		if (grid[row][column] == 0) {
			return;
		}

		// 是島
		if (grid[row][column] == 1) {
			visited[row][column] = true;
			queue.offer(new Coordinate(row, column));
		}

		for (int[] direction : directions) {
			dfs(
				grid,
				row + direction[0],
				column + direction[1]
			);
		}
	}

	// Traverse the maze layer by layer
	private int bfs(
		int[][] grid
	) {
		int result = 0;
		while (!queue.isEmpty()) {
			// bfs 要逛完他的所有目前節點
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Coordinate current = queue.poll();
				if (current == null) {
					continue;
				}

				// 逛目前這個節點的四周
				for (int[] direction : directions) {
					int currentRow = current.row + direction[0];
					int currentColumn = current.column + direction[1];
					if (isInvalid(grid, currentRow, currentColumn)) {
						continue;
					}

					// 逛過了
					if (visited[currentRow][currentColumn]) {
						continue;
					}
					visited[currentRow][currentColumn] = true;

					// 是陸地。題目說只會有兩個陸地，這是另外一個陸地
					if (grid[currentRow][currentColumn] == 1) {
						return result;
					}

					queue.offer(new Coordinate(currentRow, currentColumn));
				}
			}
			// 逛完一層 => layer + 1 即為步數 + 1
			result++;
		}
		return -1;
	}
}
