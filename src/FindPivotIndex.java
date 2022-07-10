public class FindPivotIndex {
    public static void main(String[] args) {
        //[-1,-1,-1,-1,-1,-1]  == -1
        //[-1,-1,0,1,1,0]  == 5
        //[1,7,3,6,5,6] == 3
        var sample01 = new int[]{1, 7, 3, 6, 5, 6};
        var sample02 = new int[]{1, 2, 3};
        var sample03 = new int[]{2, 1, -1};
        var sample04 = new int[]{-1,-1,-1,-1,-1,-1};
        var sample05 = new int[]{-1, -1, 0, 1, 1, 0};
        int result = pivotIndex(sample05);
        System.out.println("Result is " + result);
    }

    public static int pivotIndex(int[] nums) {
        return prefixSum(nums);
    }

    private static int prefixSum(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // calculate sum
        int sumOfNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOfNums += nums[i];
        }

        // Who is the leftSum?
        //  1. leftSum == SUM(0..<index), we can get it through a loop
        //  2. Right Sum == sum - (leftSum + A[index])
        //    2-a they're the same then return
        //    2-b otherwise, leftSum += A[index]
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = sumOfNums - (leftSum + nums[i]);
            if (leftSum == rightSum) {
                return i;
            }

            // otherwise, continue to calculate the leftSum
            leftSum += nums[i];
        }
        return -1;
    }

    private static int bruteForce(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int index = 0; index < nums.length; index++) {
            // Find the sum of the left and the sum of the right
            int leftSum = 0;
            int leftIndex = 0;
            while (leftIndex < index) {
                leftSum += nums[leftIndex];
                leftIndex++;
            }

            int rightSum = 0;
            int rightIndex = index + 1;
            while (rightIndex < nums.length) {
                rightSum += nums[rightIndex];
                rightIndex++;
            }

            if (rightSum == leftSum) {
                return index;
            }
        }
        return -1;
    }
}
