package one.getMin;

import java.util.Stack;

public class MyStack1 {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack1() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		stackData.push(newNum);
		if (stackMin.isEmpty()) {
			stackMin.push(newNum);
		} else if(newNum <= this.getMin()){
				stackMin.push(newNum);
		}
	}
	
	public int pop() {
		if (stackData.isEmpty())
			throw new RuntimeException("栈空");
		int value = stackData.pop();
		if (value == this.getMin()) {
			stackMin.pop();
		}
		return value;
	}
	
	public int getMin() {
		if (stackMin.isEmpty())
			throw new RuntimeException("栈空");
		return stackMin.peek();
	}
}
