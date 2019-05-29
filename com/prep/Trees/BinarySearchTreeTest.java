package com.prep.Trees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTreeTest {
	
	@Test
	public void testBSTInsert() {
		
		/*
		 *          10
		 *        4    20
		 *       2       65 
		 */
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertValue(10);
		tree.insertValue(4);
		tree.insertValue(20);
		tree.insertValue(65);
		tree.insertValue(2);
		System.out.println("PREORDER");
		tree.preOrderTraversal();
		System.out.println("");
		System.out.println("POSTORDER");
		tree.postOrderTraversal();
		System.out.println("");
		System.out.println("INORDER");
		tree.inOrderTraversal();
	}
	
	@Test
	public void testBSTContains() {
		
		/*
		 *          10
		 *        4    20
		 *       2       65 
		 */
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertValue(10);
		tree.insertValue(4);
		tree.insertValue(20);
		tree.insertValue(65);
		tree.insertValue(2);
		assertTrue(tree.containsValue(2));
		assertFalse(tree.containsValue(100));
	}

}
