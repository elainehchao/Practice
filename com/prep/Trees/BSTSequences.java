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
		List<List<Integer>> sequencesLeft = new ArrayList<>();
		getBSTSequences(root.getLeft(), 0, sequencesLeft);
		for (List<Integer> sequence : sequencesLeft) {
			sequence.stream().forEach(num -> System.out.print(num + " "));
			System.out.println();
		}
		
		List<List<Integer>> sequencesRight = new ArrayList<>();
		getBSTSequences(root.getRight(), 0, sequencesRight);
		for (List<Integer> sequence : sequencesRight) {
			sequence.stream().forEach(num -> System.out.print(num + " "));
			System.out.println();
		}
		
		List<List<Integer>> results = new ArrayList<>();
		for (List<Integer> left : sequencesLeft) {
			for (List<Integer> right : sequencesRight) {
				weave(left, right, new ArrayList<Integer>(), results);
			}
		}
		
		System.out.println();
		System.out.println("Results:");
		for (List<Integer> result : results) {
			result.stream().forEach(num -> System.out.print(num + " "));
			System.out.println();
		}
	}
	
	private static void getBSTSequences(BinaryTreeNode root, int offset, List<List<Integer>> sequences) {
		if (root == null) {
			return;
		}
		
		if (offset == 0) {
			List<Integer> initial = new ArrayList<>();
			initial.add(root.getValue());
			sequences.add(initial);
		} else {
			int size = sequences.size();
			for (int i = 0; i < size; i++) {
				int index = offset;
				List<Integer> list = sequences.get(i);
				while (index < list.size()) {
					sequences.add(copyAndAdd(list, index, root.getValue()));
					index++;
				}
				list.add(root.getValue());
			}
		}
		getBSTSequences(root.getLeft(), offset + 1, sequences);
		getBSTSequences(root.getRight(), offset + 1, sequences);
	}
	
	private static List<Integer> copyAndAdd(List<Integer> original, int index, int toAdd) {
		List<Integer> newList = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < original.size() + 1; i++) {
			if (i == index) {
				newList.add(toAdd);
			} else {
				newList.add(original.get(j));
				j++;
			}
		}
		return newList;
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
