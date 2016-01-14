package com.rad.interview;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	int[] num1 = { 2, 4, 3 };
	int[] num2 = { 5, 6, 4, 5 };
	int[] num3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int[] sorted1 = { 1, 2, 3, 4, 5, 6, 7, 15, 20 };
	int[] sorted2 = { 0, 10, 13, 14, 15, 16, 17, 18, 19 };
	int[] sorted3 = { -11, -2, 13, 14, 25, 36, 47, 58, 79 };
	int[] sorted4 = { 21, 22, 23, 24, 25, 46, 47, 48, 49 };
	int[] dup1 = { 1, 1, 2 };
	int[] dup2 = { 1, 2, 2, 2, 3 };
	int[] dup3 = { 1, 1, 2, 3, 3 };
	int[] empty = {};
	int[] one = {1};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createAddTest() {
		int[] arr = { 1, 2, 4, 3 };
		System.out.println("Creating");
		LinkedNode root = LinkedListQuestions.createLinkedList(arr);
		LinkedListQuestions.printList(root);
		LinkedListQuestions.addNode(5, root);
		System.out.println("Adding 5");
		LinkedListQuestions.printList(root);
	}

	@Test
	public void addNumbersTest() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(num1);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(num2);
		LinkedNode root3 = LinkedListQuestions.addNumbers(root1, root2);
		LinkedListQuestions.printList(root3);
		int[] num3 = { 2, 4, 6 };
		int[] num4 = { 5, 6, 9, 1 };
		root1 = LinkedListQuestions.createLinkedList(num3);
		root2 = LinkedListQuestions.createLinkedList(num4);
		root3 = LinkedListQuestions.addNumbers(root1, root2);
		LinkedListQuestions.printList(root3);

	}

	@Test
	public void findMiddleTest() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(num1);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(num2);
		LinkedNode mid1 = LinkedListQuestions.findMiddleNode(root1);
		LinkedNode mid2 = LinkedListQuestions.findMiddleNode(root2);
		assertEquals(4, mid1.number);
		assertEquals(4, mid2.number);

	}

	@Test
	public void reverseTest() {

		LinkedNode root1 = LinkedListQuestions.createLinkedList(num1);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(num2);

		LinkedListQuestions.printList(root1);
		root1 = LinkedListQuestions.reverseList(root1);
		LinkedListQuestions.printList(root1);

		LinkedListQuestions.printList(root2);
		root2 = LinkedListQuestions.reverseList(root2);
		LinkedListQuestions.printList(root2);

	}

	@Test
	public void reOrderTest() {
		LinkedNode root = LinkedListQuestions.createLinkedList(num3);
		root = LinkedListQuestions.reorderList(root);
		LinkedListQuestions.printList(root);

	}

	@Test
	public void merge2Test() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(sorted1);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(sorted2);
		LinkedNode root = LinkedListQuestions.mergeTwoSortedLists(root1, root2);
		LinkedListQuestions.printList(root);

	}

	@Test
	public void mergekTest() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(sorted1);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(sorted2);
		LinkedNode root3 = LinkedListQuestions.createLinkedList(sorted3);
		LinkedNode root4 = LinkedListQuestions.createLinkedList(sorted4);
		List<LinkedNode> list = new ArrayList<>();
		list.add(root1);
		list.add(root2);
		list.add(root3);
		list.add(root4);
		LinkedNode root = LinkedListQuestions.mergeKSortedLists(list);
		LinkedListQuestions.printList(root);

	}

	@Test
	public void removeDupAllTest() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(dup1);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(dup2);
		LinkedNode root3 = LinkedListQuestions.createLinkedList(dup3);
		root1 = LinkedListQuestions.removeDupAll(root1);
		root2 = LinkedListQuestions.removeDupAll(root2);
		root3 = LinkedListQuestions.removeDupAll(root3);
		LinkedListQuestions.printList(root1);
		LinkedListQuestions.printList(root2);
		LinkedListQuestions.printList(root3);

	}

	@Test
	public void removeNumberTest() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(dup1);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(dup2);
		LinkedListQuestions.printList(root1);
		LinkedListQuestions.printList(root2);
		root1 = LinkedListQuestions.deleteNode(1, root1);
		root2 = LinkedListQuestions.deleteNode(2, root2);
		LinkedListQuestions.printList(root1);
		LinkedListQuestions.printList(root2);
	}
	
	@Test
	public void reverseTestIterative(){
		LinkedNode root1 = LinkedListQuestions.createLinkedList(one);
		LinkedNode root2 = LinkedListQuestions.createLinkedList(dup1);
		LinkedNode root3 = LinkedListQuestions.createLinkedList(num2);
		LinkedListQuestions.printList(root1);
		LinkedListQuestions.printList(root2);
		LinkedListQuestions.printList(root3);
		root1 = LinkedListQuestions.reverseListIterative(root1);
		root2 = LinkedListQuestions.reverseListIterative(root2);
		root3 = LinkedListQuestions.reverseListIterative(root3);
		LinkedListQuestions.printList(root1);
		LinkedListQuestions.printList(root2);
		LinkedListQuestions.printList(root3);
		
	}
	
	@Test
	public void deleteNthNodeTest() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(num3);
		LinkedListQuestions.printList(root1);
		LinkedListQuestions.findNthNode(root1, 3);
		LinkedListQuestions.printList(root1);
	}
	
	@Test
	public void swapPairsTest() {
		LinkedNode root1 = LinkedListQuestions.createLinkedList(num3);
		LinkedListQuestions.printList(root1);
		LinkedNode root = LinkedListQuestions.swapInPairs(root1);
		LinkedListQuestions.printList(root);
		
		root1 = LinkedListQuestions.createLinkedList(new int[]{1,2});
		LinkedListQuestions.printList(root1);
		root = LinkedListQuestions.swapInPairs(root1);
		LinkedListQuestions.printList(root);
	}
	

}
