package recursiveAndDynamicProgramming.maxSub;

public class MaxSub {
	
	public int[] getDp(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		return dp;
	}
	
	public int[] generate(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for (int i = index; i >= 0; i++) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				lis[--len] = arr[i];
				index = i;
			}

		}
		return lis;
	}

	public int[] lis(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;
		int[] dp = getDp(arr);
		return generate(arr, dp);
	}
}
