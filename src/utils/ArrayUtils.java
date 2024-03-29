package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

	public static void printIntListMatrix(List<List<Integer>> matrix) {
		for (List<Integer> innerList : matrix) {
			System.out.print(" [ ");
			for (Integer integer : innerList) {
				System.out.print(integer + " ");
			}
			System.out.print(" ] ");
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

	public static int[] generateDedupedArray(int numberMaxBound, int size) {
		if (numberMaxBound <= 0 || size <= 0) {
			return new int[0];
		}

		Random random = new Random();
		int arraySize = size;
		Set<Integer> resultSet = new HashSet<>();
		while ((resultSet.size()) < arraySize) {
			resultSet.add(random.nextInt(numberMaxBound));
		}

		int[] resultArray = new int[arraySize];
		int index = 0;
		for (int number : resultSet) {
			resultArray[index] = number;
			index++;
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

	/**
	 * @return the right index of insertion.
	 */
	public static int bisect(int[] inputArray, int target) {
		int index = Arrays.binarySearch(inputArray, target);
		if (index < 0) {
			// did not found, it'll return an insertion point (-(insertion point) - 1)
			/*
			sample:
				- Suppose we are searching for the value 3 in the sorted list [1, 2, 4, 5, 7].
				- Since 3 is not in the list, Arrays.binarySearch() will return −3
				because the insertion point for 3 is at index 2.
				- To have the correct position, performing -(index + 1) will be −(−3 + 1) = 2 ,
				which is the correct insertion point.
			 */
			return -(index + 1);
		}
		return index + 1;
	}
}
