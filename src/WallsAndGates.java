import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
	private static final int OBSTABLE = -1;
	private static final int GATE = 0;
	private static final int EMPTY = 2147483647;
	private static final int[][] DIRECTIONS = new int[][] {
		{-1, 0},
		{0, 1},
		{1, 0},
		{0, -1},
	};

	public void wallsAndGates(int[][] rooms) {
		// 1. put all index of gates into a Queue
		// r x c
		Queue<int[]> positions = new LinkedList<int[]>();
		int row = rooms.length;
		int column = rooms[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (rooms[i][j] == GATE) {
					positions.offer(new int[] {i, j});
				}
			}
		}

		// 2. start BFS of each point
		while(!positions.isEmpty()) {
			int[] lastPostition = positions.poll();
			int lastRow = lastPostition[0];
			int lastColumn = lastPostition[1];

			// walk to four directions
			for (int[] direction : DIRECTIONS) {
				// check whether it exceed the limit or it is not an empty position
				int nextRow = lastRow + direction[0];
				int nextColumn = lastColumn + direction[1];
				if (nextColumn < 0 || nextRow < 0 ||
					nextColumn >= column || nextRow >= row ||
					rooms[nextRow][nextColumn] != EMPTY
				) {
					continue;
				}

				// walk a step from previous position
				rooms[nextRow][nextColumn] = rooms[lastRow][lastColumn] + 1;

				// put this position into our queue
				positions.offer(new int[] {nextRow, nextColumn});
			}
		}
	}
}
