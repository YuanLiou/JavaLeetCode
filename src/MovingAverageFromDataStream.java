import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
	public static void main(String[] args) {
		var sampleClass = new MovingAverageFromDataStream.MovingAverage(3);
		var result01 = sampleClass.next(1);
		var result02 = sampleClass.next(10);
		var result03 = sampleClass.next(3);
		var result04 = sampleClass.next(5);
		System.out.println(result01);
		System.out.println(result02);
		System.out.println(result03);
		System.out.println(result04);
	}

	static class MovingAverage {

		private int size;
		private Queue<Integer> queue;
		public MovingAverage(int size) {
			this.queue = new LinkedList<Integer>();
			this.size = size;
		}

		public double next(int val) {
			if (queue.size() == size) {
				queue.poll();
			}
			queue.offer(val);

			var currentNumbers = 0.0;
			for (Integer number : queue) {
				currentNumbers += number;
			}
			return currentNumbers / queue.size();
		}
	}
}
