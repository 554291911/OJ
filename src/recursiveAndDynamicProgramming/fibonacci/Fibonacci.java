package recursiveAndDynamicProgramming.fibonacci;

public class Fibonacci {
	
	public int f1(int n) {
		if (n < 1)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		return f1(n - 1) + f1(n - 2);
	}

	public int f2(int n) {
		if (n < 1)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int res = 1;
		int pre = 1;
		int tmp = 0;
		for (int i = 3; i < n; i++) {
			tmp = res;
			res += pre;
			pre = tmp;
		}
		return res;
	}
	
	public int s1(int n) {
		if (n < 1)
			return 0;
		if (n == 1 || n == 2)
			return n;
		return s1(n - 1) + s1(n - 2);
	}

	public int s2(int n) {
		if (n < 1)
			return 0;
		if (n == 1 || n == 2)
			return n;
		int res = 2;
		int pre = 1;
		int tmp = 0;
		for (int i = 3; i < n; i++) {
			tmp = res;
			res += pre;
			pre = tmp;
		}
		return res;
	}

	public int c(int n) {
		if (n < 1)
			return 0;
		if (n == 1 || n == 2 || n == 3)
			return n;
		return c(n - 1) + c(n - 3);
	}
}
