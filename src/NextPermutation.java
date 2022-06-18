import utils.ArrayUtils;

public class NextPermutation {
    public static void main(String[] args) {
        var sample01 = new int[]{6, 2, 1, 5, 4, 3, 0};
        var sample02 = new int[]{15, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(sample02);
        ArrayUtils.printArray(sample02);
    }

    public static void nextPermutation(int[] nums) {
        // Find the first non-ascending order number from back to first
        // Swap the number with the one who is larger than it in the list.
        // Then we can reverse the list next to the swapped number.
        // Make it a descending order to an ascending order.
        //  The reason behind this if the reset of numbers of the descending order,
        //  it means we have found the **last** possible solution of a permutation.
        //  We have to find the **first** solution of a permutation so these group of
        //  number should be reverse, which shows an ascending order number.
        //  And the ascending order number means the **first** picked result of a permutation.

        // Step1. Find the first non-ascending order number from back to first
        //  might be duplication
        int endOfArray = nums.length - 1;
        int boundary = nums.length - 2;
        // left should be greater than right
        //  use <=, '=' to prevent duplications
        while (boundary >= 0 && nums[boundary] >= nums[boundary + 1]) {
            boundary--;
        }

        // edge case: didn't find anything, just swap the whole array.
        //  which means boundary < 0
        if (boundary >= 0) {
            // Step2. Find the second larger number in the right of boundary
            //  第一個比他大的數字
            int targetNumber = -1;
            for (int j = endOfArray; j > boundary; j--) {
                if (nums[j] > nums[boundary]) {
                    targetNumber = j;
                    break;
                }
            }

            // Step3. Swap these two number
            if (targetNumber != -1) {
                ArrayUtils.swap(nums, boundary, targetNumber);
                boundary += 1;
            }

        } else {
            boundary = 0;
        }

        // Step4. reverse remand numbers
        ArrayUtils.reverse(nums, boundary, endOfArray);
    }
}
