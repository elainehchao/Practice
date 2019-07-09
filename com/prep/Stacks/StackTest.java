package com.prep.Stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class StackTest {
	
	@Test
	public void testPushToEmptyStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(12);
		assertEquals(12, (int) stack.peek().getValue());
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testPushToNonEmptyStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(12);
		stack.push(15);
		stack.push(7);
		assertEquals(7, (int) stack.peek().getValue());
	}
	
	@Test(expected = StackException.class)
	public void testPopEmptyStack() throws StackException {
		Stack<Integer> stack = new Stack<>();
		stack.pop();
	}
	
	@Test
	public void testPopNonEmptyStack() throws StackException {
		Stack<Integer> stack = new Stack<>();
		stack.push(12);
		stack.push(15);
		stack.push(7);
		stack.pop();
		assertEquals(15, (int) stack.peek().getValue());
	}

}
