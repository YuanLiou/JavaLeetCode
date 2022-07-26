import utils.ArrayUtils;

public class RotateArray {
    public static void main(String[] args) {
        int[] sample01 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k01 = 3;
        int[] sample02 = new int[]{-1, -100, 3, 99};
        int k02 = 2;
        int[] sample03 = new int[]{-1};
        int k03 = 2;

        rotate(sample03, k03);
        ArrayUtils.printArray(sample03);
    }

    public static void rotate(int[] nums, int k) {
        // base case
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        
        int numSize = nums.length;

        /*
         * e.g. [1, 2, 3], k = 5
         *
         * [1, 2, 3]
         * [3, 1, 2] k = 1
         * [2, 3, 1] k = 2
         * [1, 2, 3] k = 3
         * [3, 1, 2] k = 4
         * [2, 3, 1] k = 5
         *
         * You'll find k = 5 is equals to k = 2. We didn't need to count 5 times.
         * We only need to count twice. How can we get that? Just use the mod operator.
         * k % nums.length --> 5 % 3 --> 2.   (5 / 3 == 1.XXX)
         */
        k = k % numSize;  // To prevent duplicated counting
        reverseElements(nums, 0, numSize - 1);
        reverseElements(nums, 0, k - 1);
        reverseElements(nums, k, numSize - 1);
    }

    private static void reverseElements(int[] nums, int startPosition, int endPosition) {
        while (startPosition < endPosition) {
            swap(nums, startPosition, endPosition);
            startPosition++;
            endPosition--;
        }
    }

    private static void swap(int[] nums, int leftBound, int rightBound) {
        int temp = nums[leftBound];
        nums[leftBound] = nums[rightBound];
        nums[rightBound] = temp;
    }
}
