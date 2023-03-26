import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RottingOranges {
	private int[][] directions = new int[][] {
		{-1, 0},
		{1, 0},
		{0, -1},
		{0, 1}
	};

	private record Coordinate(int row, int column) {}
	public int orangesRotting(int[][] grid) {
		int step = -1;
		int normalOrangeCounts = 0;
		// calculate all normal orange
		// add all rotting orange to the queue
		ArrayDeque<Coordinate> queue = new ArrayDeque<>();
		int row = grid.length;
		int column = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				var current = grid[i][j];
				if (current == 2) {
					queue.offer(new Coordinate(i, j));
				} else if (current == 1){
					normalOrangeCounts++;
				}
			}
		}

		// add a special anchor
		// which means we're done for this turn.
		queue.offer(new Coordinate(-1, -1));

		// make other orange rotting durning BFS calculation
		while (!queue.isEmpty()) {
			var current = queue.poll();
			if (current.row == -1) {
				// it's our special anchor
				step++;

				// if queue is not empty, we should add another anchor to make it stop.
				if (!queue.isEmpty()) {
					queue.offer(new Coordinate(-1, -1));
				}
			} else {
				// rotting other orange
				for (Coordinate neighbors : getNeighbors(current, grid)) {
					var neighbor = grid[neighbors.row][neighbors.column];
					if (neighbor == 1) {
						grid[neighbors.row][neighbors.column] = 2;
						normalOrangeCounts--;
						queue.offer(neighbors);
					}
				}
			}
		}

		return normalOrangeCounts == 0 ? step : -1;
	}

	private List<Coordinate> getNeighbors(Coordinate currentLocation, int[][] grid) {
		List<Coordinate> result = new ArrayList<>();
		for (int[] direction : directions) {
			var x = currentLocation.row + direction[0];
			var y = currentLocation.column + direction[1];
			if ((x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length)) {
				result.add(new Coordinate(x, y));
			}
		}
		return result;
	}
}
