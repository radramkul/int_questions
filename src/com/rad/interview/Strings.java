package com.rad.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abba";
		String s2 = "dggd";
		String s3 = "eggr";
		System.out.println(isIsomorphic(s1, s2));
		System.out.println(isIsomorphic(s1, s3));
		stringsSortDemo();

	}

	public static boolean isIsomorphic(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		HashMap<Character, Character> hm = new HashMap<>();
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			Character c = getKey(hm, c2);
			if (c != null && c.charValue() != c1) {
				return false;
			} else if (hm.containsKey(c1) && hm.get(c1) != c2) {
				return false;
			} else if (c == null) {
				hm.put(c1, c2);
			}

		}
		return true;
	}

	public static Character getKey(HashMap<Character, Character> hm, char value) {
		for (Map.Entry<Character, Character> entry : hm.entrySet()) {
			if (entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return null;
	}

	static int wordLadder(String begin, String end, Set<String> dict) {
		// Begin =hit enf=cog
		// Dict: hot dot dog lat log
		Word beginWord = new Word(begin, 1);
		Queue<Word> queue = new LinkedList<>();
		queue.add(beginWord);
		dict.add(end);
		while (!queue.isEmpty()) {
			Word word = queue.remove();
			int distance = word.distance;
			String wordString = word.wordString;
			char[] wordArray = wordString.toCharArray();
			if (wordString.equals(end)) {
				return distance;
			}
			for (int i = 0; i < wordArray.length; i++) {
				char temp = wordArray[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (c != temp) {
						wordArray[i] = c;
						String newWord = new String(wordArray);
						if (dict.contains(newWord)) {
							// Remove from seen words
							dict.remove(newWord);
						}
					}
				}
				wordArray[i] = temp;
			}
		}
		return 0;
	}

	static class Word {
		String wordString;
		int distance;

		Word(String word, int distance) {
			this.wordString = word;
			this.distance = distance;
		}
	}

	static boolean isWildCardMatch(String text, String pattern) {
		if (text == null || pattern == null) {
			return false;
		}
		if (text.isEmpty() || pattern.isEmpty()) {
			return false;
		}
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;
		while (i < text.length()) {
			if (j < pattern.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < pattern.length() && pattern.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}

		while (j < pattern.length() && pattern.charAt(j) == '*') {
			j++;
		}
		return j == pattern.length();

	}

	static int atoi(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException();
		}
		int value = 0;
		str = str.trim();
		if (str.charAt(0) == '+') {
			value = atoi(str.substring(1));

		} else if (str.charAt(0) == '-') {
			value = -atoi(str.substring(1));

		} else if (str.indexOf('.') != -1) {
			String integer = str.split(".")[0];
			String decimal = str.split(".")[1];
			value = calculateIntegerValue(integer) + calculateDecimalValue(decimal);
		} else {
			return calculateIntegerValue(str);
		}
		if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
			return value;
		} else {
			throw new IllegalArgumentException();
		}
	}

	private static int calculateDecimalValue(String decimal) {
		int value = 0;
		for (int i = 0; i < decimal.length(); i++) {
			value += decimal.charAt(i) * Math.pow(10, -(i + 1));

		}
		return value;
	}

	private static int calculateIntegerValue(String integer) {
		int value = 0;
		for (int i = integer.length() - 1; i >= 0; i--) {
			int power = integer.length() - 1 - i;
			value += (integer.charAt(i) - '0') * Math.pow(10, power);

		}
		return value;
	}

	static int longestValidParanthesis(String str) {
		List<Integer> leftIndex = new ArrayList<>();
		List<Integer> rightIndex = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				leftIndex.add(i);
			} else {
				rightIndex.add(i);
			}
		}
		int right = rightIndex.size() - 1;
		int left = leftIndex.size() - 1;
		int length = 0;
		while (right >= 0 && left >= 0) {
			while (rightIndex.get(right) < leftIndex.get(left)) {
				left--;
			}
			if (left >= 0) {
				length += 2;
			}
			right--;
			left--;
		}
		return length;
	}
	
	static int longestSubstringWithoutRepeatChar(String str){
		if(str==null || str.length()==0){
			return 0;
		}
		int start =0;
		int len=1;
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(hm.containsKey(c)){
				len = Math.max(len,(i-start));
				start=i;
				hm.clear();
			}
			hm.put(c, i);
		}
		len = Math.max(len,(str.length()-start));
		return len;
	}
	
	static String minimumWindowSubstring(String s,String t){
		String result ="";
		if(s==null||t==null||s.length()==0||t.length()==0){
			return result;
		}
		HashMap<Character,Integer> tMap = new HashMap<>();
		HashMap<Character,Integer> sMap = new HashMap<>();
		int left=0;
		int len = s.length();
		int count =0;
		for(char c: t.toCharArray()){
			if(tMap.containsKey(c)){
				tMap.put(c, tMap.get(c)+1);
			}
			else{
				tMap.put(c,1);
			}
		}
		for(int i=0;i< s.length();i++){
		    char c = s.charAt(i);
		    if(tMap.containsKey(c)){
		    	if(sMap.containsKey(c)){
		    		sMap.put(c,sMap.get(c)+1);
		    		if(sMap.get(c)<= tMap.get(c)){
		    			count++;
		    		}
		    	}
		    	else{
		    		sMap.put(c, 1);
		    		count++;
		    	}
		    }
		    if(count ==t.length()){
		    	char chr = s.charAt(left);
		    	while(!sMap.containsKey(chr)|| sMap.get(chr)> tMap.get(chr)){
		    		if(sMap.containsKey(chr)&& sMap.get(chr)> tMap.get(chr)){
		    			sMap.put(chr,sMap.get(chr)-1);
		    		}
		    		left++;
		    		chr = s.charAt(left);
		    	}
		    	if((i-left+1)< len){
		    		len = i-left+1;
		    		result = s.substring(left,i+1);
		    		System.out.println(result);
		    	}
		    }
		    
		}
		return result;
	}
	
	static String reverseWords(String str){
		StringBuilder sb = new StringBuilder();
		if(str==null|| str.length()==0){
			return sb.toString();
		}
		String[] words = str.split(" ");
		for(int i=words.length-1;i>=0;i--){
			sb.append(words[i]).append(" ");
		}
		
		return sb.substring(0,sb.length()-1);
		
	}
	
	static void stringsSortDemo(){
		String[] strArr = {"1","5","3","0"};
		Arrays.sort(strArr);
		System.out.println(Arrays.asList(strArr));
	}
	
	/*
	 * TO DO:
	 * 1. Minimum size subarray sum >target
	 * 2. Longest Consecutive Sequence in array
	 * 3. Zigzag conversion
	 * 4. Triangle (Recursion and DP)
	 * 5. Add two binary numbers Strings ()
	 * 6. Valid Palindrome
	 * 7. Contains duplicate 3
	 * 8. Search target in rotated sorted array with duplicates
	 * 8. Min Stack Data Structure design
	 * 9. Remove element: like remove duplicates
	 * 10. 
	 * */

}
