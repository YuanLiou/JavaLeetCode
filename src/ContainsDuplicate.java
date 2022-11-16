import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> numbers = new HashSet<Integer>();
		for (int number : nums) {
			if (numbers.contains(number)) {
				return true;
			}
			numbers.add(number);
		}
		return false;
	}
}
