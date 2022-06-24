import utils.ArrayUtils;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] sample01 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] sample02 = {1};
        int[] sample03 = {5, 4, -1, 7, 8};
        int result = kadaneAlgorithm(sample03);
        System.out.println("Result is " + result);
    }

    public static int kadaneAlgorithm(int[] nums) {
        // Time complexity: O(n), Space complexity: O(1)
        // 判斷目前這個點，要不要加到目前的總合中？或是另開一個 Array 重新整理整合重新開始
        //  currentSum = Math.max(currentSum + A[i], A[i])
        // 接著再判斷這個 currentSum 是出現過的最大的 currentSum 嗎？
        //  maxSum = Math.max(maxSum, currentSum)

        // edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int maximumSum = nums[0]; // 可能會漏掉，第一個就是最大值的狀況
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 判斷目前這個點，要不要加到目前的總合中？或是另開一個 Array 重新整理整合重新開始
            //  換句話說，開了一個 Array，所以現在 currentSum 被重置了。
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            // 接著再判斷這個 currentSum 是出現過的最大的 currentSum 嗎？
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }

    // Brute force solution: O(n^2)
    // This will exceed Memory Limit ;(
    public static int maxSubArrayOld(int[] nums) {
        // 一樣先表格化 memo[nums.length()][nums.length()]
        // 確定的值：
        // 1. (0, 0) (1, 1) (2, 2) 等值，都是自己
        // 2. 拿 上一次累加起來的 memo 再加上自己的值。
        // 例如要找第 memo[3][5] = memo[3][4] 再加上 A[5] 即可
        // 用一個 maximum 來存最大值。 maximumValue = Math.max(maximumValue, memo[3][5])

        // edge case: 空的 or 一個
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int maximumValue = Integer.MIN_VALUE;
        int[][] memo = new int[nums.length][nums.length];
        for (int endPoint = 0; endPoint < nums.length; endPoint++) {
            for (int startPoint = 0; startPoint <= endPoint; startPoint++) {
                if (startPoint == endPoint) {
                    // 1. (0, 0) (1, 1) (2, 2) 等值，都是自己
                    memo[startPoint][endPoint] = nums[startPoint];
                } else {
                    // 2. 拿 上一次累加起來的 memo 再加上自己的值。
                    memo[startPoint][endPoint] = memo[startPoint][endPoint - 1] + nums[endPoint];
                }
                maximumValue = Math.max(maximumValue, memo[startPoint][endPoint]);
            }
        }
        return maximumValue;
    }
}
