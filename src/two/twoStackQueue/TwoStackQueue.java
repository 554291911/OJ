package two.twoStackQueue;

import java.util.Stack;


public class TwoStackQueue {
	
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStackQueue() {
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
	}
	
	public void add(int num) {
		while (!stackPop.isEmpty()) {
			stackPush.push(stackPop.pop());
		}
		stackPush.push(num);
	}
	
	public int poll() {
		if (stackPush.isEmpty() && stackPop.isEmpty())
			throw new RuntimeException("队列空");
		while (!stackPush.isEmpty()) {
			stackPop.push(stackPush.pop());
		}
		return stackPop.pop();
	}
	
	public int peek() {
		if (stackPush.isEmpty() && stackPop.isEmpty())
			throw new RuntimeException("队列空");
		while (!stackPush.isEmpty()) {
			stackPop.push(stackPush.pop());
		}
		return stackPop.peek();
	}
}
