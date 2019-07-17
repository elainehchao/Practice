package com.prep.Trees;

import java.util.ArrayList;
import java.util.List;

import com.prep.Trees.Node.BinaryTreeNode;

public class BSTSequences {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.setLeft(new BinaryTreeNode(8));
		root.setRight(new BinaryTreeNode(12));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(9));
		root.getRight().setLeft(new BinaryTreeNode(11));
		List<List<Integer>> results = getBSTSequences(root);
		
		System.out.println();
		System.out.println("Results:");
		for (List<Integer> result : results) {
			result.stream().forEach(num -> System.out.print(num + " "));
			System.out.println();
		}
	}
	
	private static List<List<Integer>>  getBSTSequences(BinaryTreeNode root) {
		List<List<Integer>> finalResults = new ArrayList<List<Integer>>();
		if (root == null) {
			finalResults.add(new ArrayList<>());
			return finalResults;
		}
		
		List<Integer> prefix = new ArrayList<>();
		prefix.add(root.getValue());
		
		List<List<Integer>> sequencesLeft = getBSTSequences(root.getLeft());
		
		List<List<Integer>> sequencesRight = getBSTSequences(root.getRight());
		
		List<List<Integer>> results = new ArrayList<>();
		for (List<Integer> left : sequencesLeft) {
			for (List<Integer> right : sequencesRight) {
				weave(left, right, prefix, results);
			}
		}
		finalResults.addAll(results);

		return finalResults;
	}
	
	private static void weave(List<Integer> first, List<Integer> second, List<Integer> prefix, List<List<Integer>> results) {
		if (first.size() == 0 || second.size() == 0) {
			List<Integer> list = new ArrayList<>();
			list.addAll(prefix);
			list.addAll(first);
			list.addAll(second);
			results.add(list);
			return;
		}
		
		int num = first.get(0);
		first.remove(0);
		prefix.add(num);
		weave(first, second, prefix, results);
		prefix.remove(prefix.size() - 1);
		first.add(0, num);
		
		num = second.get(0);
		second.remove(0);
		prefix.add(num);
		weave(first, second, prefix, results);
		prefix.remove(prefix.size() - 1);
		second.add(0, num);
	}

}
