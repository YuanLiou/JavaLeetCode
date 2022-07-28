public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        // expected: 2
        var sample01 = new int[]{1, 1, 2};
        var result01 = removeDuplicates(sample01);

        // expected: 5
        var sample02 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        var result02 = removeDuplicates(sample02);

        System.out.println("Result is " + result02);
    }

    public static int removeDuplicates(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0; // explorer pointer
        int k = 0; // next to add
        int currentNumber = -101; // less then min value of nums
        while (i < nums.length) {
            int pickedNumber = nums[i];
            if (currentNumber != pickedNumber) {
                nums[k] = pickedNumber;
                currentNumber = pickedNumber;
                k++;
            }
            i++;
        }
        
        return k;
    }
}
