import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		HappyNumber sampleClass = new HappyNumber();
		// expect: true
		boolean result01 = sampleClass.isHappy(19);
		System.out.println(result01);

		// expect: false
		boolean result02 = sampleClass.isHappy(2);
		System.out.println(result02);
	}

	public boolean isHappy(int n) {
		// 目標：
		// 1. 找到 1, (10 的倍數 平方後加起來也會是 1）
		// 2. 判斷是否有重複，可以用 Set 來看是否已經重新加入或是佛洛伊德法
		Set<Integer> numbersHasSeen = new HashSet<Integer>();
		int number = n;
		while (number != 1) {
			number = countEachNumber(number);

			if (!numbersHasSeen.contains(number)) {
				numbersHasSeen.add(number);
			} else {
				return false;
			}
		}
		return true;
	}

	private int countEachNumber(int n) {
		int current = n;
		int result = 0;
		while (current > 0) {
			int digit = current % 10;
			result += (int) Math.pow(digit, 2);
			current /= 10;
		}
		return result;
	}
}
