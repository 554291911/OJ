package stackAndQueue.windowMaxArr;

import java.util.LinkedList;

public class WindowMaxArr {
	
	public int[] getMax(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w)
			return null;
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
				deque.pollLast();
			deque.addLast(i);
			if (deque.peekFirst() == i - w)// 判断下标是否过期，如果过期，抛弃
				deque.pollFirst();
			if (i >= w - 1)// 前2个特殊，后面的都要放
				res[index++] = arr[deque.peekFirst()];
		}
		return res;
	}
}
