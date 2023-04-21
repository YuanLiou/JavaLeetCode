import java.util.HashMap;

public class NQueensTwo {
	public static void main(String[] args) {
		var sampleClass = new NQueensTwo();
		var result = sampleClass.totalNQueens(4);
		System.out.println("Result is " + result);
	}

	int result = 0;
	public int totalNQueens(int n) {
		var columns = new HashMap<Integer, Boolean>();
		var positiveDiagonal = new HashMap<Integer, Boolean>();
		var negativeDiagonal = new HashMap<Integer, Boolean>();

		backtracking(0, n, columns, positiveDiagonal, negativeDiagonal);
		return result;
	}

	private void backtracking(
			int row,
			int n,
			HashMap<Integer, Boolean> columns,
			HashMap<Integer, Boolean> positiveDiagonal,
			HashMap<Integer, Boolean> negativeDiagonal) {
		
		// base case
		if (row == n) {
			result++;
			return;
		}

		// time complexity: n ^ n, 本來用圖看以為是 n!
		for (int column = 0 ; column < n; column++) {
			// 用原來條件反轉過來，本來是 columns, positiveDiagonal, negativeDiagonal
			// 都「必須」不包含才能繼續往下做。
			if (columns.getOrDefault(column,false) ||
					positiveDiagonal.getOrDefault(row + column, false) ||
					negativeDiagonal.getOrDefault(row - column, false)
			) {
				continue;
			}

			// backtracking
			columns.put(column, true);
			positiveDiagonal.put(row + column, true);
			negativeDiagonal.put(row - column, true);
			backtracking(row + 1, n, columns, positiveDiagonal, negativeDiagonal);
			columns.put(column, false);
			positiveDiagonal.put(row + column, false);
			negativeDiagonal.put(row - column, false);
		}
	}
}
