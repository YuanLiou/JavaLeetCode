import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Your RateLimiter object will be instantiated and called as such:
 * RateLimiter obj = new RateLimiter(n, t);
 * boolean param_1 = obj.shouldAllow(timestamp);
 */
public class RateLimiter {

	public static void main(String[] args) {
		RateLimiter rateLimiter = new RateLimiter(3, 5);
		// returns True
		// There are no previous requests, so this request is allowed.
		var result01 = rateLimiter.shouldAllow(1);
		System.out.println("Result 01 is " + result01);

		// returns True
		// We can allow 3 requests every 5 seconds, so this request is allowed.
		// Timestamps of allowed requests are [1,1].
		var result02 = rateLimiter.shouldAllow(1);
		System.out.println("Result 02 is " + result02);

		// returns True
		// Timestamps of allowed requests are [1,1,2].
		var result03 = rateLimiter.shouldAllow(2);
		System.out.println("Result 03 is " + result03);

		// returns False
		// This request is not allowed because
		// the time range [1,3] already has 3 allowed requests.
		var result04 = rateLimiter.shouldAllow(3);
		System.out.println("Result 04 is " + result04);

		// returns True
		// This request is allowed because
		// the time range [4,8] does not have any allowed requests.
		var result05 = rateLimiter.shouldAllow(8);
		System.out.println("Result 05 is " + result05);
	}

	private final int maxTaskCounts;
	private final int defaultIntervals;

	private final PriorityQueue<Integer> endTimes;
	public RateLimiter(int n, int t) {
		this.maxTaskCounts = n;
		this.defaultIntervals = t;
		endTimes = new PriorityQueue<>(maxTaskCounts);
	}

	public boolean shouldAllow(int timestamp) {
		while (!endTimes.isEmpty() && endTimes.peek() <= timestamp) {
			endTimes.poll();
		}

		if (endTimes.size() < maxTaskCounts) {
			endTimes.offer(timestamp + defaultIntervals);
			return true;
		}
		return false;
	}
}

