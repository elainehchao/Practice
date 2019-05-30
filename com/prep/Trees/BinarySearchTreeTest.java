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
	
	@Test
	public void testRemoveValueRightChildNull() {
		/*
		 *          10
		 *        4    20
		 *       2       65 
		 *        3
		 */
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertValue(10);
		tree.insertValue(4);
		tree.insertValue(20);
		tree.insertValue(65);
		tree.insertValue(2);
		tree.insertValue(3);
		tree.removeValue(4);
		
		/*
		 *          10
		 *        2    20
		 *         3     65 
		 *        
		 */
		System.out.println("PREORDER");
		tree.preOrderTraversal();
		System.out.println("INORDER");
		tree.inOrderTraversal();
	}
	
	@Test
	public void testRemoveValueLeftChildNull() {
		/*
		 *          10
		 *        4    20
		 *       2       65 
		 *        3
		 */
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertValue(10);
		tree.insertValue(4);
		tree.insertValue(20);
		tree.insertValue(65);
		tree.insertValue(2);
		tree.insertValue(3);
		tree.removeValue(20);
		
		/*
		 *          10
		 *        4    65
		 *       2        
		 *        3
		 */
		System.out.println("PREORDER");
		tree.preOrderTraversal();
		System.out.println("INORDER");
		tree.inOrderTraversal();
	}
	
	@Test
	public void testRemoveValueBothChildrenNotNull() {
		/*
		 *          10
		 *       4     20
		 *      2    15   65 
		 *       3
		 */
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertValue(10);
		tree.insertValue(4);
		tree.insertValue(20);
		tree.insertValue(15);
		tree.insertValue(65);
		tree.insertValue(2);
		tree.insertValue(3);
		tree.removeValue(20);
		
		/*
		 *          10
		 *        4    65
		 *       2    15    
		 *        3
		 */
		System.out.println("PREORDER");
		tree.preOrderTraversal();
		System.out.println("INORDER");
		tree.inOrderTraversal();
	}
	
	@Test
	public void testRemoveRoot() {
		/*
		 *          10
		 *       4     20
		 *      2    15   65 
		 *       3
		 */
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertValue(10);
		tree.insertValue(4);
		tree.insertValue(20);
		tree.insertValue(15);
		tree.insertValue(65);
		tree.insertValue(2);
		tree.insertValue(3);
		tree.removeValue(10);
		
		/*
		 *          15
		 *        4    20
		 *       2       65 
		 *        3
		 */
		System.out.println("PREORDER");
		tree.preOrderTraversal();
		System.out.println("INORDER");
		tree.inOrderTraversal();
	}

}
