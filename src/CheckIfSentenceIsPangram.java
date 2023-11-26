import java.util.HashSet;
import java.util.Set;

public class CheckIfSentenceIsPangram {

	public static void main(String[] args) {
		var sampleClass = new CheckIfSentenceIsPangram();
		// expected: true
		var sampleInput01 = "thequickbrownfoxjumpsoverthelazydog";
		var result01 = sampleClass.checkIfPangram(sampleInput01);
		System.out.println("Result 01 is " + result01);
	}

	public boolean checkIfPangram(String sentence) {
		if (sentence.length() < 26) {
			return false;
		}

		Set<Character> characters = new HashSet<>();
		for (int i = 0; i < sentence.length(); i++) {
			char current = sentence.charAt(i);
			characters.add(current);
		}
		return characters.size() > 25;
	}
}
