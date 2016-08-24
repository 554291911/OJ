package recursiveAndDynamicProgramming.NQueen;

public class NQueen {
	
	public int num(int n) {
		if (n < 1)
			return 0;
		int[] record = new int[n];
		return process(0, record, n);
	}
	
	private int process(int i, int[] record, int n) {
		if (i == n)
			return 1;
		int res = 0;
		for (int j = 0; j < n; j++) {
			if (isValid(record, i, j)) {
				record[i] = j;
				res += process(i + 1, record, n);
			}
		}
		return res;
	}
	
	private boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		long begin = System.currentTimeMillis(); // 这段代码放在程序执行前
		int result = new NQueen().num(16);
		System.out.println(result);
		long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
		System.out.println("耗时：" + end + "毫秒");
	}
}
