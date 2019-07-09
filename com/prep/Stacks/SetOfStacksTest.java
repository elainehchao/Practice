package com.prep.Stacks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetOfStacksTest {
	
	@Test
	public void pushToEmptySetOfStacks() {
		SetOfStacks<Integer> sos = new SetOfStacks<>(5);
		sos.push(12);
		assertEquals(12, (int) sos.peek().getValue());
	}
	
	@Test
	public void pushToNonEmptySetOfStacksWithinCapacity() {
		SetOfStacks<Integer> sos = new SetOfStacks<>(5);
		sos.push(12);
		sos.push(10);
		sos.push(15);
		assertEquals(15, (int) sos.peek().getValue());
		assertEquals(1, sos.numStacks());
	}
	
	@Test
	public void pushToNonEmptySetOfStacksExceedsCapacity() {
		SetOfStacks<Integer> sos = new SetOfStacks<>(5);
		sos.push(12);
		sos.push(10);
		sos.push(15);
		sos.push(4);
		sos.push(25);
		sos.push(12);
		assertEquals(12, (int) sos.peek().getValue());
		assertEquals(2, sos.numStacks());
	}
	
	@Test(expected = StackException.class)
	public void popEmptySetOfStacks() throws StackException{
		SetOfStacks<Integer> sos = new SetOfStacks<>(5);
		sos.pop();
	}
	
	@Test
	public void popNonEmptySetOfStacksExceedsCapacity() throws StackException {
		SetOfStacks<Integer> sos = new SetOfStacks<>(5);
		sos.push(12);
		sos.push(10);
		sos.push(15);
		sos.push(4);
		sos.push(25);
		sos.push(12);
		sos.pop();
		assertEquals(25, (int) sos.peek().getValue());
		assertEquals(1, sos.numStacks());
	}
	
	@Test
	public void popAtIndex() throws StackException {
		SetOfStacks<Integer> sos = new SetOfStacks<>(3);
		sos.push(12);
		sos.push(10);
		sos.push(15);
		
		sos.push(4);
		sos.push(25);
		sos.push(12);
		
		sos.push(17);
		
		sos.popAtIndex(1);
		sos.pop();
		assertEquals(25, (int) sos.peek().getValue());
	}
	
	@Test
	public void popAtIndexThenPush() throws StackException {
		SetOfStacks<Integer> sos = new SetOfStacks<>(3);
		sos.push(12);
		sos.push(10);
		sos.push(15);
		
		sos.push(4);
		sos.push(25);
		sos.push(12);
		
		sos.push(17);
		
		sos.popAtIndex(1);
		
		// should replace the previously popped spot
		sos.push(100);
		assertEquals(17, (int) sos.peek().getValue());
	}
}
