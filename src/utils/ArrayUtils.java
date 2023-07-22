package utils;

import java.util.List;
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

	public static void printMatrix(int[][] matrix) {
		for (int[] innerArray : matrix) {
			System.out.print(" [ ");
			for (int i = 0; i < innerArray.length; i++) {
				System.out.print(innerArray[i] + " ");
			}
			System.out.print(" ] ");
		}
	}

	public static void printCharArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			String postfix = "";
			if (i != array.length - 1) {
				postfix = ", ";
			}
			System.out.print(array[i] + postfix);
		}
	}

	public static void printStringList(List<String> stringList) {
		for (int i = 0; i < stringList.size(); i++) {
			String numberResult = stringList.get(i);
			if (i != stringList.size() - 1) {
				numberResult += ", ";
			}
			System.out.print(numberResult);
		}
	}

	public static void printIntList(List<Integer> integerList) {
		for (int i = 0; i < integerList.size(); i++) {
			Integer numberResult = integerList.get(i);
			if (i != integerList.size() - 1) {
				System.out.print(String.valueOf(numberResult) + ", ");
			} else {
				System.out.print(String.valueOf(numberResult));
			}
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

	public static void reverse(int[] numberArray, int startPosition, int endPosition) {
		int start = startPosition;
		int end = endPosition;

		while (start < end) {
			swap(numberArray, start, end);
			start++;
			end--;
		}
	}
}
