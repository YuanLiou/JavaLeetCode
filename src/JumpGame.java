public class JumpGame {
	public static void main(String[] args) {
		var sampleClass = new JumpGame();
		// expected: true
		var sample01 = new int[]{1, 4, 0, 1};
		var result01 = sampleClass.canJump(sample01);
		System.out.println("Result is " + result01);

		// expected: false
		var sample02 = new int[]{1, 2, 0, 0, 4};
		var result02 = sampleClass.canJump(sample02);
		System.out.println("Result is " + result02);
	}

	public boolean canJump(int[] nums) {
		// sample: [2,3,1,1,4]
		if (nums == null || nums.length == 0) {
			return false;
		}

		int lastAchieveableIndex = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			int current = nums[i];
			if (current + i >= lastAchieveableIndex) {
				lastAchieveableIndex = i;
			}
		}
		return lastAchieveableIndex == 0;
	}
}
