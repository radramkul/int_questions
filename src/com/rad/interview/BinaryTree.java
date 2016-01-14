package com.rad.interview;

/*
 * Example Tree
 *        3
 *      /   \
 *     2     1
 *    /       \
 *   5         8
 * */
public class BinaryTree {
	private TreeNode createBinaryTree() {
		TreeNode root = new TreeNode(3);
		root.addLeft(2);
		root.addRight(1);
		root.addLeft(5);
		root.addRight(8);

		return root;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	void addLeft(int x) {
		TreeNode left = new TreeNode(x);
		if (this.left == null) {
			this.left = left;
		} else {
			this.left.addLeft(x);
		}
	}

	void addRight(int x) {
		TreeNode right = new TreeNode(x);
		if (this.right == null) {
			this.right = right;
		} else {
			this.right.addRight(x);
		}
	}
}
