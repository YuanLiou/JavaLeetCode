public class ReverseWordsInStringThree {
	public static void main(String[] args) {
		var sample01 = "Let's take LeetCode contest";
		var result01 = reverseWords(sample01);
		var sample02 = "God Ding";
		var result02 = reverseWords(sample02);
		System.out.println("Result is " + result02);
	}

	public static String reverseWords(String s) {
		// Base case
		if (s == null || s.length() == 0) {
			return "";
		}

		if (s.length() == 1) {
			return s;
		}

		char[] charArray = s.toCharArray();
		int i = 0; // explorer pointer
		int j = -1; // start position of a text
		while (i < s.length()) {
			char currentChar = charArray[i];
			if (currentChar != ' ') {
				if (j == -1) {
					j = i;
				}
			} else {
				reverse(charArray, j, i - 1);
				j = -1;
			}

			i++;
		}

		if (j != -1) {
			reverse(charArray, j, charArray.length - 1);
		}
		return String.valueOf(charArray);
	}

	private static void reverse(char[] chars, int startPosition, int endPosition) {
		while (startPosition < endPosition) {
			swap(chars, startPosition, endPosition);
			startPosition++;
			endPosition--;
		}
	}

	private static void swap(char[] chars, int startPosition, int endPosition) {
		char temp = chars[startPosition];
		chars[startPosition] = chars[endPosition];
		chars[endPosition] = temp;
	}
}
