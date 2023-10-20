import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {
	public static void main(String[] args) {
		var sampleClass = new IntegerToRoman();
		var result = sampleClass.intToRoman(1994);
		System.out.println("Result01 is " + result);
	}

	public String intToRoman(int num) {
		Map<Integer, String> wordMaps = new TreeMap<>((o1, o2) -> o2 - o1);
		wordMaps.put(1000, "M");
		wordMaps.put(900, "CM");
		wordMaps.put(500, "D");
		wordMaps.put(400, "CD");
		wordMaps.put(100, "C");
		wordMaps.put(90, "XC");
		wordMaps.put(50, "L");
		wordMaps.put(40, "XL");
		wordMaps.put(10, "X");
		wordMaps.put(9, "IX");
		wordMaps.put(5, "V");
		wordMaps.put(4, "IV");
		wordMaps.put(1, "I");

		StringBuilder stringBuilder = new StringBuilder();
		for (var entry : wordMaps.entrySet()) {
			if (num / entry.getKey() > 0) {
				int counts = num / entry.getKey();
				for (int i = 0; i < counts; i++) {
					stringBuilder.append(entry.getValue());
				}
				num %= entry.getKey();
			}
		}
		return stringBuilder.toString();
	}
}
