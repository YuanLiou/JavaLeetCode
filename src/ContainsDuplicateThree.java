public class ContainsDuplicateThree {
	public static void main(String[] args) {
	}

	// Brute Force
	public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		int currentIndex = 0;
		while (currentIndex < nums.length) {
			int exploreIndex = currentIndex + 1;

			while (exploreIndex < nums.length && Math.abs(currentIndex - exploreIndex) <= indexDiff) {
				if (Math.abs(nums[currentIndex] - nums[exploreIndex]) <= valueDiff) {
					return true;
				}
				exploreIndex++;
			}

			currentIndex++;
		}
		return false;
	}
}
