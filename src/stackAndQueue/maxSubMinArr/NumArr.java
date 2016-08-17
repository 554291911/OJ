package stackAndQueue.maxSubMinArr;

import java.util.LinkedList;

public class NumArr {

	public int getNum(int[] arr, int num) {
		LinkedList<Integer> qMax = new LinkedList<Integer>();
		LinkedList<Integer> qMin = new LinkedList<Integer>();
		int i = 0, j = 0, res = 0;
		while (i < arr.length) {
			while (j < arr.length) {
				while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[j])
					qMax.pollLast();
				qMax.addLast(j);
				while (!qMax.isEmpty() && arr[qMin.peekLast()] <= arr[j])
					qMin.pollLast();
				qMin.addLast(j);
				if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > num)
					break;
				j++;
			}
			if (qMax.peekFirst() == i)
				qMax.pollFirst();
			if (qMin.peekFirst() == i)
				qMin.pollFirst();
			res += j - i;
			i++;
		}
		return res;
	}

}
