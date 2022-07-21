import utils.ArrayUtils;

public class TwoSumTwo {

    public static void main(String[] args) {
        var sample01 = new int[]{2, 7, 11, 15};
        var target01 = 9;

        var sample02 = new int[]{2, 3, 4};
        var target02 = 6;

        var sample03 = new int[]{-1, 0};
        var target03 = -1;

        var result = twoSum(sample01, target01);
        ArrayUtils.printArray(result);
    }

    public static int[] twoSum(int[] numbers, int target) {
        // base case
        if (numbers == null) {
            return new int[]{};
        }

        // Doing Two Pointer Technique
        int leftBound = 0;
        int rightBound = numbers.length - 1;
        while (leftBound < rightBound) {
            int currentSum = numbers[leftBound] + numbers[rightBound];
            if (currentSum > target) {
                rightBound = rightBound - 1; // shrink the bound to be a smaller number
            } else if (currentSum < target) {
                leftBound = leftBound + 1; // expand the bound to be a larger number
            } else {
                return new int[]{(leftBound + 1), (rightBound + 1)};
            }
        }
        return new int[]{};
    }
}
