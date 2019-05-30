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
	
	// O(n) because unbalanced
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

	// O(n) because unbalanced
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
		removeValueHelper(element, null, root);
	}
	
	private void removeValueHelper(Integer element, BinaryTreeNode parent, BinaryTreeNode current) {
		if (current == null) {
			return;
		}
		
		if (current.getValue() == element) {
			if (current.getRight() != null && current.getLeft() != null) {
				// find smallest element in right subtree
				BinaryTreeNode smallest = findAndRemoveSmallest(current, current.getRight());
				current.setValue(smallest.getValue());
			} else if (current.getRight() == null){
				if (parent != null) {
					if (parent.getLeft() == current) {
						parent.setLeft(current.getLeft());
					} else if (parent.getRight() == current) {
						parent.setRight(current.getLeft());
					}
				} else {
					// root to be deleted
					root = current.getLeft();
				}
			} else if (current.getLeft() == null) {
				if (parent != null) {
					if (parent.getLeft() == current) {
						parent.setLeft(current.getRight());
					} else if (parent.getRight() == current) {
						parent.setRight(current.getRight());
					}
				} else {
					// root to be deleted
					root = current.getRight();
				}
			}
		}
		
		if (element < current.getValue()) {
			removeValueHelper(element, current, current.getLeft());
		}
		
		if (element > current.getValue()) {
			removeValueHelper(element, current, current.getRight());
		}
	}
	
	private BinaryTreeNode findAndRemoveSmallest(BinaryTreeNode originalParent, BinaryTreeNode current) {
		if (current.getLeft() == null) {
			BinaryTreeNode smallest = current;
			originalParent.setRight(current.getRight() == null ? null : current.getRight());
			return smallest;
		}
		
		
		if (current.getLeft() != null) {
			BinaryTreeNode smallest = current.getLeft();
			current.setLeft(current.getLeft().getRight() == null ? null : current.getLeft().getRight());
			return smallest;
		}
		
		return findAndRemoveSmallest(originalParent, current.getLeft());
	}

}
