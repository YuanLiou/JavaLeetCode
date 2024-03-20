public class ValidSquare {
	public static void main(String[] args) {
		var sampleClass = new ValidSquare();
		int[] p1 = {0, 0};
		int[] p2 = {1, 1};
		int[] p3 = {1, 0};
		int[] p4 = {0, 1};
		var result01 = sampleClass.validSquare(p1, p2, p3, p4);
		System.out.println("Result 01 is " + result01);
	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		// a square will have four edges in same length.
		// Also, two diagonal in same length.
		long[] edgeLengthes = new long[] {
			calculateLength(p1, p2),
			calculateLength(p2, p3),
			calculateLength(p3, p4),
			calculateLength(p1, p3),
			calculateLength(p1, p4),
			calculateLength(p2, p4),
		};

		long diagonalLength = 0;
		long edgeLength = Integer.MAX_VALUE;

		for (long length : edgeLengthes) {
			diagonalLength = Math.max(diagonalLength, length);
			edgeLength = Math.min(edgeLength, length);
		}

		int diagonalCounts = 0;
		int edgeCounts = 0;
		for (long length : edgeLengthes) {
			if (diagonalLength == length) {
				diagonalCounts++;
			}

			if (edgeLength == length) {
				edgeCounts++;
			}
		}

		if (diagonalCounts != 2) {
			return false;
		}
		return edgeCounts == 4;
	}

	private long calculateLength(int[] p1, int[] p2) {
		// Sqrt(Pow(p1[0] - p2[0], 2) + Pow(p1[1] - p2[1], 2))
		// But we only care about whether they're the same length.
		// If the length is the same, so as the value before performing Sqrt.
		// According to above, we don't need to calculate the actual length here.
		return (long) Math.pow(p1[0] - p2[0], 2) + (long) Math.pow(p1[1] - p2[1], 2);
	}
}
