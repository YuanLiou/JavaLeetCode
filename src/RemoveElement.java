import utils.ArrayUtils;

public class RemoveElement {
    public static void main(String[] args) {
        var sample01 = new int[]{3, 2, 2, 3};
        var target01 = 3;
        var sample02 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var target02 = 2;
        var result = removeElement(sample01, target01);
        System.out.println("Result is " + result);
        ArrayUtils.printArray(sample01);
    }

    public static int removeElement(int[] nums, int val) {
        // base case
        if (nums.length == 0) {
            return 0;
        }

        int k = 0; // element position to be put
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber != val) {
                nums[k] = currentNumber;
                k++; // move to next position to put element
            }
        }

        return k;
    }
}