import java.util.LinkedList;
import java.util.Queue;

public class TargetSum {
    private static int counts = 0;

    public static void main(String[] args) {
        var sample01 = new int[]{1, 1, 1, 1, 1};
        var target = 3;
        // Expected = 5
        var output = findTargetSumWays(sample01, target);
        System.out.println("Result is " + output);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        countsToTargetSum(nums, 0, 0, target);
        return counts;
    }

    private static void countsToTargetSum(
        int[] nums,
        int currentIndex,
        int sum,
        int target
    ) {
        // base case
        if (currentIndex == nums.length) {
            if (sum == target) {
                counts++;
            }
        } else {
            // Find each X + Y
            countsToTargetSum(nums, currentIndex + 1, sum + nums[currentIndex], target);
            // Find each X - Y
            countsToTargetSum(nums, currentIndex + 1, sum - nums[currentIndex], target);
        }
    }
}
