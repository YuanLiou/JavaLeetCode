public class MaximalSquare {
	public static void main(String[] args) {
		var sampleClass = new MaximalSquare();
		// expected: 4
//		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//		var result = sampleClass.maximalSquare(matrix);
//		System.out.println("Result is " + result);
		// expected: 1
//		char[][] matrix02 = {{'0','1'},{'1','0'}};
//		var result02 = sampleClass.maximalSquare(matrix02);
//		System.out.println("Result02 is " + result02);
		// expected: 4
		char[][] matrix03 = {{'1','1','0','1'},{'1','1','0','1'},{'1','1','1','1'}};
		var result03 = sampleClass.maximalSquare(matrix03);
		System.out.println("Result03 is " + result03);
	}

	public int maximalSquare(char[][] matrix) {
		int columns = matrix[0].length;
		int rows = matrix.length;
		Integer[][] cached = new Integer[rows][columns];
		int maxLength = 0;
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = columns - 1; j >= 0; j--) {
				int itself = checkValue(i, j, matrix, cached);
				int right = checkValue(i, j + 1, matrix, cached);
				int bottom = checkValue(i + 1, j, matrix, cached);
				int diagonal = checkValue(i + 1, j + 1, matrix, cached);

				int squareLength = 0;
				if (itself != 0) {
					squareLength = itself + Math.min(right, Math.min(bottom, diagonal));
				}

				// update cache
				if (cached[i][j] == null) {
					cached[i][j] = squareLength;
				}

				if (squareLength > maxLength) {
					maxLength = squareLength;
				}
			}
		}

		return maxLength * maxLength;
	}

	private int checkValue(int row, int column, char[][] matrix, Integer[][] cached) {
		if (column > matrix[0].length - 1 || row > matrix.length - 1 ||
				column < 0 || row < 0) {
			return 0;
		}

		if (cached[row][column] != null) {
			return cached[row][column];
		}
		return Integer.parseInt(String.valueOf(matrix[row][column]));
	}
}
