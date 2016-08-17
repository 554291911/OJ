package stackAndQueue.twoStackSort;

import java.util.Stack;

public class TwoStackSort {

	public void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int value = stack.pop();
			while (!help.isEmpty() && help.peek() > value)
				stack.push(help.pop());
			stack.push(value);
		}
		while (!help.isEmpty())
			stack.push(help.pop());
	}
}
