package com.rad.interview;

class TrieNode {
	String item = "";
	TrieNode[] children = new TrieNode[26];
}

public class Trie {
	TrieNode root = new TrieNode();

	void add(String word) {
		TrieNode node = root;
		char[] wordArray = word.toCharArray();
		for (char c : wordArray) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.item = word;
	}

	boolean isPrefix(String word) {
		TrieNode node = root;
		char[] wordArray = word.toCharArray();
		for (char c : wordArray) {
			if (node.children[c - 'a'] == null) {
				return false;
			}
			node = node.children[c - 'a'];
		}
		return true;
	}

	boolean search(String word) {
		TrieNode node = root;
		char[] wordArray = word.toCharArray();
		for (char c : wordArray) {
			if (node.children[c - 'a'] == null) {
				return false;
			}
			node = node.children[c - 'a'];
		}
		if (node.item.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

}
