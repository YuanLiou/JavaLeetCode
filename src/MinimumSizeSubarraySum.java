public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        // expected: 2
        var sample01 = new int[]{2, 3, 1, 2, 4, 3};
        var target01 = 7;
        // expected: 1
        var sample02 = new int[]{1, 4, 4};
        var target02 = 4;
        // expected: 0
        var sample03 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        var target03 = 11;
        // expected: 3
        var sample04 = new int[]{1, 2, 3, 4, 5};
        var target04 = 11;
        // expected: 2
        var sample05 = new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        var target05 = 15;
        var result = minSubArrayLen(target05, sample05);
        System.out.println("Result is " + result);
    }

    // Brute Force
    public static int minSubArrayLen(int target, int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int totalSize = nums.length;
        int startPoint = 0;
        int j = 0;

        int minSize = nums.length + 1;
        int sum = 0;
        while (startPoint < totalSize && j < totalSize) {
            sum += nums[j];

            while (sum >= target) {
                minSize = Math.min(minSize, j - startPoint + 1);

                // Shrink the left boundary to check if there is a tiny subarray
                // meets our requirement. Check if we remove the very first item
                // in the sub array, would it fit requirement? or break the inner while loop.
                sum = sum - nums[startPoint];
                startPoint++; // Keep move left to break the loop
            }

            j++;
        }

        if (minSize == nums.length + 1) {
            return 0;
        }
        return minSize;
    }

    public static int minSubArrayLenFailed(int target, int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int number : nums) {
            sum += number;
        }

        if (target > sum) {
            return 0;
        }

        int left = 0;
        int minSize = 10001; // max size of num[i]
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            left = left + nums[currentIndex];
            int right = sum - left;

            if (left >= target) {
                minSize = Math.min(minSize, currentIndex + 1);
            }

            if (right >= target) {
                minSize = Math.min(minSize, (nums.length - (currentIndex + 1)));
            }
        }

        if (minSize == 10001) {
            return 0;
        }
        return minSize;
    }
}
