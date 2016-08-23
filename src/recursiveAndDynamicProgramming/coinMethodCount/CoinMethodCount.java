package recursiveAndDynamicProgramming.coinMethodCount;

public class CoinMethodCount {
	
	public int coins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0)
			return 0;
		return process1(arr, 0, aim);
	}
	
	private int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			if (aim == 0)
				res = 1;
			else
				res = 0;
		} else {
			for (int i = 0; arr[index] * i < aim; i++) {
				res += process1(arr, index + 1, aim - arr[index] + i);
			}
		}
		return res;
	}
	
	public int coins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0)
			return 0;
		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr, 0, aim, map);
	}
	
	private int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			if (aim == 0)
				res = 1;
			else
				res = 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				if (mapValue != 0) {
					if (mapValue == -1)
						res += 0;
					else
						res += mapValue;
				} else
					res += process2(arr, index + 1, aim - arr[index] * i, map);
			}
		}
		if (res == 0)
			map[index][aim] = -1;
		else
			map[index][aim] = res;
		return res;
	}
	
	public int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0)
			return 0;
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		for (int i = 0; i < n; i++)
			dp[i][0] = 1;
		for (int j = 1; j <= aim; j++)
			dp[0][arr[0] * j] = 1;
		int num = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				num = 0;
				for (int k = 0; k < dp.length; k++)
					num += dp[i - 1][j - arr[i] * k];
				dp[i][j] = num;
			}
		}
		return dp[arr.length - 1][aim];
	}
	
	public int coins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0)
			return 0;
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++)
			dp[i][0] = 1;
		for (int j = 1; j <= aim; j++)
			dp[0][arr[0] * j] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - arr[i] >= 0)
					dp[i][j] += dp[i][j - arr[i]];
			}
		}
		return dp[arr.length][aim];
	}

	public int coins5(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0)
			return 0;
		int[] dp = new int[aim + 1];
		for (int j = 1; j <= aim; j++)
			dp[j * arr[0]] = 1;
		int num = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				if (j - arr[i] >= 0)
					dp[j] += dp[j - arr[i]];
			}
		}
		return dp[aim];
	}
}
