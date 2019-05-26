package com.prep.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

import com.prep.Trees.Node.BinaryTreeNode;

/**
 * Basic binary tree that assumes elements are unique and enforces no ordering
 * @author elainechao
 */
public class BinaryTree implements Tree<Integer>{
	
	protected BinaryTreeNode root;
	
	public BinaryTree() {
		super();
	}
	
	public BinaryTree(Integer initialValue) {
		super();
		root = new BinaryTreeNode(initialValue);
	}
	
	// left, parent, right
	// O(2 ^ logn) = O(n)
	public  void inOrderTraversal() {
		inOrderTraversalHelper(root);
	}
	
	private void inOrderTraversalHelper(BinaryTreeNode current) {
		if (current ==  null) {
			return;
		}
		
		inOrderTraversalHelper(current.getLeft());
		
		System.out.println(current.getValue());
		
		inOrderTraversalHelper(current.getRight());
	}
	
	// parent, left, right
	// O(2 ^ logn) = O(n)
	public void preOrderTraversal() {
		preOrderTraversalHelper(root, new Predicate<BinaryTreeNode>() {
			public boolean test(BinaryTreeNode current) {
				System.out.println(current.getValue());
				return true;
			}
		});
	}
	
	private void preOrderTraversalHelper(BinaryTreeNode current, Predicate<BinaryTreeNode> predicate) {
		if (current == null) {
			return;
		}
		
		predicate.test(current);
		
		preOrderTraversalHelper(current.getLeft(), predicate);
		
		preOrderTraversalHelper(current.getRight(), predicate);
	}
	
	// left, right, parent
	// O(2 ^ logn) = O(n)
	public void postOrderTraversal() {
		postOrderTraversalHelper(root);
	}
	
	private void postOrderTraversalHelper(BinaryTreeNode current) {
		if (current == null) {
			return;
		}
		
		postOrderTraversalHelper(current.getLeft());
		
		postOrderTraversalHelper(current.getRight());
		
		System.out.println(current.getValue());
	}
	
	public boolean containsValue(Integer value) {
		return containsValueHelper(value, root);
	}
	
	// O(2 ^ logn) = O(n)
	private boolean containsValueHelper(Integer value, BinaryTreeNode current) {
		if (current == null) {
			return false;
		}
		
		if (current.getValue() == value) {
			return true;
		}
		
		return containsValueHelper(value, current.getLeft()) || containsValueHelper(value, current.getRight());
	}

	//O(n)
	public void insertValue(Integer element) {
		if (root == null) {
			root = new BinaryTreeNode(element);
		} else {
			insertValue(element, root);
		}
	}
	
	// BFS
	private void insertValue(Integer element, BinaryTreeNode current) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(current);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
			if (node.getLeft() == null) {
				BinaryTreeNode newNode = new BinaryTreeNode(element);
				node.setLeft(newNode);
				break;
			}  else {
				queue.add(node.getLeft());
			}
			
			if (node.getRight() == null) {
				BinaryTreeNode newNode = new BinaryTreeNode(element);
				node.setRight(newNode);
				break;
			} else {
				queue.add(node.getRight());
			}
		}
	}
	
	// O(n) + O(n)
	public void removeValue(Integer element) {
		if (root == null) {
			return;
		}
		
		if (root.getValue() == element && root.getRight() == null && root.getLeft() == null) {
			root = null;
		} else {
			BinaryTreeNode bottomRightMostParent = findBottomRightMostParent(root);
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
	private boolean removeValue(Integer element, BinaryTreeNode current, 
			BinaryTreeNode bottomRightMost) {
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
	
	// O(n)
	private BinaryTreeNode findBottomRightMostParent(BinaryTreeNode current) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(current);
		BinaryTreeNode popped = null;
		BinaryTreeNode poppedParent = null;
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
