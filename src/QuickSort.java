import utils.ArrayUtils;
import utils.IntegerUtils;

public class QuickSort {

    public static void main(String[] args) {
        var testArray = ArrayUtils.generateArray(100, 10);
        System.out.print("original array: ");
        ArrayUtils.printArray(testArray);

        System.out.println("");

        quickSort(testArray);
        System.out.print("Sorted array: ");
        ArrayUtils.printArray(testArray);
    }

    private static void quickSort(int[] numberArray) {
        quickSort(numberArray, 0, numberArray.length - 1);
    }

    private static void quickSort(int[] numberArray, int leftBound, int rightBound) {
        // Partition to find pivot position
        //  I. partition (recursive)
        //  1. two pointer: left pointer and right pointer
        //    target to find a position for the pivot number
        //  2. looping when right pointer is larger than left pointer
        //  3. leftPointer++ if current A[leftPointer] is smaller or equals than pivot number
        //  4. rightPointer++ if current A[rightPointer] is larger or equals than pivot number
        //  5. so eventually we'll find two positions. (you should reverse the logic here)
        //     leftPosition is a number larger than the pivot number
        //     rightPosition is a number smaller than the pivot number
        //    5-1. We should make sure when doing picking number, the left pointer is always smaller
        //         than right pointer. (we don't want it cross.)
        //  6. swap these two position
        //  (looping above until left pointer is pass the right pointer.)( while (left < right) {} )
        //  7. swap the position of left Pointer and the pivot number
        //     This is because the left pointer and right pointer would meet each other.
        //  8. return the leftPointer (I think right pointer is also can be accepted)
        //
        // II. Sort with small chunk separated by the pivot position.
        //  1. The return position as the next position of pivot
        //    key takeaway: start from the second run, split chunk between pivot position
        //    [left chunk] pivot [right chunk]
        //  2. doing quicksort both leftBound..returnPosition - 1, returnPosition + 1..rightBound
        //     recursively
        //  We should make sure the left pointer is always smaller than the right pointer.
        //  this can be the base case of recursive works.

        if (leftBound >= rightBound) {
            // base case: make sure leftPointer is always smaller than rightPointer
            return;
        }

        // Step1: Partition
        int pivotPointer = partition(numberArray, leftBound, rightBound);

        // Step2: Doing sorting each chunk, exclude the position of pivot
        //  left part
        quickSort(numberArray, leftBound, pivotPointer - 1);
        //  right part
        quickSort(numberArray, pivotPointer + 1, rightBound);
    }

    private static int partition(int[] numberArray, int leftBound, int rightBound) {
        // Optimize with choosing number randomly as pivot
        //  to prevent worst case of O(n^2) result.
        int pivotIndex = IntegerUtils.getRandomNumber(leftBound, rightBound);
        int pivot = numberArray[pivotIndex];
        // move to the rightBound to fit our origin algorithm.
        ArrayUtils.swap(numberArray, pivotIndex, rightBound);

        int leftPointer = leftBound;
        int rightPointer = rightBound;

        while (leftPointer < rightPointer) {
            // Traverse numbers below or equals pivot, we don't care
            // After out of this loop, the leftPointer would point to the number
            // which is LARGER than pivot.
            while (numberArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++; // move to right
            }

            // Traverse numbers larger or equals pivot, we don't care
            // After out of this loop, the rightPointer would point to the number
            // which is SMALLER than pivot.
            while (numberArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--; // move to left
            }

            // Swap these two number
            ArrayUtils.swap(numberArray, leftPointer, rightPointer);
        }

        // Swap current overlap point with the pivot number.
        ArrayUtils.swap(numberArray, leftPointer, rightBound);
        return leftPointer;
    }
}
