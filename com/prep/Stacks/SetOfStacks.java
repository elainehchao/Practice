package com.prep.Stacks;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks<T> {
	
	private int capacity;
	
	List<Stack<T>> stacks;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		stacks = new ArrayList<Stack<T>>();
		Stack<T> initialStack = new Stack<T>();
		stacks.add(initialStack);
	}
	
	public void push(T value) {
//		Stack<T> stack = getLastStack();
//		if (stack.size() >= capacity) {
//			stack = new Stack<T>();
//			stacks.add(stack);
//		}
//		stack.push(value);
		Stack<T> stack = getFirstAvailableStack();
		stack.push(value);
	}
	
	public StackNode<T> peek() {
		Stack<T> stack = getLastStack();
		return stack.peek();
	}
	
	public StackNode<T> pop() throws StackException {
		Stack<T> stack = getLastStack();
		StackNode<T> popped = stack.pop();
		if (stack.isEmpty()) {
			stacks.remove(stacks.size() - 1);
		}
		return popped;
	}
	
	public boolean isEmpty() {
		Stack<T> stack = getLastStack();
		return stack.isEmpty();
	}
	
	public int numStacks() {
		return stacks.size();
	}
	
	public StackNode<T> popAtIndex(int index) throws StackException {
		Stack<T> stack = stacks.get(index);
		return stack.pop();
	}
	
	public Stack<T> getLastStack() {
		return stacks.get(stacks.size() - 1);
	}
	
	public Stack<T> getFirstAvailableStack() {
		for (Stack<T> stack : stacks) {
			if (stack.size() < capacity) {
				return stack;
			}
		}
		Stack<T> newStack = new Stack<T>();
		stacks.add(newStack);
		return newStack;
	}
}
