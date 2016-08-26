package arrAndMatrix.multArr;

public class MultArr {
	
	public int[] multArr(int[] arr) {
		if (arr == null || arr.length < 2)
			return null;
		int count = 0;
		int all = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				all *= arr[i];
			else
				count++;
		}
		int[] res = new int[arr.length];
		if (count == 0) {
			for (int i = 0; i < arr.length; i++)
				res[i] = all / arr[i];
		}
		if (count == 1) {
			for (int i = 0; i < res.length; i++) {
				if (arr[i] == 0)
					res[i] = all;
			}
		}
		return res;
	}
}
