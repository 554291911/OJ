package arrAndMatrix.maxSubSum;

public class MaxSubSum {
	
	public int maxSubSum(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int max = arr[0];
		int cur = arr[0];
		for (int i = 1; i < arr.length; i++) {
			cur += arr[i];
			if (cur < 0)
				cur = 0;
			if (cur > max)
				max = cur;
		}
		return max;
	}
}
