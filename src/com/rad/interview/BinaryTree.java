package com.rad.interview;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Example Tree
 *        3
 *      /   \
 *     2     1
 *    /       \
 *   5         8
 * */
public class BinaryTree {
	public static TreeNode createBinaryTree() {
		TreeNode root = new TreeNode(3);
		root.addLeft(2);
		root.addRight(1);
		root.addLeft(5);
		root.addRight(8);

		return root;
	}

	/**
	 * Add root in the beginning Add right node first then left
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> preOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> st1 = new Stack<>();

		st1.push(root);
		while (!st1.isEmpty()) {
			TreeNode n = st1.pop();
			result.add(n.val);
			if (n.right != null) {
				st1.push(n.right);
			}
			if (n.left != null) {
				st1.push(n.left);
			}
		}
		return result;
	}

	/**
	 * Pop only when you run out of nodes in the left Add to list only after you
	 * pop
	 * 
	 * @return
	 */
	public static ArrayList<Integer> inOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> st1 = new Stack<>();
		TreeNode n = root;
		while (!st1.isEmpty() || n != null) {
			if (n != null) {
				st1.push(n);
				n = n.left;
			} else {

				TreeNode t = st1.pop();
				if (t != null) {
					result.add(t.val);
					n = t.right;
				}
			}

		}
		return result;
	}

}
//TODO: 1. Write level order 2. Write post Order
//3. Validate BST - validate subtree and check min max value
// 4. Path Sum 2
//5. Write code construct tree from inOrder and preOrder/pre order
// 6. Write Code to get minimum depth 1. recursive 2. iterative (level order traversal)


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
