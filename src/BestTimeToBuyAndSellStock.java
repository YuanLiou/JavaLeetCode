public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		// mi = 1
		// ma = 5
		// Sample01: 7, 1, 5, 3, 6, 4
	}

	public int maxProfit(int[] prices) {
		int minimumValue = Integer.MAX_VALUE;
		int maximumValue = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minimumValue) {
				minimumValue = prices[i];
			}

			var current = prices[i] - minimumValue;
			if (current > maximumValue) {
				maximumValue = current;
			}
		}

		return maximumValue;
	}
}
