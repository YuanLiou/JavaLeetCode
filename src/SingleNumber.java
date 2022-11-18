import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
	public static void main(String[] args) {
	}

	public int singleNumber(int[] nums) {
		List<Integer> numbers = new ArrayList<>();
		for (int number : nums) {
			if (numbers.contains(number)) {
				numbers.remove(Integer.valueOf(number));
				continue;
			}

			numbers.add(number);
		}
		return numbers.get(0);
	}
}
