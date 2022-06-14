import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] testArray = new int[]{ 7, 2, 5, 10, 8 };
        var result = splitArrayV1(testArray, 2);
        System.out.println("Result is " + result);
    }

    // Try all ways of partitioning the input array into m blocks.
    // While doing so, keep track of the minimum of the largest sums among all blocks.
    // More concretely, answer is:
    //  `min(current partition sum, maximim partition sum for subarray to the right of the current partition)`
    public static int splitArrayV1(int[] nums, int m) {
        int[][] memo = new int[nums.length][m + 1];

        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        int result = walk(nums, memo, 0, m);
        return result;
    }

    private static int walk(int[] nums, int[][] memo, int start, int rem) {
        // base case
        if (rem == 0 && start == nums.length) {
            return 0;
        }

        if (rem == 0 || start == nums.length) {
            // if we reach the end and have not used up all partitions
            // or have used up all partitions and have not reached the end,
            // we do not want to count the current way of partitioning.
            // return MAX_VALUE so that we don't contribute to the return value.
            return Integer.MAX_VALUE;
        }

        int n = nums.length;
        int ret = Integer.MAX_VALUE;
        int currentSum = 0;

        // try all positions to end the current partition.
        for (int i = start; i < n; i++) {
            currentSum += nums[i];

            // answer for partitioning the subarray to the right of the current partition,
            // with one less partition number allowance, because we already used one
            // for the current partition. i.e. (rem - 1)
            int futureSum = walk(nums, memo, i + 1, rem - 1);

            // we want to minimum of the largest sum of the partitions.
            System.out.println("Math.max(curSum= " + currentSum + ", fuSum= " + futureSum + ")");
            ret = Math.min(ret, Math.max(currentSum, futureSum));
        }

        System.out.println("start is " + start + ", rem is " + rem + ", ret is " + ret);
        memo[start][rem] = ret;
        return ret;
    }
}
