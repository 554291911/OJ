package arrAndMatrix.maxSubMatrixSum;

public class MaxSubMatrixSum {
	
	public int maxSum(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		int cur = 0;
		int[] s = null;
		for (int i = 0; i != m.length; i++) {
			s = new int[m[0].length];
			for (int j = 0; j != m.length; j++) {
				cur = 0;
				for (int k = 0; k < s.length; k++) {
					s[k] += m[j][k];
					cur += s[k];
					max = Math.max(max, cur);
					if (cur < 0)
						cur = 0;
				}
			}
		}
		return max;
	}
}
