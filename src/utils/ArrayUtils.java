package utils;

import java.util.Random;

public class ArrayUtils {
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            String numberResult = Integer.toString(array[i]);
            if (i != array.length - 1) {
                numberResult += ", ";
            }
            System.out.print(numberResult);
        }
    }

    public static int[] generateArray(int numberMaxBound, int size) {
        if (numberMaxBound <= 0 || size <= 0) {
            return new int[0];
        }

        Random random = new Random();
        int arraySize = size;
        int[] resultArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            resultArray[i] = random.nextInt(numberMaxBound);
        }
        return resultArray;
    }

    public static void swap(int[] numberArray, int leftIndex, int rightIndex) {
        int temp = numberArray[leftIndex];
        numberArray[leftIndex] = numberArray[rightIndex];
        numberArray[rightIndex] = temp;
    }
}
