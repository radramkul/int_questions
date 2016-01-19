package com.rad.interview;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Expected [3, 2, 5, 1, 8]
	@Test
	public void preOrdertest() {
		TreeNode root = BinaryTree.createBinaryTree();
		ArrayList<Integer> result = BinaryTree.preOrder(root);
		System.out.println(result);
	}
	
	@Test
	public void inOrdertest() {
		TreeNode root = BinaryTree.createBinaryTree();
		ArrayList<Integer> result = BinaryTree.inOrder(root);
		System.out.println(result);
	}

}
