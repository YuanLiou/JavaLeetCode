import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleTwo {
	public static void main(String[] args) {
		var sample01 = 4;
		var rows = getRow02(sample01);
		ArrayUtils.printIntList(rows);
	}

	// Third practice: brute force
	public static List<Integer> getRow03(int rowIndex) {
		if (rowIndex == 0) {
			return List.of(1);
		}
		if (rowIndex == 1) {
			return List.of(1, 1);
		}

		List<Integer> answer = new ArrayList<Integer>();
		for (int columnIndex = 0; columnIndex <= rowIndex; columnIndex++) {
			answer.add(calculateRow(rowIndex, columnIndex));
		}
		return answer;
	}

	private static int calculateRow(int rowIndex, int columnIndex) {
		// base case
		if (rowIndex < 0 || columnIndex < 0) {
			return 0;
		}

		if (rowIndex == 0 || columnIndex == 0 || rowIndex == columnIndex) {
			return 1;
		}
		
		return calculateRow(rowIndex - 1, columnIndex - 1) +
				calculateRow(rowIndex - 1, columnIndex);
	}

	public static List<Integer> getRow02(int rowIndex) {
		// 平移法
		Integer[] result = new Integer[rowIndex + 1];
		Arrays.fill(result, 0);

		// if rowIndex = 0
		result[0] = 1;

		// We're starting with 1 directly.
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i; j > 0; j--) {
				int updateResult = result[j] + result[j - 1];
				System.out.print("I: " + i);
				System.out.print(", J: " + j + " is " + result[j]);
				System.out.print(", Previous: " + (j - 1) + " is " + result[j - 1]);
				System.out.println(", J: " + j + ", J Update to " + updateResult);
				result[j] = updateResult;
			}
		}

		return Arrays.asList(result);
	}

	public static List<Integer> getRow01(int rowIndex) {
		List<List<Integer>> pascalTriangle = new ArrayList<>();

		for (int i = 0; i <= rowIndex; i++) {
			List<Integer> innerList = new ArrayList<>();
			if (i == 0) {
				innerList.add(1);
				pascalTriangle.add(innerList);
				continue;
			}

			List<Integer> previousRow = pascalTriangle.get(i - 1);
			int currentIndex = 0;
			while (currentIndex <= i) {
				int previousIndex = currentIndex - 1;
				int previous = 0;
				if (previousIndex >= 0) {
					previous = previousRow.get(previousIndex);
				}

				int current = 0;
				if (currentIndex < previousRow.size()) {
					current = previousRow.get(currentIndex);
				}

				innerList.add(previous + current);
				currentIndex++;
			}

			pascalTriangle.add(innerList);
		}

		return pascalTriangle.get(rowIndex);
	}
}
