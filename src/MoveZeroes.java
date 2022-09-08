import utils.ArrayUtils;

public class MoveZeroes {
	public static void main(String[] args) {

		var sample01 = new int[]{0, 1, 0, 3, 12};
		var sample02 = new int[]{2, 1};

		var sampleClass = new MoveZeroes();
		sampleClass.moveZeroes(sample02);

		ArrayUtils.printArray(sample02);
	}

	public void moveZeroes(int[] nums) {
		int ci = 0;
		int index = 1;
		while (index < nums.length) {
			if (nums[index] != 0) {
				int zeroAtIndex = ci;
				while (nums[zeroAtIndex] != 0 && zeroAtIndex < index) {
					zeroAtIndex++;
				}

				if (nums[zeroAtIndex] == 0) {
					swap(nums, index, zeroAtIndex);
					ci = zeroAtIndex;
				}
			}
			index++;
		}
    }

	private void swap(int[] nums, int indexA, int indexB) {
		int temp = nums[indexA];
		nums[indexA] = nums[indexB];
		nums[indexB] = temp;
	}
}
