public class MaxConsecutiveOnesThree {
	public static void main(String[] args) {
	}

	/*
	Input:                          10 ->
				0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8  19
		nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
		k = 3
	 */
	// lp = 10
	// rp = 18
	// cu = 3   > 3 ?
	// an = 10    ->
	public int longestOnes(int[] nums, int k) {
		int leftPointer = 0;
		int answer = 0;
		int currentZeroCount = 0;
		for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
			if (nums[rightPointer] == 0) {
				currentZeroCount++;
			}

			// if current zero counts exceed our constraint
			if (currentZeroCount > k) {
				// shrink the left bounds.
				if (nums[leftPointer] == 0) {
					// find zero, reduce one count.
					currentZeroCount--;
				}
				leftPointer++; // moving right
			}

			answer = Math.max(answer, rightPointer - leftPointer + 1);
		}
		return answer;
	}
}
