package com.prep.Trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.prep.Trees.Node.BinaryTreeNode;

public class ListOfDepths {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(12);
		root.setLeft(new BinaryTreeNode(15));
		root.setRight(new BinaryTreeNode(7));
		root.getLeft().setLeft(new BinaryTreeNode(3));
		root.getLeft().setRight(new BinaryTreeNode(13));
		root.getRight().setLeft(new BinaryTreeNode(16));
		root.getRight().setRight(new BinaryTreeNode(20));
		
		List<List<BinaryTreeNode>> lod = getLod(root);
		for (List<BinaryTreeNode> list : lod) {
			for (BinaryTreeNode node : list) {
				System.out.print(node.getValue() + ", ");
			}
			System.out.println();
		}
	}
	
	public static List<List<BinaryTreeNode>> getLod(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		
		List<List<BinaryTreeNode>> lod = new ArrayList<>();
		List<BinaryTreeNode> list = new ArrayList<>();
		list.add(root);
		lod.add(list);
		
//		ListIterator<List<BinaryTreeNode>> iter = lod.listIterator();
//		while (iter.hasNext()) {
		for (int i = 0; i < lod.size(); i++) {
			List<BinaryTreeNode> newList = new ArrayList<>();
			List<BinaryTreeNode> nextList = lod.get(i);
			for (BinaryTreeNode node : nextList) {
				if (node.getLeft() != null) {
					newList.add(node.getLeft());
				}
				
				if (node.getRight() != null) {
					newList.add(node.getRight());
				}
			}
			
			if (!newList.isEmpty()) {
				lod.add(newList);
			}
		}
		return lod;
	}

}
