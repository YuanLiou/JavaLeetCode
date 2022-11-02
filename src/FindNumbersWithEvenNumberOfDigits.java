public class FindNumbersWithEvenNumberOfDigits {
	public static void main(String[] args) {
		var sampleClass = new FindNumbersWithEvenNumberOfDigits();
		// expect = 2
		var sample01 = new int[]{12, 345, 2 ,6, 7896};
		// expect = 1
		var sample02 = new int[]{555, 901, 482, 1771};
		int result = sampleClass.findNumbers(sample02);
		System.out.println(result);
	}

	// solution: brute force
	public int findNumbers(int[] nums) {
		int result = 0;
		for (int number : nums) {
			int digit = calculateNumsOfDigit(number);
			if (digit % 2 == 0) {
				result++;
			}
		}
		return result;
	}

	private int calculateNumsOfDigit(int number) {
		int current = number;
		int counts = 0;
		while (current > 0) {
			current = current / 10;
			counts++;
		}
		return counts;
	}
}
