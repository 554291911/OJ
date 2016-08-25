package arrAndMatrix.printHalf;

public class PrintHalf {
	
	public void printHalf(int[] arr) {
		int candidate = 0;
		int times = 0;
		for (int i = 0; i < arr.length; i++) {
			if (times == 0) {
				candidate = arr[i];
				times = 1;
			} else
				if (arr[i] == candidate)
					times++;
				else
					times--;
		}
		times = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == candidate)
				times++;
		}
		if (times > arr.length / 2)
			System.out.println(candidate);
		else
			System.out.println("no");
	}
}
