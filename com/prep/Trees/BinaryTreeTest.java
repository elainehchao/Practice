package com.prep.Trees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinaryTreeTest {
	
	@Test
	public void testInOrderTraversal() {
		/*
		     5
		   10 30
		  7 
		 
		 */
		
		BinaryTree<Integer> tree = new BinaryTree<>(5);
		tree.insertValue(10);
		tree.insertValue(30);
		tree.insertValue(7);
		tree.inOrderTraversal();
	}
	
	@Test
	public void testPreOrderTraversal() {
		/*
		     5
		   10 30
		  7 
		 
		 */
		
		BinaryTree<Integer> tree = new BinaryTree<>(5);
		tree.insertValue(10);
		tree.insertValue(30);
		tree.insertValue(7);
		tree.preOrderTraversal();
	}
	
	@Test
	public void testPostOrderTraversal() {
		/*
		     5
		   10 30
		  7 
		 
		 */
		
		BinaryTree<Integer> tree = new BinaryTree<>(5);
		tree.insertValue(10);
		tree.insertValue(30);
		tree.insertValue(7);
		tree.postOrderTraversal();
	}

	@Test
	public void testContainsValue() {
		/*
		     5
		   10 30
		  7 
		 
		 */
		
		BinaryTree<Integer> tree = new BinaryTree<>(5);
		tree.insertValue(10);
		tree.insertValue(30);
		tree.insertValue(7);
		assertTrue(tree.containsValue(30));
		assertFalse(tree.containsValue(-4));
	}
	
	@Test
	public void testRemoveValue() {
		/*
			     5
			  10   30
			 7  15
	 
	 After removal:
	 
	 		  5
			15   30
		   7  
	 
		 */
		
		BinaryTree<Integer> tree = new BinaryTree<>(5);
		tree.insertValue(10);
		tree.insertValue(30);
		tree.insertValue(7);
		tree.insertValue(15);
		tree.removeValue(10);
		tree.preOrderTraversal(); // expect 5, 15, 7, 30
	}
}
