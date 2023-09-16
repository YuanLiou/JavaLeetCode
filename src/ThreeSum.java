import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		var sampleTest = new int[]{-1, 0, 1, 2, -1, -4};
		var result = threeSum02(sampleTest);
		for (List<Integer> values : result) {
			System.out.println("");
			for (int i = 0; i < values.size(); i++) {
				System.out.print(values.get(i) + "  ");
			}
		}
	}

	// Second practice
	public static List<List<Integer>> threeSum02(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int current;
		int remainder;
		for (int i = 0; i < nums.length; i++) {
			current = nums[i];
			remainder = -current;

			int left = i + 1;
			int right = left + 1;
			while (right < nums.length) {
				if (nums[left] + nums[right] == remainder) {
					result.add(new ArrayList<>(Arrays.asList(current, nums[left], nums[right])));
				}
				right++;
			}
		}
		return result;
	}
	/**
	 先 Sort 過
	 一個 For loop，每次選擇第一位數字
	 後面的數字可以學 2Sum 的解法，用 lowerBound 和 upperBound
	 <ul>
	 <li>- 1-a. for loop i..<nums.length - 2。要找三個數字，length - 1 沒意義
	 如果現在 i > 0 並且他前面那個數字跟他不一樣，再下去比大小 (不然可能找到重複的）</li>
	 <li>- 2-a. while loop (lowerBound < upperBound)
	 lowerBound = i + 1, upperBound = nums.length - 1 </li>
	 尋找目標 x = 0 - num[i]
	 <li>- 3-a. num[i] + num[lowerBound] + num[upperBound] = x </li>
	 這樣就是找到，加到 Result 列表
	   <ul>
	 <li> - 3-a-i. 這邊要注意，如果 lowerBound 和 lowerBound + 1 位子的數字相同，
	 先把 lowerBound 移到和下一個數字不同的位置，以免重複計算 </li>
	 <li> - 3-a-ii. 這邊要注意，如果 upperBound 和 upperBound - 1 位子的數字相同，
	 先把 upperBound 移到和上一個數字不同的位置，以免重複計算 </li>
	 <li> - 3-a-iii. 切記這些都要確保 lowerBound < upperBound </li>
	 </ul>
	 <li> - 3-b. num[i] + num[lowerBound] + num[upperBound] > x
	 太大了，upperBound 往裡面調整試試 (已排序，最右邊最大） </li>
	 <li> - 3-c. num[i] + num[lowerBound] + num[upperBound] < x
	 太小了，lowerBound 往裡面調整試試 (已排序，最左邊最小）</li>
	 </ul>
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 2) {
			return Collections.emptyList();
		}

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		// 最後一個數字沒辦法組出三個
		for (int i = 0; i < nums.length - 2; i++) {
			// 如果前一個數字和目前的一樣，就跳過以免重複計算
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}

			int lowerBound = i + 1;
			int upperBound = nums.length - 1;
			int targetNumber = -nums[i];

			while (lowerBound < upperBound) {
				if (nums[lowerBound] + nums[upperBound] == targetNumber) {
					result.add(new ArrayList<>(Arrays.asList(nums[i], nums[lowerBound], nums[upperBound])));

					// 避免重複計算，看看隔壁的數字是否和自己相同？
					while (lowerBound < upperBound && nums[lowerBound] == nums[lowerBound + 1]) {
						lowerBound++;
					}

					while (lowerBound < upperBound && nums[upperBound] == nums[upperBound - 1]) {
						upperBound--;
					}

					// 移動邊界
					upperBound--;
					lowerBound++;
				} else if (nums[lowerBound] + nums[upperBound] > targetNumber) {
					upperBound--;
				} else {
					lowerBound++;
				}
			}
		}
		return result;
	}

	public static List<List<Integer>> threeSumOld(int[] nums) {
		if (nums == null || nums.length < 2) {
			return Collections.emptyList();
		}

		var result = new ArrayList<List<Integer>>();
		// i 取出 * -1, 找到 j + k = (i * -1)
		for (int i = 0; i < nums.length; i++) {
			var value = nums[i] * -1;
			for (int j = i + 1; j < nums.length; j++) {
				var remaining = value - nums[j];
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[k] == remaining) {
						int[] findResult = new int[]{nums[i], nums[j], nums[k]};
						Arrays.sort(findResult);
						List<Integer> listResult = Arrays.stream(findResult).boxed().toList();
						if (!result.contains(listResult)) {
							result.add(listResult);
						}
						break;
					}
				}
			}
		}
		return result;
	}
}
