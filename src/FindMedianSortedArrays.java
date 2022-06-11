import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] a = new int[]{ 1, 3 };
        int[] b = new int[]{ 2 };
        var result = findMedianSortedArrays(a, b);
        System.out.println("Result is " + result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        Arrays.sort(mergedArray);
        int arrayLength = mergedArray.length;
        if (arrayLength % 2 == 0) {
            int index01 = (arrayLength) / 2;
            int index02 = index01 - 1;
            return (mergedArray[index01] + mergedArray[index02]) / 2f;
        } else {
            int index = (arrayLength - 1) / 2;
            return mergedArray[index];
        }
    }
}
