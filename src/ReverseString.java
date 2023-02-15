import utils.ArrayUtils;

public class ReverseString {
	public static void main(String[] args) {
		// expected: o, l, l, e, h
		var sample01 = new char[]{'h', 'e', 'l', 'l', 'o'};
		// expected: h, a, n, n, a, H
		var sample02 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

		reverseStringRecursive(sample02);
		ArrayUtils.printCharArray(sample02);
	}

	public static void reverseStringRecursive(char[] s) {
		doReverseString(s, 0, s.length - 1);
	}

	private static void doReverseString(char[] characters, int leftBound, int rightBound) {
		// base case
		if (rightBound <= leftBound) {
			return;
		}

		swap02(characters, leftBound, rightBound);
		doReverseString(characters,leftBound + 1, rightBound - 1);
	}

	public static void reverseString(char[] s) {
		// base case
		if (s == null || s.length == 0) {
			return;
		}

		// two-pointer
		int leftBound = 0;
		int rightBound = s.length - 1;
		while (leftBound < rightBound) {

			swap(s, leftBound, rightBound);

			leftBound++;
			rightBound--;
		}
	}

	// swap function recap
	private static void swap02(char[] source, int indexA, int indexB) {
		char temp = source[indexA];
		source[indexA] = source[indexB];
		source[indexB] = temp;
	}

	// swap function
	private static void swap(char[] source, int indexA, int indexB) {
		char ogCharA = source[indexA];
		source[indexA] = source[indexB];
		source[indexB] = ogCharA;
	}
}
