package com.prep.Trees.Node;

public class BinaryTreeNode<T> extends TreeNode<T> {

	private BinaryTreeNode<T> left;
	
	private BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T value) {
		super(value);
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

}
