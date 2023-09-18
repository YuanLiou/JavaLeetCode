public class ZigzagConversion {
	public static void main(String[] args) {
		var sampleClass = new ZigzagConversion();

		// expected: "PAHNAPLSIIGYIR"
		var example01 = "PAYPALISHIRING";
		var result01 = sampleClass.convert(example01, 3);
		System.out.println("Result is " + result01);

		// expected: "PINALSIGYAHRPI"
		var example02 = "PAYPALISHIRING";
		var result02 = sampleClass.convert(example01, 4);
		System.out.println("Result 02 is " + result02);
	}

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		String[][] textMap = new String[numRows][s.length()];
		int currentRow = 0;
		int currentColumn = 0;
		boolean movingDown = true;
		for (int i = 0; i < s.length(); i++) {
			String current = String.valueOf(s.charAt(i));
			if (currentRow < numRows && currentColumn < s.length()) {
				textMap[currentRow][currentColumn] = current;
			}

			if (currentRow == 0) {
				movingDown = true;
			} else if (currentRow == numRows - 1) {
				movingDown = false;
			}

			if (movingDown) {
				currentRow++;
			} else {
				currentColumn++;
				currentRow--;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (String[] inner : textMap) {
			for (String content : inner) {
				if (content != null) {
					stringBuilder.append(content);
				}
			}
		}
		return stringBuilder.toString();
	}
}
