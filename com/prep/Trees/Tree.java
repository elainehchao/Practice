package com.prep.Trees;

public interface Tree<Integer> {
	void inOrderTraversal();
	void preOrderTraversal();
	void postOrderTraversal();
	boolean containsValue(Integer value);
	void insertValue(Integer element);
	void removeValue(Integer element);
}
