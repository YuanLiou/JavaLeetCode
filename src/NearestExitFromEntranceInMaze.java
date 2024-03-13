import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
	public static void main(String[] args) {
		var sampleClass = new NearestExitFromEntranceInMaze();
		char[][] maze001 = {
				{'+', '+', '.', '+'},
				{'.', '.', '.', '+'},
				{'+', '+', '+', '.'}
		};
		int[] entrance001 = {1, 2};

		// expected: 1
		var answer001 = sampleClass.nearestExit(maze001, entrance001);
		System.out.println("Answer 001 is " + answer001);

		char[][] maze002 = {
				{'+', '+', '+'},
				{'.', '.', '.'},
				{'+', '+', '+'}
		};
		int[] entrance002 = {1, 0};

		// expected: 2
		var answer002 = sampleClass.nearestExit(maze002, entrance002);
		System.out.println("Answer 002 is " + answer002);
	}

	public int nearestExit(char[][] maze, int[] entrance) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[maze.length][maze[0].length];

		queue.offer(entrance);

		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				var current = queue.poll();
				if (current == null) {
					continue;
				}

				var row = current[0];
				var col = current[1];
				if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) {
					// we're reach the edge
					if (step != 1) {
						return step - 1;
					}  else {
						continue;
					}
				}

				if (maze[row][col] == '+') {
					continue;
				}

				if (visited[row][col]) {
					continue;
				}
				visited[row][col] = true;

				queue.offer(new int[]{row + 1, col});
				queue.offer(new int[]{row - 1, col});
				queue.offer(new int[]{row, col + 1});
				queue.offer(new int[]{row, col - 1});
			}

			step++;
		}
		return -1;
	}
}
