package com.prep.Stacks;

public class Stack<T> {
	private StackNode<T> top;
	
	private int size;
	
	public void push(T value) {
		StackNode<T> newNode = new StackNode(value);
		newNode.setNext(top);
		top = newNode;
		size++;
	}
	
	public StackNode<T> pop() throws StackException {
		if (top == null) {
			throw new StackException("Stack is empty");
		}
		StackNode<T> popped = top;
		top = top.getNext();
		size--;
		return popped;
	}
	
	public StackNode<T> peek() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return size;
	}
}
