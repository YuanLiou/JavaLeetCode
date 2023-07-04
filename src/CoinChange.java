import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);

		// base case
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				// 如果要找的數字 i 比硬幣還小，就沒意義了
				if (i - coin >= 0) {
					// 1 + dp[(amount of i) - coin]
					// 1 個硬幣 + 組成 (amount of i) - coin 的最小硬幣數
					//  e.g. [1, 3, 4, 5] Amount = 7
					//  DP[7] = 1 + DP[4]. 4 是因為 7 - 3, 我們可以在 [1, 3, 4, 5] 中
					//  取出 3。因為我們取出了一個硬幣，故公式裡有 1。接著去找我要取得 4 需要幾個硬幣。
					//  DP[i] 的意思是，如果我要取得 Amount i，我需要幾個硬幣
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
		}

		if (dp[amount] == amount + 1) {
			// 代表沒找到
			return -1;
		}
		return dp[amount];
	}
}