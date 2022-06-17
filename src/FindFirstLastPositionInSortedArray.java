import java.util.Arrays;

public class FindFirstLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] sampleArray = new int[]{5, 7, 7, 8, 8, 10};
        int sampleTarget = 8;
        var result = searchRange(sampleArray, sampleTarget);
        System.out.println("Result is " + Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        // 做兩次 binary Search
        //  一次找最左邊的 target
        //  另一個找最右邊的 target
        //  魔術在 binary search 時，設定邊界的方式，包含 =
        if (nums.length == 0) {
            return new int[]{ -1, -1 };
        }
        int[] resultArray = new int[2];
        resultArray[0] = findFirstTarget(nums, target);
        resultArray[1] = findLastTarget(nums, target);
        return resultArray;
    }

    private static int findFirstTarget(int[] nums, int target) {
        int firstIndex = -1;
        // binary search
        // 找中間，比大小，左右切

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2; // prevent integer overflow
            if (nums[mid] == target) {
                firstIndex = mid;
            }

            // 往左走，如果數字相等，就持續往左找
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return firstIndex;
    }

    private static int findLastTarget(int[] nums, int target) {
        int lastIndex = -1;

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2; // prevent integer overflow
            if (nums[mid] == target) {
                lastIndex = mid;
            }

            // 往右走，如果數字相等，就持續往右找
            // 抽出來的東西，比 Target 小
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return lastIndex;
    }
}
