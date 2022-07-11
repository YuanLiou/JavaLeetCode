public class LargestNumberAtLeastTwiceOthers {
    public static void main(String[] args) {
        // [0,0,0,1] ==> 3
        var sample01 = new int[] {3, 6, 1, 0};
        var sample02 = new int[] {1, 2, 3, 4};
        var sample03 = new int[] {0, 0, 0, 1};
        var result = dominantIndex(sample01);
        System.out.println("Result is " + result);
    }

    public static int dominantIndex(int[] nums) {
        // 先找出最大的數字，再看看他是不是真的比其他人大兩倍
        int maxPosition = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxPosition = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // skip itself
            if (i == maxPosition) {
                continue;
            }

            int currentValue = nums[i];
            if (currentValue * 2 > maxValue) {
                return -1;
            }
        }
        return maxPosition;
    }
}
