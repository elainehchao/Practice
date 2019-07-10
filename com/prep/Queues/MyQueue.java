package com.prep.Queues;

import com.prep.Stacks.Stack;
import com.prep.Stacks.StackException;
import com.prep.Stacks.StackNode;

/**
 * Queue implemented with 2 stacks
 * @author elainechao
 *
 */
public class MyQueue<T> {
	
	private Stack<T> newest;
	private Stack<T> oldest;
	
	public MyQueue() {
		newest = new Stack<>();
		oldest = new Stack<>();
	}
	
	public void push(T value) {
//		if (newest.isEmpty()) {
//			// push all elements to newest
//			while (!oldest.isEmpty()) {
//				try {
//					newest.push(oldest.pop().getValue());
//				} catch (StackException exception) {
//					System.out.println("Unexpected empty stack");
//				}
//			}
//		} 
		newest.push(value);
	}
	
	public StackNode<T> peek() {
		if (oldest.isEmpty()) {
			while (!newest.isEmpty()) {
				try {
					oldest.push(newest.pop().getValue());
				} catch (StackException exception) {
					System.out.println("Unexpected empty stack");
				}
			}
		}
		return oldest.peek();
	}
	
	public StackNode<T> pop() throws StackException {
		if (oldest.isEmpty()) {
			while (!newest.isEmpty()) {
				try {
					oldest.push(newest.pop().getValue());
				} catch (StackException exception) {
					System.out.println("Unexpected empty stack");
				}
			}
		}
		return oldest.pop();
	}
}
