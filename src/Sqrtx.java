public class Sqrtx {
	public static void main(String[] args) {
		// input 0 and 1
	}

	public int mySqrt(int x) {
		int leftBound = 0;
		int rightBound = x;
		int candidate = leftBound;
		while (leftBound <= rightBound) {
			int middle = leftBound + (rightBound - leftBound) / 2;
			long square = (long) middle * middle;
			if (square == x) {
				return middle;
			} else if (square < x) {
				candidate = middle;
				leftBound = middle + 1;
			} else {
				rightBound = middle - 1;
			}
		}
		return candidate;
	}
}
