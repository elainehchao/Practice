package com.prep.LinkedList;

import java.lang.reflect.Array;

public class LinkedList<T> {
	
	private int size;
	
	private Node<T> head;
		
	public LinkedList() {
		super();
		head = new Node<T>(null);
	}

	// O(1) space and time
	public int getSize() {
		return size;
	}
	
	// O(n) time
	public void add(T element) {
		Node<T> added = new Node<T>(element);
		Node<T> current = getLastNode();
		current.setNext(added);
		size++;
	}
	
	// O(n) time
	public void addAtIndex(int index, T element) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		current.setNext(new Node<T>(element));
		size++;
	}
	
	// O(n) time
	public T get(int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Invalid index");
		}
		Node<T> current = head.getNext();
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getValue();
	}
	
	// O(n) time
	public Node<T> getNode(int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Invalid index");
		}
		Node<T> current = head.getNext();
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}
	
	// O(n) time
	public void remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Invalid index");
		}
		
		Node<T> prev = head;
		Node<T> current = head.getNext();
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		prev.setNext(current.getNext());
		size--;
	}
	
	// O(n + m) time
	public void addAll(LinkedList<T> otherList) {
		Node<T> current = getLastNode();
		Node<T> otherIter = otherList.getNode(0);
		while (otherIter != null) {
			Node<T> newNode = new Node<T>(otherIter.getValue());
			current.setNext(newNode);
			current = current.getNext();
			otherIter = otherIter.getNext();
			size++;
		}
	}
	
	// O(1) time
	public void clear() {
		head.setNext(null);
		size = 0;
	}
	
	// O(n) time
	public T[] toArray(T[] inputArr) {
		T[] arr = inputArr;
		if (inputArr.length < size) {
			arr = (T[]) Array.newInstance(inputArr.getClass().getComponentType(), size);
		}
		Node<T> current = head.getNext();
		int count = 0;
		while (current != null) {
			arr[count] = current.getValue();
			count++;
			current = current.getNext();
		}
		return arr;
	}
	
	public void printList() {
		Node<T> current = head.getNext();
		System.out.print("[");
		while(current != null) {
			System.out.print(current.getValue());
			
			if (current.getNext() != null) {
				System.out.print(",");
			}
			current = current.getNext();
		}
		System.out.print("]");
		System.out.println();
	}
	
	// O(n) time, n = size
	private Node<T> getLastNode() {
		Node<T> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}
}
