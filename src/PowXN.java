public class PowXN {
	public static void main(String[] args) {
		var sampleClass = new PowXN();
		var result = sampleClass.myPow(2, -2);
		System.out.println("result is " + result);
	}

	public double myPow(double x, int n) {
		long times = n;

		// 處理負次方
		if (times < 0) {
			times = times * -1;
			x = 1 / x;
		}
		return performPow(x, times);
	}

	private double performPow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}

		double half = performPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

	// int will overflow over 32bit int
	public double myPowOverflow(double x, int n) {
		if (n == 0) {
			return 1;
		}

		if (n > 0) {
			return myPowOverflow(x, n - 1) * x;
		} else {
			return myPowOverflow(x, n + 1) / x;
		}
	}
}
