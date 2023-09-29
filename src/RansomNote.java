import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public static void main(String[] args) {
	}

	// can words in magazine construct a ransomNote?
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		Map<String, Integer> wordsMap = new HashMap<>();
		for (int i = 0; i < magazine.length(); i++) {
			String character = String.valueOf(magazine.charAt(i));
			int counts = wordsMap.getOrDefault(character, 0);
			wordsMap.put(character, counts + 1);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			String character = String.valueOf(ransomNote.charAt(i));
			if (!wordsMap.containsKey(character)) {
				return false;
			}

			int counts = wordsMap.getOrDefault(character, 0);
			if (counts == 0) {
				return false;
			}
			wordsMap.put(character, counts - 1);
		}
		return true;
	}
}
