package stackAndQueue.getMin;

import java.util.Stack;

public class MyStack2 {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack2() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		stackData.push(newNum);
		if (stackMin.isEmpty()) {
			stackMin.push(newNum);
		} else
			if (newNum >= this.getMin()) {
				stackMin.push(this.getMin());
		} else{
				stackMin.push(newNum);
		}
	}
	
	public int pop() {
		if (stackData.isEmpty())
			throw new RuntimeException("栈空");
		stackMin.pop();
		return stackData.pop();
	}
	
	public int getMin() {
		if (stackMin.isEmpty())
			throw new RuntimeException("栈空");
		return stackMin.peek();
	}
}
