package recursiveAndDynamicProgramming.maxCommonSub;

public class MaxCommonSub {
	
	public int[][] getDp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		boolean flag = false;
		for (int i = 0; i < str1.length; i++) {
			if (flag)
				dp[i][0] = 1;
			if (str1[i] == str2[0]) {
				dp[i][0] = 1;
				flag = true;
			}
		}
		flag = false;
		for (int j = 0; j < str2.length; j++) {
			if (flag)
				dp[0][j] = 1;
			if (str1[0] == str2[j]) {
				dp[0][j] = 1;
				flag = true;
			}
		}
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j])
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
			}
		}
		return dp;
	}
	
	public String lcse(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals(""))
			return "";
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		int[][] dp = getDp(ch1, ch2);
		int m = ch1.length - 1;
		int n = ch2.length - 1;
		char[] res = new char[dp[m][n]];
		int index = res.length - 1;
		while (index >= 0) {
			if (n > 0 && dp[m][n] == dp[m][n - 1])
				n--;
			else
				if (m > 0 && dp[m][n] == dp[m - 1][n])
					m--;
				else {
					res[index--] = ch1[m];
					m--;
					n--;
				}
		}
		return String.valueOf(res);
	}

}
