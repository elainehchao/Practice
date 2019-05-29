package com.prep.Trees;

import com.prep.Trees.Node.BinaryTreeNode;

/**
 * Non balancing BST
 * @author elainechao
 *
 */
public class BinarySearchTree extends BinaryTree{
	
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(Integer initialValue) {
		super(initialValue);
	}

	@Override
	public boolean containsValue(Integer value) {
		return containsValueHelper(value, root);
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
		if (root == null) {
			root = new BinaryTreeNode(element);
		} else {
			insertValueHelper(element, root);
		}
	}

	private void insertValueHelper(Integer value, BinaryTreeNode current) {		
		if (current.getValue() < value) {
			if (current.getRight() == null) {
				BinaryTreeNode newNode = new BinaryTreeNode(value);
				current.setRight(newNode);
			} else {
				insertValueHelper(value, current.getRight());
			}
		} else if (current.getValue() > value) {
			if (current.getLeft() == null) {
				BinaryTreeNode newNode = new BinaryTreeNode(value);
				current.setLeft(newNode);
			} else {
				insertValueHelper(value, current.getLeft());
			}
		}
	}
	
	@Override
	public void removeValue(Integer element) {
		// TODO Auto-generated method stub
		
	}

}
