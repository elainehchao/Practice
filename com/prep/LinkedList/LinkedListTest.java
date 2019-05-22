package com.prep.LinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testLinkedListCreation_NoElements() {
		LinkedList<Integer> intList = new LinkedList<>();
		assertEquals(0, intList.getSize());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyLinkedList_AddInvalidIndex() {
		LinkedList<Integer> intList = new LinkedList<>();
		intList.addAtIndex(1, 5);
	}

	@Test
	public void testEmptyLinkedList_AddElement() {
		LinkedList<Integer> intList = new LinkedList<>();
		intList.add(10);
		assertEquals(1, intList.getSize());
		assertEquals(10, intList.get(0).intValue());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyList_GetElement() {
		LinkedList<Integer> intList = new LinkedList<>();
		intList.get(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyList_RemoveElement() {
		LinkedList<Integer> intList = new LinkedList<>();
		intList.remove(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyList_GetNode() {
		LinkedList<Integer> intList = new LinkedList<>();
		intList.getNode(0);
	}
	
	@Test
	public void testEmptyList_AddAllFromAnotherList() {
		LinkedList<Integer> otherList = new LinkedList<>();
		otherList.add(2);
		otherList.add(5);
		otherList.add(10);
		LinkedList<Integer> intList = new LinkedList<>();
		intList.addAll(otherList);
		assertEquals(3, intList.getSize());
		assertEquals(2, intList.get(0).intValue());
		assertEquals(5, intList.get(1).intValue());
	}
	
	@Test
	public void addElementGetElement() {
		LinkedList<Integer> intList = new LinkedList<>();
		intList.add(15);
		assertEquals(1, intList.getSize());
		assertEquals(15, intList.get(0).intValue());
	}
	
	@Test
	public void addElementAtIndexGetElement() {
		LinkedList<Integer> intList = new LinkedList<>();
		intList.add(15);
		intList.add(25);
		intList.addAtIndex(1, 17);
		assertEquals(3, intList.getSize());
		assertEquals(17, intList.get(1).intValue());
	}
}
