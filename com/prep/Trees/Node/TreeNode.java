package com.prep.Trees.Node;

public class TreeNode<T> {
	private T value;
	
	public TreeNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
