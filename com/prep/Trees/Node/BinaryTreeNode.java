package com.prep.Trees.Node;

public class BinaryTreeNode extends TreeNode {

	private BinaryTreeNode left;
	
	private BinaryTreeNode right;
	
	public BinaryTreeNode(Integer value) {
		super(value);
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

}
