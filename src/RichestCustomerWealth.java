public class RichestCustomerWealth {
	public static void main(String[] args) {
		// [2, 8 ,7], [7, 1, 3], [1, 9 ,5]
	}

	public int maximumWealth(int[][] accounts) {
		int wealth = 0;
		for (int[] number : accounts) {
			var current = 0;
			for (int money : number) {
				current += money;
			}
			wealth = Math.max(current, wealth);
		}
		return wealth;
	}
}
