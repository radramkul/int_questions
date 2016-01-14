package com.rad.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LinkedListQuestions {

	static LinkedNode createLinkedList(int[] array) {
		LinkedNode root = null;
		for (int val : array) {
			root = addNode(val, root);
		}
		return root;
	}

	static void printList(LinkedNode root) {
		if (root == null) {
			return;
		}
		LinkedNode counter = root;
		while (counter != null) {
			System.out.print(counter.number + " ");
			counter = counter.next;
		}
		System.out.println();

	}

	public static LinkedNode addNode(int val, LinkedNode root) {
		if (root == null) {
			root = new LinkedNode(val);
			return root;
		}
		LinkedNode node = new LinkedNode(val);
		LinkedNode start = root;
		while (start.next != null) {
			start = start.next;
		}
		start.next = node;
		return root;

	}

	/**
	 * 
	 * @param root1
	 * @param root2
	 * @return node of result with digits reversed
	 * 
	 *         If the digits are not reversed then we reverse both lists first,
	 *         add then and reverse the result
	 */
	static LinkedNode addNumbers(LinkedNode root1, LinkedNode root2) {
		if (root1 == null || root2 == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode start = new LinkedNode(0);
		LinkedNode root = start;
		int sum = 0;
		int carry = 0;
		while (root1 != null && root2 != null) {
			int c1 = root1.number;
			int c2 = root2.number;
			sum = (c1 + c2 + carry) % 10;
			carry = (c1 + c2 + carry) / 10;
			root.next = new LinkedNode(sum);
			root1 = root1.next;
			root2 = root2.next;
			root = root.next;
		}
		if (root1 == null) {
			while (root2 != null) {
				sum = (carry + root2.number) % 10;
				carry = (carry + root2.number) / 10;
				root.next = new LinkedNode(sum);
				root2 = root2.next;
				root = root.next;
			}
		}

		if (root2 == null) {
			while (root1 != null) {
				sum = (carry + root1.number) % 10;
				carry = (carry + root1.number) / 10;
				root.next = new LinkedNode(sum);
				root1 = root1.next;
				root = root.next;
			}

			if (carry > 0) {
				root.next = new LinkedNode(carry);
			}
		}

		return start.next;

	}

	static LinkedNode reorderList(LinkedNode root) {
		if (root == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode middle = findMiddleNode(root);
		LinkedNode newMid = reverseList(middle);
		mergeLists(root, newMid);
		return root;

	}

	public static void mergeLists(LinkedNode root1, LinkedNode root2) {
		// root1 comes before root2
		if (root1 == null || root2 == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode cur1 = root1;
		LinkedNode cur2 = root2;
		while (cur1 != null && cur2 != null) {
			LinkedNode next1 = cur1.next;
			LinkedNode next2 = cur2.next;

			cur1.next = cur2;
			cur2.next = next1;

			cur1 = next1;
			cur2 = next2;
		}

	}

	/**
	 * 
	 * @param middle
	 * @return
	 */
	public static LinkedNode reverseList(LinkedNode root) {
		if (root == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode prev = null;
		LinkedNode next = root;
		LinkedNode cur = root;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}

	public static LinkedNode findMiddleNode(LinkedNode root) {
		LinkedNode fast = root;
		LinkedNode slow = root;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			}
		}
		return slow;
	}

	/**
	 * Accepted by Leetcode
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isCycle(LinkedNode root) {
		if (root == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode fast = root;
		LinkedNode slow = root;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			}
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}

	public static LinkedNode mergeTwoSortedLists(LinkedNode root1, LinkedNode root2) {
		if (root1 == null || root2 == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode dummy = new LinkedNode(Integer.MIN_VALUE);
		LinkedNode head = dummy;
		while (root1 != null && root2 != null) {
			if (root1.number < root2.number) {
				dummy.next = root1;
				root1 = root1.next;
			} else {
				dummy.next = root2;
				root2 = root2.next;

			}
			dummy = dummy.next;
		}
		if (root1 == null) {
			dummy.next = root2;
		} else {
			dummy.next = root1;
		}
		return head.next;
	}

	public static LinkedNode mergeKSortedLists(List<LinkedNode> list) {
		if (list == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode head = new LinkedNode(0);
		LinkedNode cur = head;

		PriorityQueue<LinkedNode> q = new PriorityQueue<>(list.size(), new Comparator<LinkedNode>() {
			public int compare(LinkedNode a, LinkedNode b) {
				if (a.number > b.number) {
					return 1;
				} else if (a.number == b.number) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		for (LinkedNode node : list) {
			if (node != null) {
				q.add(node);
			}
		}
		while (q.size() > 0) {
			LinkedNode node = q.poll();
			cur.next = node;
			if (node.next != null) {
				q.add(node.next);
			}
			cur = cur.next;
		}
		return head.next;
	}

	/*
	 * TODO: 1. Write Remove Duplicates from sorted List 1
	 * 
	 * 2. 2. Intersection of 2 lists: find common node: FInd lengths, find diff
	 * larger list: go ahead by diff nodes Traverse both lists together till you
	 * find a common node
	 * 
	 * 3. Reverse List from position m to N : IMP
	 * 
	 * 4. Partition List - Use dummy node, preserve original order
	 * 
	 * 5. Check notebook
	 * 
	 */

	public static LinkedNode removeDupAll(LinkedNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkedNode fake = new LinkedNode(0);
		fake.next = head;
		LinkedNode prev = fake;
		LinkedNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.number == cur.next.number) {
				int val = cur.number;
				while (cur != null && cur.number == val) {
					cur = cur.next;
				}
				prev.next = cur;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}

		return fake.next;

	}

	public static LinkedNode deleteNode(int val, LinkedNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkedNode dummy = new LinkedNode(0);
		dummy.next = head;
		LinkedNode prev = dummy;
		LinkedNode cur = head;
		while (cur != null) {
			if (cur.number == val) {
				prev.next = cur.next;
				cur = cur.next;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	public static LinkedNode reverseListIterative(LinkedNode head) {
		if (head == null) {
			throw new IllegalArgumentException();
		}

		LinkedNode prev = null;
		LinkedNode cur = head;
		while (cur != null) {
			LinkedNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}

	public static void findNthNode(LinkedNode head, int n) {
		if (head == null || n < 1) {
			throw new IllegalArgumentException();
		}

		LinkedNode fast = head;
		LinkedNode slow = head;
		for (int i = 0; i < n; i++) {
			if (fast != null) {
				fast = fast.next;
			}
		}
		if (fast == null) {
			return;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
	}

	public static LinkedNode swapInPairs(LinkedNode head) {
		if (head == null) {
			throw new IllegalArgumentException();
		}
		LinkedNode dummy = new LinkedNode(0);
		dummy.next = head;

		LinkedNode prev = dummy;
		LinkedNode cur = head;
		LinkedNode next = head.next;

		while (cur != null && next != null) {
			prev.next = next;
			cur.next = next.next;
			next.next = cur;

			prev = prev.next.next;
			if (prev != null) {
				cur = prev.next;
			}
			if (cur != null) {
				next = cur.next;
			}

		}

		return dummy.next;

	}

	/**
	 * Maintain hashMap to original node to copied node Copy next pointers first
	 * Copy random pointers later
	 * 
	 * @param head
	 * @return
	 */
	public static RandomLinkNode copyWithRandomPointer(RandomLinkNode head) {
		if (head == null) {
			throw new IllegalArgumentException();
		}
		HashMap<RandomLinkNode, RandomLinkNode> hm = new HashMap<>();
		RandomLinkNode newHead = new RandomLinkNode(head.number);
		hm.put(head, newHead);
		RandomLinkNode p = head;
		RandomLinkNode q = newHead;
		
		//Copy next pointers
		while (p != null && p.next != null) {
			p = p.next;
			RandomLinkNode t = new RandomLinkNode(p.number);
			hm.put(p, t);
			q.next = t;
			q = q.next;
		}
		
		//Random pointers
		p = head;
		q = newHead;
		while(p !=null){
			if(p.random != null){
				q.random = hm.get(p.random);
			}
			else{
				q.random = null;
			}
			p= p.next;
			q= q.next;
		}
        return newHead;
	}
}

class LinkedNode {
	int number;
	LinkedNode next;

	LinkedNode(int number) {
		this.number = number;
	}

	public LinkedNode() {
	}
}

class RandomLinkNode {
	int number;
	RandomLinkNode next;
	RandomLinkNode random;

	RandomLinkNode(int number) {
		this.number = number;
	}

	public RandomLinkNode() {
	}
}
