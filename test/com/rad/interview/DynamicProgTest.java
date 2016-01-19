package com.rad.interview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DynamicProgTest {
	String s = "dabcba";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void lpsTest() {
		String expected = "abcba";
		String result = DynamicProg.longestPalindromicSubstring(s);
		System.out.println(result);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void editDistanceTest() {
		String s1 = "abcba";
		String s2 = "abdfa";
		int result = DynamicProg.editDistance(s1, s2);
		assertEquals(2, result);
	}

	@Test
	public void canReachEndTest() {
		int[] jumps = { 2, 3, 1, 1, 4 };
		boolean result = DynamicProg.canReachEnd(jumps);
		assertEquals(true, result);

		int[] jumps2 = { 3, 2, 1, 0, 4 };
		boolean result2 = DynamicProg.canReachEnd(jumps2);
		assertEquals(false, result2);
	}

	@Test
	public void minJumpsTest() {
		int[] jumps = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int result = DynamicProg.minJumps(jumps);
		assertEquals(3, result);
	}
	
	/**
	 * Palindrome Partitioning
	 */
	@Test
	public void minCutTest() {
		String s = "ababbbabbababa";
		int result = DynamicProg.palindromePartition(s);
		assertEquals(3, result);
	}

}
