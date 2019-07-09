package com.prep.Stacks;

public class Stack<T> {
	private StackNode<T> top;
	
	public void push(T value) {
		StackNode<T> newNode = new StackNode(value);
		newNode.setNext(top);
		top = newNode;
	}
	
	public StackNode<T> pop() throws StackException {
		if (top == null) {
			throw new StackException("Stack is empty");
		}
		StackNode<T> popped = top;
		top = top.getNext();
		return popped;
	}
	
	public StackNode<T> peek() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
