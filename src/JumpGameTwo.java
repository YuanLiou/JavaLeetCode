public class JumpGameTwo {

	public static void main(String[] args) {
	}

	public int jump(int[] nums) {
		if (nums.length == 1) {
			return 1;
		}

		int left = 0;
		int right = 0;
		int sectionCounts = 0;
		while (right < nums.length - 1) {
			// start BFS, left..right
			int farestPosition = 0;
			for (int i = left; i <= right; i++) {
				// i + 的原因，因為是 position
				farestPosition = Math.max(farestPosition, (i + nums[i]));
			}

			// moving current window to the next BFS layer.
			left = right + 1;
			right = farestPosition;
			sectionCounts++;
		}

		return sectionCounts;
	}
}
