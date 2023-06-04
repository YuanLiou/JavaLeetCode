import java.util.Arrays;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		var sampleClass = new LongestCommonSubsequence();
		var result = sampleClass.longestCommonSubsequence("abcde", "ace");
		System.out.println("Result is " + result);
	}

	public int longestCommonSubsequence(String text1, String text2) {
		// build up the matrix
		int[][] lcsCounts = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i < lcsCounts.length; i++) {
			Arrays.fill(lcsCounts[i], 0); // Arrays.fill can only fill one direction array
		}

		for (int i = text1.length() - 1; i >= 0; i--) {
			for (int j = text2.length() - 1; j >= 0; j--) {
				var target01 = String.valueOf(text1.charAt(i));
				var target02 = String.valueOf(text2.charAt(j));
				if (target01.equals(target02)) {
					lcsCounts[i][j] = lcsCounts[i + 1][j + 1] + 1;
				} else {
					lcsCounts[i][j] = Math.max(lcsCounts[i][j + 1], lcsCounts[i + 1][j]);
				}
			}
		}
		return lcsCounts[0][0];
	}
}
