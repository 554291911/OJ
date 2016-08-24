package recursiveAndDynamicProgramming.minHP;

public class MinHP {
	
	public int minHP(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return 0;
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row--][col--];
		if (m[row][col] > 0)
			dp[row][col] = 1;
		else
			dp[row][col] = 1 - dp[row][col];
		for (int j = col - 1; j >= 0; j--)
			dp[row][j] = Math.max(dp[row][j + 1] - m[row][j], 1);
		int right = 0;
		int down = 0;
		for (int i = row - 1; i >= 0; i--) {
			dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);
			for (int j = col - 1; j >= 0; j--) {
				right = Math.max(dp[i][j + 1] - m[i][j], 1);
				down = Math.max(dp[i + 1][j] - m[i][j], 1);
				dp[i][j] = Math.min(right, down);
			}
		}
		return dp[0][0];
	}
}
