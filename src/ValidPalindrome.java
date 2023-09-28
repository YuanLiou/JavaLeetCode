public class ValidPalindrome {
	public static void main(String[] args) {
		var sampleClass = new ValidPalindrome();
		var example01 = "A man, a plan, a canal: Panama";
		// expect: true
		var result01 = sampleClass.isPalindrome(example01);
		System.out.println("Result is " + result01);
	}

	public boolean isPalindrome(String s) {
		String processedString = s.replaceAll("\\s+", "")
				.replaceAll("[^a-zA-Z0-9]", "")
				.toLowerCase();

		int i = 0;
		int j = processedString.length() - 1;
		while (i < j) {
			String leftChar = String.valueOf(processedString.charAt(i));
			String rightChar = String.valueOf(processedString.charAt(j));
			if (!leftChar.equals(rightChar)) {
				return false;
			}

			i++;
			j--;
		}
		return true;
	}
}
