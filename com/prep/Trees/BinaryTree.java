package com.prep.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

import com.prep.Trees.Node.BinaryTreeNode;

/**
 * Basic binary tree that assumes elements are unique and enforces no ordering
 * @author elainechao
 */
public class BinaryTree<T> {
	
	private BinaryTreeNode<T> root;
	
	public BinaryTree() {
		super();
	}
	
	public BinaryTree(T initialValue) {
		super();
		root = new BinaryTreeNode<T>(initialValue);
	}
	
	// left, parent, right
	public  void inOrderTraversal() {
		inOrderTraversalHelper(root);
	}
	
	private void inOrderTraversalHelper(BinaryTreeNode<T> current) {
		if (current ==  null) {
			return;
		}
		
		inOrderTraversalHelper(current.getLeft());
		
		System.out.println(current.getValue());
		
		inOrderTraversalHelper(current.getRight());
	}
	
	// parent, left, right
	public void preOrderTraversal() {
		preOrderTraversalHelper(root, new Predicate<BinaryTreeNode<T>>() {
			public boolean test(BinaryTreeNode<T> current) {
				System.out.println(current.getValue());
				return true;
			}
		});
	}
	
	private void preOrderTraversalHelper(BinaryTreeNode<T> current, Predicate<BinaryTreeNode<T>> predicate) {
		if (current == null) {
			return;
		}
		
		predicate.test(current);
		
		preOrderTraversalHelper(current.getLeft(), predicate);
		
		preOrderTraversalHelper(current.getRight(), predicate);
	}
	
	// left, right, parent
	public void postOrderTraversal() {
		postOrderTraversalHelper(root);
	}
	
	private void postOrderTraversalHelper(BinaryTreeNode<T> current) {
		if (current == null) {
			return;
		}
		
		postOrderTraversalHelper(current.getLeft());
		
		postOrderTraversalHelper(current.getRight());
		
		System.out.println(current.getValue());
	}
	
	public boolean containsValue(T value) {
		return containsValueHelper(value, root);
	}
	
	private boolean containsValueHelper(T value, BinaryTreeNode<T> current) {
		if (current == null) {
			return false;
		}
		
		if (current.getValue() == value) {
			return true;
		}
		
		return containsValueHelper(value, current.getLeft()) || containsValueHelper(value, current.getRight());
	}

	
	public void insertValue(T element) {
		if (root == null) {
			root = new BinaryTreeNode<T>(element);
		} else {
			insertValue(element, root);
		}
	}
	
	// BFS
	private void insertValue(T element, BinaryTreeNode<T> current) {
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(current);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> node = queue.poll();
			if (node.getLeft() == null) {
				BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(element);
				node.setLeft(newNode);
				break;
			}  else {
				queue.add(node.getLeft());
			}
			
			if (node.getRight() == null) {
				BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(element);
				node.setRight(newNode);
				break;
			} else {
				queue.add(node.getRight());
			}
		}
	}
	
	public void removeValue(T element) {
		if (root == null) {
			return;
		}
		
		if (root.getValue() == element && root.getRight() == null && root.getLeft() == null) {
			root = null;
		} else {
			BinaryTreeNode<T> bottomRightMostParent = findBottomRightMostParent(root);
			if (removeValue(element, root, bottomRightMostParent.getRight() == null ? 
					bottomRightMostParent.getLeft() : bottomRightMostParent.getRight())) {
				// remove bottomRightMost
				if (bottomRightMostParent.getRight() != null) {
					bottomRightMostParent.setRight(null);
				} else {
					bottomRightMostParent.setLeft(null);
				}
			}
		}
	}
	
	/* Find node with value, remove
	 * 
	 * if node is the bottom right most, just remove. Otherwise, replace the deleted node
	 * with the bottom rightmost node
	 */
	private boolean removeValue(T element, BinaryTreeNode<T> current, 
			BinaryTreeNode<T> bottomRightMost) {
		if (current == null) {
			return false;
		}
		
		if (current.getValue() == element) {
			current.setValue(bottomRightMost.getValue());
			return true;
		}
		
		return removeValue(element, current.getRight(), bottomRightMost) || 
				removeValue(element, current.getLeft(), bottomRightMost);
	}
	
	private BinaryTreeNode<T> findBottomRightMostParent(BinaryTreeNode<T> current) {
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(current);
		BinaryTreeNode<T> popped = null;
		BinaryTreeNode<T> poppedParent = null;
		while (!queue.isEmpty()) {
			popped = queue.poll();
			if (popped.getLeft() != null) {
				queue.add(popped.getLeft());
				poppedParent = popped;
			}
			
			if (popped.getRight() != null) {
				queue.add(popped.getRight());
				poppedParent = popped;
			}
		}
		return poppedParent;
	}

}
