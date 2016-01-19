package com.rad.interview;

public class DynamicProg {
	/**
	 * This mehtod uses DP to stored 0 or 1 depending on if substring(i,j) is
	 * palindrome or not
	 * 
	 * Uses O(n2) time and O(n^2) space
	 * 
	 * TODO: Another algo uses O(n^2) time and O(1)space. Checks for all the
	 * substring with center i and substrings with 2 centers (i,i+1). Write this
	 * program
	 * 
	 * @param s
	 * @return lps
	 */
	public static String longestPalindromicSubstring(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException();
		}

		int maxlen = Integer.MIN_VALUE;
		int len = s.length();
		int[][] dp = new int[len][len];
		String longest = "";

		// Fill substring of length 1
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}

		// Fill substring of length 2

		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
			}
		}

		// Fill substring for length 3 and above
		for (int l = 3; l <= len; l++) {
			// fix starting point
			for (int i = 0; i < len; i++) {
				int j = i + l - 1;
				if (j < len) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i + 1][j - 1];
						String sub = s.substring(i, j + 1);
						if (sub.length() > maxlen) {
							maxlen = sub.length();
							longest = sub;
						}

					}
				}

			}

		}

		return longest;

	}

	/**
	 * 
	 * maintain dp[i][j] to store edit distance between str(i,j) Consider
	 * replace, insert, delete
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int editDistance(String s1, String s2) {
		if (s1 == null || s2 == null) {
			throw new IllegalArgumentException();
		}
		int len1 = s1.length();
		int len2 = s2.length();
		int[][] dp = new int[len1][len2];

		for (int i = 0; i < len1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < len2; i++) {
			dp[0][i] = i;
		}
		int minDist = Integer.MAX_VALUE;

		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(j);
				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int replace = dp[i - 1][j - 1] + 1;
					int delete = dp[i - 1][j] + 1;
					int insert = dp[i][j - 1] + 1;
					minDist = Math.min(delete, replace);
					minDist = Math.min(insert, minDist);
					dp[i][j] = minDist;

				}

			}
		}

		return dp[len1 - 1][len2 - 1];
	}

	/**
	 * Return true if we can reach the end using jumps in the array
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean canReachEnd(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}

		int maxReach = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i >= maxReach && arr[i] == 0) {
				return false;
			}

			maxReach = Math.max(maxReach, i + arr[i]);
			if (maxReach >= arr.length - 1) {
				return true;
			}
		}

		return false;

	}

	public static int minJumps(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int[] jumps = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= (j + arr[j])) {
					jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
				}
			}

		}

		return jumps[arr.length - 1];
	}

	/**
	 * Returns minimum cuts needed to convert the string in palindromes O(n2)
	 * 
	 * MinCut holds how many cuts needed to make String(i,j) palindrome
	 * 
	 * @param s
	 * @return
	 */
	public static int palindromePartition(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int[][] minCut = new int[len][len];
		boolean[][] isPalindrome = new boolean[len][len];

		// Length 1
		for (int i = 0; i < len; i++) {
			isPalindrome[i][i] = true;
			minCut[i][i] = 0;
		}

		// Length 2
		for (int i = 1; i < len; i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				isPalindrome[i - 1][i] = true;
				minCut[i - 1][i] = 0;
			} else {
				isPalindrome[i - 1][i] = false;
				minCut[i - 1][i] = 1;
			}
		}

		// All others
		for (int l = 3; l <= len; l++) {
			for (int i = 0; i < len; i++) {
				int j = i + l - 1;
				if (j > len - 1) {
					continue;
				}
				char c1 = s.charAt(i);
				char c2 = s.charAt(j);
				if ((c1 == c2) && (isPalindrome[i + 1][j - 1])) {
					isPalindrome[i][j] = true;
					minCut[i][j] = 0;
				} else {
					isPalindrome[i][j] = false;
					minCut[i][j] = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int cuts = minCut[i][k] + 1 + minCut[k + 1][j];
						minCut[i][j] = Math.min(minCut[i][j], cuts);
					}
				}
			}
		}

		return minCut[0][len - 1];

	}

	public static int buySellStockOne(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int profit = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			profit = Math.max(profit, arr[i] - min);
		}
		return profit;
	}

	public static int buySellStockMany(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
	
	/**
	 * Allowed to make 2 transactions max.
	 * 
	 * Use DP to maintain profit  for before and after i th day
	 * find max for the sum at i from both arrays
	 * 
	 * @param arr
	 * @return
	 */
	public static int buySellStockTwo(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}

}
