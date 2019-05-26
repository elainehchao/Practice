package com.prep.Trees;

import com.prep.Trees.Node.BinaryTreeNode;

public class BinarySearchTree extends BinaryTree{
	
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(Integer initialValue) {
		super(initialValue);
	}

	@Override
	public boolean containsValue(Integer value) {
		
		return false;
	}
	
	public boolean containsValueHelper(Integer value, BinaryTreeNode current) {
		if (current == null) {
			return false;
		}
		
		if (current.getValue() == value) {
			return true;
		}
		
		if (current.getValue() < value) {
			return containsValueHelper(value, current.getRight());
		}
		
		if (current.getValue() > value) {
			return containsValueHelper(value, current.getLeft());
		}
		return false;
	}

	@Override
	public void insertValue(Integer element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeValue(Integer element) {
		// TODO Auto-generated method stub
		
	}

}
