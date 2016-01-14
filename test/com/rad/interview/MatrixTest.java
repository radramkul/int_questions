package com.rad.interview;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setZerosTest() {
		int[][] matrix = Matrix.matrix;
		Matrix.setZeros(matrix);
		Matrix.printMatrix(matrix);
		int[][] expected = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		assertArrayEquals(expected, matrix);
	}

	@Test
	public void spiralTest() {
		int[][] matrix = Matrix.spiral;
		List<Integer> result = Matrix.spiral(matrix);
		List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8);
		assertEquals(expected, result);
	}

	@Test
	public void generateSpiralTest() {
		int[][] result = Matrix.generateSpiral(2);
		Matrix.printMatrix(result);
		System.out.println();
		result = Matrix.generateSpiral(3);
		Matrix.printMatrix(result);
		System.out.println();
		result = Matrix.generateSpiral(4);
		Matrix.printMatrix(result);
	}

	@Test
	public void numberOfIslandsTest() {
		int[][] matrix = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 1, 0 } };
		int count = Matrix.numberOfIslands(matrix);
		assertEquals(2, count);
		int[][] matrix2 = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 1, 1, 0 } };
		count = Matrix.numberOfIslands(matrix2);
		assertEquals(1, count);
	}

	@Test
	public void surroundedRegionsTest() {
		char[][] matrix = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		matrix = Matrix.surroundedRegions(matrix);
		Matrix.printMatrix(matrix);
	}

	@Test
	public void wordSearchTest() {
		char[][] matrix = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		assertEquals(true, Matrix.wordSearch(matrix, "ABCCED"));
		assertEquals(true, Matrix.wordSearch(matrix, "SEE"));
		assertEquals(false, Matrix.wordSearch(matrix, "ABCB"));
	}

	@Test
	public void wordSearchTest2() {
		char[][] matrix = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
				// Looks like this
				/**
				 * [ ['o','a','a','n'],
				 * 
				 * ['e','t','a','e'],
				 * 
				 * ['i','h','k','r'],
				 * 
				 * ['i','f','l','v'] ]
				 * 
				 */
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> result = Matrix.wordSearch2(matrix, words);
		System.out.println(result.toString());
	}

	@Test
	public void trieTest() {
		Trie trie = new Trie();
		trie.add("oath");
		trie.add("pea");
		trie.add("eat");
		trie.add("rain");
		assertEquals(trie.search("oath"), true);
		assertEquals(trie.search("pea"), true);
		assertEquals(trie.search("eat"), true);
		assertEquals(trie.search("oat"), false);
		assertEquals(trie.isPrefix("oath"), true);
		assertEquals(trie.isPrefix("oat"), true);
		assertEquals(trie.isPrefix("rae"), false);
	}

	@Test
	public void longestConsecutivePathTest() {
		int[][] mat = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		int res = Matrix.longestConsecutivePath(mat);
		assertEquals(4, res);
	}

	@Test
	public void maxNoOfOne() {
		int[][] mat = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		int result = Matrix.maxNumberOf1(mat);
		assertEquals(2, result);

	}
}
