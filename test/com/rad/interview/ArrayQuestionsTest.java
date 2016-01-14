package com.rad.interview;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayQuestionsTest {
	int[] oddArray = { 1, 2, 3, 4, 5 };
	int[] evenArray = { 1, 2, 3, 4 };
	int[] rotate = { 1, 2, 3, 4, 5, 6, 7, 8 };
	int[] arr;

	@Before
	public void setUp() throws Exception {
		arr = new int[] { 1, 2, 15, 6, 10, 12, 45, 9 };
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("Test running");
		ArrayQuestions.reverseArray(oddArray, 0, 4);
		int[] expected = { 5, 4, 3, 2, 1 };
		assertArrayEquals(expected, oddArray);
		oddArray = new int[] { 1, 2, 3, 4, 5 };
		ArrayQuestions.reverseArray(oddArray, 1, 3);
		expected = new int[] { 1, 4, 3, 2, 5 };
		assertArrayEquals(expected, oddArray);
		oddArray = new int[] { 1, 2, 3, 4, 5 };
		ArrayQuestions.reverseArray(oddArray, 2, 2);
		expected = new int[] { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, oddArray);
	}

	@Test
	public void rotateTest() {
		ArrayQuestions.arrayRotate(rotate, 3);
		int[] expected = { 6, 7, 8, 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, rotate);
		rotate = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		ArrayQuestions.arrayRotate(rotate, 3);
	}

	@Test
	public void evaluateExpressionTest() {
		String[] expr = { "2", "3", "*", "1", "/", "6", "-" };
		int result = ArrayQuestions.evaluateReversePolishExpr(expr);
		// Expected: 6/1 - 6 =0
		assertEquals(0, result);
	}

	@Test
	public void medianOfTwoSortedArraysTest() {
		int[] arr1 = { 1, 7, 100 };
		int[] arr2 = { 5, 6, 10 };
		float median = ArrayQuestions.medianOfTwoSortedArrays(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
		assertEquals(13, median, 0.01);
	}

	@Test
	public void medianOfTwoSortedArraysTest2() {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		float median = ArrayQuestions.medianOfTwoSortedArrays(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
		assertEquals(9, median, 0.01);
	}

	@Test
	public void testPartition() {
		int[] arr = { 1, 2, 5, 6, 10, 12, 45, 9 };
		int index = ArrayQuestions.partitionArray(arr, 0, arr.length - 1);
		assertEquals(4, index);
	}

	@Test
	public void testFindKth() {
		int[] arr = { 1, 2, 15, 6, 10, 12, 45, 9 };
		int element = ArrayQuestions.findKthElement(arr, 0, arr.length - 1, 4);
		assertEquals(9, element);
		arr = new int[] { 1, 2, 15, 6, 10, 12, 45, 9 };
		element = ArrayQuestions.findKthElement(arr, 0, arr.length - 1, 7);
		assertEquals(15, element);
		arr = new int[] { 1, 2, 15, 6, 10, 12, 45, 9 };
		element = ArrayQuestions.findKthElement(arr, 0, arr.length - 1, 1);
		assertEquals(1, element);
	}

	@Test
	public void twoSumTest() {
		int[] arr = new int[] { 1, 2, 3, 0, 4, 6 };
		int sum = 3;
		int[] result = ArrayQuestions.twoSum(arr, sum);
		for (int num : result) {
			System.out.println(num);

		}
		int[] expected = new int[] { 0, 1, 2, 3 };
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
		assertEquals(2, result[2]);
		assertEquals(3, result[3]);
	}

	@Test
	public void mergeTwoSortedArraysTest() {
		int[] A = new int[] { 1, 3, 5 };
		//Length 3
		int[] B = new int[] { 2, 4, 6, 7, 8, 9, 9, 9 };
		//Length 8
		int[] result = ArrayQuestions.mergeTwoSortedArrays(A, B, A.length, B.length-A.length);
		int[] expected = new int[]{1,2,3,4,5,6,7,8};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void removeDuplicatesFromSortedArrayTest(){
		int[] arr = {1,1,2,2,2,3,4,5};
		int[] newArrray = ArrayQuestions.removeDuplicatesFromSortedArray(arr);
		int[] expected = {1,2,3,4,5};
		assertArrayEquals(expected,newArrray);
		int[] arr2 = {1,2,3,4,5};
		int[] newArrray2 = ArrayQuestions.removeDuplicatesFromSortedArray(arr2);
		int[] expected2 = {1,2,3,4,5};
		assertArrayEquals(expected2,newArrray2);
	}
	
	@Test
	public void removeDuplicatesFromSortedArrayTest2(){
		/*int[] arr = {1,1,2,2,2,3,4,5};
		int[] ex1 = {1,1,2,2,3,4,5};
		int[] newArrray = ArrayQuestions.removeDuplicatesFromSortedArray2(arr);
		assertArrayEquals(ex1,newArrray);
		int[] arr2 = {1,2,3,4,5};
		int[] newArrray2 = ArrayQuestions.removeDuplicatesFromSortedArray2(arr2);
		assertArrayEquals(arr2,newArrray2);*/
		int[] arr3 = {1,1,1,2,2,2,3,3,4,5,5};
		int[] expected ={1,1,2,2,3,3,4,5,5};
		int[] newArrray3 = ArrayQuestions.removeDuplicatesFromSortedArray2(arr3);
		assertArrayEquals(expected,newArrray3);
	}


}
