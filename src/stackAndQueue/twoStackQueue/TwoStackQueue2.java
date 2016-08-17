package stackAndQueue.twoStackQueue;

import java.util.Stack;

public class TwoStackQueue2 {
	
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStackQueue2() {
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
	}
	
	public void add(int num) {
		stackPush.push(num);
	}
	
	public int poll() {
		if (stackPush.isEmpty() && stackPop.isEmpty())
			throw new RuntimeException("队列空");
		else
			if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
		return stackPop.pop();
	}
	
	public int peek() {
		if (stackPush.isEmpty() && stackPop.isEmpty())
			throw new RuntimeException("队列空");
		else
			if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
		return stackPop.peek();
	}
}
