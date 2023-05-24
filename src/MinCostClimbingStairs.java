public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] list = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		var sampleClass = new MinCostClimbingStairs();
		// expected: 6
		var result = sampleClass.minCostClimbingStairs(list);
		System.out.println("result is " + result);
	}
	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 1) {
			return cost[0];
		}

		if (cost.length == 2) {
			return Math.min(cost[0], cost[1]);
		}

		int cost01 = cost[0];
		int cost02 = cost[1];
		int finalCost = Math.min(cost01, cost02);

		for (int i = 2; i < cost.length; i++) {
			int minCost = Math.min(cost01, cost02) + cost[i];
			cost01 = cost02;
			cost02 = minCost;
			finalCost = Math.min(cost01, cost02);

			System.out.println("step " + i + ": cost 01 is " + cost01 + ", cost 02 is " + cost02);
			System.out.println("final cost is " + finalCost);
		}
		return finalCost;
	}

}
