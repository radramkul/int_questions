package com.rad.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Matrix {

	static int[][] matrix = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 0 } };
	static int[][] spiral = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
	static Queue<Integer> queue = new LinkedList<>();
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) {
		double i = 5.66;
		int j = (6 + 7) / 2;
		if (j == 6) {
			System.out.println("Java converts to Floor");
		}
		if (j == 7) {
			System.out.println("java converts to ceil");
		}
	}

	static void setZeros(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColZero = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// Making all rows zero according to flag
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// Making all cols zero according to flag
		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		if (firstRowZero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		if (firstColZero) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0] = 0;
			}
		}

		System.out.println("firstRowZero " + firstRowZero);
		System.out.println("firstColZero " + firstColZero);

	}

	static List<Integer> spiral(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			throw new IllegalArgumentException();
		}
		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0;

		List<Integer> result = new ArrayList<>();
		while (m > 0 && n > 0) {
			if (m == 1) {
				/* Only one row left */
				for (int i = 0; i <= n - 1; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			} else if (n == 1) {
				/* Only one row left */
				for (int i = 0; i <= m - 1; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			/* Complete a circle */
			// Right
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y++]);
			}

			// Down
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x++][y]);
			}

			// Left
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y--]);
			}

			// Up
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			}
			m = m - 2;
			n = n - 2;

			System.out.println("End position x: " + x + " Y " + y);

			y++;
			x++;
		}
		return result;
	}

	static int[][] generateSpiral(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		int x = 0;
		int y = 0;

		int[][] matrix = new int[n][n];
		int count = 1;
		while (n > 0) {
			if (n == 1) {
				/* Only one row and col left */
				matrix[x][y] = count++;
				break;
			}

			/* Complete a circle */
			// Right
			for (int i = 0; i < n - 1; i++) {
				matrix[x][y++] = count++;
			}

			// Down
			for (int i = 0; i < n - 1; i++) {
				matrix[x++][y] = count++;
				;
			}

			// Left
			for (int i = 0; i < n - 1; i++) {
				matrix[x][y--] = count++;
				;
			}

			// Up
			for (int i = 0; i < n - 1; i++) {
				matrix[x--][y] = count++;
				;
			}
			n = n - 2;

			y++;
			x++;
		}
		return matrix;
	}

	/*
	 * TODO: 1. Write Search 2 D matrix - binary search
	 * 
	 * 2. Rotate image by 90 degrees
	 * 
	 * 3. Write minSum
	 * 
	 * 4. Write Unique Path 1 & 2- very similar to minSum
	 * 
	 * 5.
	 * 
	 * 6.
	 */
	static void printMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();

		}

	}

	static void printMatrix(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();

		}

	}

	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		if (board.length != 9 || board[0].length != 9) {
			return false;
		}
		// Check each row
		for (int i = 0; i < 9; i++) {
			boolean[] numExists = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (numExists[board[i][j] - '0']) {
					return false;
				} else {
					numExists[board[i][j] - '0'] = true;
				}
			}
		}

		// check each col
		for (int i = 0; i < 9; i++) {
			boolean[] numExists = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (board[j][i] == '.') {
					continue;
				}
				if (numExists[board[j][i] - '0']) {
					return false;
				} else {
					numExists[board[j][i] - '0'] = true;
				}
			}
		}

		// Check 9 blocks
		for (int i = 0; i < 3; i++) {
			int row = i * 3;
			for (int j = 0; j < 3; j++) {
				int col = j * 3;
				// Starting point fixed
				// Count in 3X3 block from this point
				boolean[] numExists = new boolean[10];
				for (int r = row; r < row + 3; r++) {
					for (int c = col; c < col + 3; c++) {
						if (board[r][c] == '.') {
							continue;
						}
						if (numExists[board[r][c] - '0']) {
							return false;
						} else {
							numExists[board[r][c] - '0'] = true;
						}

					}
				}
			}
		}

		return true;

	}

	static int numberOfIslands(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					count++;
					merge(matrix, i, j);
				}
			}

		}

		return count;

	}

	// The only way to find optn regions is to start from border O
	// Find all connected O from here , mark as #
	// All the other O become X
	static char[][] surroundedRegions(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int rows = matrix.length;
		int cols = matrix[0].length;

		// Merge regions from top border & bottom border
		for (int i = 0; i < cols; i++) {
			if (matrix[0][i] == 'O') {
				bfs(matrix, 0, i);
			}
			if (matrix[rows - 1][i] == 'O') {
				bfs(matrix, rows - 1, i);
			}
		}

		// Left and Right border
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 'O') {
				bfs(matrix, i, 0);
			}
			if (matrix[i][cols - 1] == 'O') {
				bfs(matrix, i, cols - 1);
			}
		}
		// Process marked matrix
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == '#') {
					matrix[i][j] = 'O';
				} else if (matrix[i][j] == 'O') {
					matrix[i][j] = 'X';
				}
			}
		}

		return matrix;
	}

	private static void bfs(char[][] matrix, int i, int j) {
		fillCell(matrix, i, j);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int x = cur / matrix[0].length;
			int y = cur % matrix[0].length;
			fillCell(matrix, x - 1, y);
			fillCell(matrix, x + 1, y);
			fillCell(matrix, x, y - 1);
			fillCell(matrix, x, y + 1);
		}

	}

	private static void fillCell(char[][] matrix, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j > matrix[0].length) {
			return;
		}
		if (matrix[i][j] != 'O') {
			return;
		}
		matrix[i][j] = '#';
		queue.offer(i * matrix[0].length + j);

	}

	private static void merge(int[][] matrix, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return;
		}
		if (matrix[i][j] == 0) {
			return;
		}
		// Set current cell to 0
		matrix[i][j] = 0;
		merge(matrix, i - 1, j);
		merge(matrix, i + 1, j);
		merge(matrix, i, j - 1);
		merge(matrix, i, j + 1);

	}

	static boolean wordSearch(char[][] matrix, String word) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(matrix, i, j, word, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(char[][] matrix, int i, int j, String word, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return false;
		}
		if (matrix[i][j] != word.charAt(0) || visited[i][j]) {
			return false;
		}
		if (word.length() == 1) {
			return true;
		}
		// Set visited true
		visited[i][j] = true;
		String rest = word.substring(1);
		if (dfs(matrix, i + 1, j, rest, visited) || dfs(matrix, i - 1, j, rest, visited)
				|| dfs(matrix, i, j + 1, rest, visited) || dfs(matrix, i, j - 1, rest, visited)) {
			return true;
		}
		visited[i][j] = false;
		return false;
	}

	static List<String> wordSearch2(char[][] matrix, String[] words) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || words == null) {
			throw new IllegalArgumentException();
		}

		Trie trie = new Trie();
		for (String word : words) {
			trie.add(word);
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dfs2(matrix, i, j, "", visited, trie);
			}
		}

		return result;

	}

	private static void dfs2(char[][] matrix, int i, int j, String word, boolean[][] visited, Trie trie) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return;
		}
		if (visited[i][j]) {
			return;
		}
		String str = word + matrix[i][j];
		if (!trie.isPrefix(str)) {
			return;
		}
		if (trie.search(str)) {
			result.add(str);
		}
		// Set visited true
		visited[i][j] = true;
		dfs2(matrix, i + 1, j, str, visited, trie);
		dfs2(matrix, i - 1, j, str, visited, trie);
		dfs2(matrix, i, j + 1, str, visited, trie);
		dfs2(matrix, i, j - 1, str, visited, trie);

		visited[i][j] = false;

	}

	/**
	 * Given a n*n matrix where numbers all numbers are distinct and are
	 * distributed from range 1 to n2, find the maximum length path (starting
	 * from any cell) such that all cells along the path are increasing order
	 * with a difference of 1.
	 * 
	 * We can move in 4 directions from a given cell (i, j), i.e., we can move
	 * to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that
	 * the adjacen
	 */
	static int longestConsecutivePath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = 0;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int len = 1 + dfs3(matrix, i, j, visited, matrix[i][j]);
				max = Math.max(len, max);
				System.out.println("Element is " + matrix[i][j] + " max " + max);
			}
		}

		return max;

	}

	private static int dfs3(int[][] matrix, int i, int j, boolean[][] visited, int number) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return 0;
		}
		if (visited[i][j]) {
			return 0;
		}
		int distance = 0;
		if (matrix[i][j] - number != 1 && matrix[i][j] != number) {
			return 0;
		} else if (matrix[i][j] - number == 1) {
			distance++;

		}
		int maxDist = 0;
		visited[i][j] = true;
		maxDist = Math.max(dfs3(matrix, i + 1, j, visited, matrix[i][j]),
				dfs3(matrix, i - 1, j, visited, matrix[i][j]));
		maxDist = Math.max(dfs3(matrix, i, j + 1, visited, matrix[i][j]), maxDist);
		maxDist = Math.max(dfs3(matrix, i, j - 1, visited, matrix[i][j]), maxDist);
		visited[i][j] = false;
		return distance + maxDist;
	}

	static int maxNumberOf1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int maxNo = 0;
		int maxRow = -1;
		for (int i = 0; i < rows; i++) {
			int start = 0;
			int end = cols - 1;
			int index = Integer.MAX_VALUE;
			// Find the first index of 1
			while (start < end) {
				int mid = (start + end) / 2;
				if (matrix[i][mid] == 1) {
					if (mid == 0) {
						index = 0;
						break;
					}
					if (matrix[i][mid - 1] == 0) {
						index = mid;
						break;
					} else {
						end = mid;
					}
				} else {
					start = mid + 1;
				}
			}
			System.out.println("Row is " + i + " index of first 1 is " + index);
			int ones = cols - 1 - index;
			maxNo = Math.max(maxNo, ones);
			if (ones == maxNo) {
				maxRow = i;
			}

		}

		return maxRow;

	}

}
