package com.rad.interview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchSortTest {
	int[] sortedArray = { 1, 2, 4, 7, 15 };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void binarySearchTest() {
		assertEquals(1, SearchSort.binarySearch(sortedArray, 0, sortedArray.length - 1, 2));
		assertEquals(-1, SearchSort.binarySearch(sortedArray, 0, sortedArray.length - 1, 9));
	}

	@Test
	public void insertionSortTest() {
		int[] unsorted1 = { 1, 2, 5, 3, 10, 6, 9, 8 };
		int[] unsorted2 = { 5, 4, 3, 2, 1 };

		int[] expected1 = { 1, 2, 3, 5, 6, 8, 9, 10 };
		int[] expected2 = { 1, 2, 3, 4, 5 };

		SearchSort.insertionSort(unsorted1);
		SearchSort.insertionSort(unsorted2);
		SearchSort.insertionSort(sortedArray);

		assertArrayEquals(expected1, unsorted1);
		assertArrayEquals(expected2, unsorted2);
		assertArrayEquals(sortedArray, sortedArray);

	}

	@Test
	public void quickSortTest() {
		int[] unsorted1 = { 1, 2, 5, 3, 10, 6, 9, 8 };
		int[] unsorted2 = { 5, 4, 3, 2, 1 };

		int[] expected1 = { 1, 2, 3, 5, 6, 8, 9, 10 };
		int[] expected2 = { 1, 2, 3, 4, 5 };

		SearchSort.quickSort(unsorted1);
		SearchSort.quickSort(unsorted2);
		SearchSort.quickSort(sortedArray);

		assertArrayEquals(expected1, unsorted1);
		assertArrayEquals(expected2, unsorted2);
		assertArrayEquals(sortedArray, sortedArray);

	}

	@Test
	public void mergeSortTest() {
		int[] unsorted1 = { 1, 2, 5, 3, 10, 6, 9, 8 };
		int[] unsorted2 = { 5, 4, 3, 2, 1 };

		int[] expected1 = { 1, 2, 3, 5, 6, 8, 9, 10 };
		int[] expected2 = { 1, 2, 3, 4, 5 };

		SearchSort.mergeSort(unsorted1);
		SearchSort.mergeSort(unsorted2);
		SearchSort.mergeSort(sortedArray);

		ArrayQuestions.printArray(unsorted1);
		ArrayQuestions.printArray(unsorted2);
		ArrayQuestions.printArray(sortedArray);

		assertArrayEquals(expected1, unsorted1);
		assertArrayEquals(expected2, unsorted2);
		assertArrayEquals(sortedArray, sortedArray);

	}

}
