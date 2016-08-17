package stackAndQueue.recursionStack;

import java.util.Stack;


public class RecursionStack {

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int i = getLast(stack);
		reverse(stack);
		stack.push(i);
	}

	private static int getLast(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty())
			return result;
		else {
			int last = getLast(stack);
			stack.push(result);
			return last;
		}
	}

}
