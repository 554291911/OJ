package recursiveAndDynamicProgramming.minPathNum;

public class MinPathNum {
	
	public int minPathNum1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return 0;
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < row; i++)
			dp[i][0] = dp[i - 1][0] + m[i][0];
		for (int j = 1; j < col; j++)
			dp[0][j] = dp[0][j - 1] + m[0][j];
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		
		return dp[row - 1][col - 1];
	}
	
	public int minPathNum2(int[][] m) {// 默认行列相等
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return 0;
		int row = m.length;// 行
		int col = m[0].length;// 列
		int[] arr = new int[row];
		arr[0] = m[0][0];
		for (int i = 1; i < arr.length; i++)
			arr[i] = arr[i - 1] + m[0][i];
		for (int i = 1; i < col; i++) {
			arr[0] = arr[0] + m[i][0];
			for (int j = 1; j < row; j++) {
				arr[j] = Math.min(arr[j - 1], arr[j]) + m[i][j];
			}
		}

		return arr[arr.length - 1];
	}
	
	public int minPathNum3(int[][] m) {//通用
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return 0;
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);
		int[] arr = new int[less];
		arr[0] = m[0][0];
		boolean convert = false;
		if (m.length < m[0].length)// 行小于列
			convert = true;
		for (int i = 1; i < arr.length; i++) {
			if (convert)
				arr[i] = arr[i - 1] + m[i][0];
			else
				arr[i] = arr[i - 1] + m[0][i];
		}
		for (int i = 1; i < more; i++) {
			if (convert)
				arr[0] = arr[0] + m[i][0];
			else
				arr[0] = arr[0] + m[0][i];
			for (int j = 1; j < less; j++) {
				if (convert)
					arr[j] = Math.min(arr[j - 1], arr[j]) + m[i][j];
				else
					arr[j] = Math.min(arr[j - 1], arr[j]) + m[j][i];
			}
		}
		return arr[less - 1];
	}
}
