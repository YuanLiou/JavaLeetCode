public class SearchTwoDMatrix {

	public static void main(String[] args) {

		var sampleClass = new SearchTwoDMatrix();

		// Expected: true
		int[][] matrix01 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		var result = sampleClass.searchMatrix(matrix01, 5);
		System.out.println(result);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
}
