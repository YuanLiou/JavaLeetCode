import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInString {

	public int firstUniqChar(String s) {
		Map<Character, Integer> charTimes = new HashMap<>();
		List<Character> nonRepeatChars = new ArrayList<>();
		char[] sChars = s.toCharArray();
		for (char character : sChars) {
			if (charTimes.containsKey(character)) {
				int times = charTimes.get(character);
				nonRepeatChars.remove(Character.valueOf(character));
				charTimes.put(character, times + 1);
			} else {
				charTimes.put(character, 1);
				nonRepeatChars.add(character);
			}
		}

		if (nonRepeatChars.isEmpty()) {
			return -1;
		}
		return s.indexOf(nonRepeatChars.get(0));
	}
}
