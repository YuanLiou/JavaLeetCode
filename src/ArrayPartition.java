import java.util.Arrays;

public class ArrayPartition {
    public static void main(String[] args) {
        var sample01 = new int[]{1, 4, 3, 2};
        var sample02 = new int[]{6, 2, 6, 5, 1, 2};
        var result = arrayPairSum(sample02);
        System.out.println("Result sum is: " + result);
    }

    public static int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
