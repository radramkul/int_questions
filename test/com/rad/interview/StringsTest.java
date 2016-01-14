package com.rad.interview;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWordLadder() {
		String begin = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		int result = Strings.wordLadder(begin, end, dict);
		System.out.println("result is " + result);
		assertEquals(5, result);

	}

	@Test
	public void testWildCardMatch() {
		String text = "aaab";
		String pattern = "*a?b*c";
		boolean result = Strings.isWildCardMatch(text, pattern);
		assertEquals(false, result);
	}

	@Test
	public void testAtoi(){
		String str ="aaab";
		int result= Strings.atoi("123");
		assertEquals(123, result);
		try{
			result= Strings.atoi("");
			fail("No exception thrown");
		}
		catch(IllegalArgumentException e){
			
		}
		result= Strings.atoi("123");
		assertEquals(123, result);
	}
	
	@Test
	public void testLongestValidParanthesis(){
		String expr = "(()";
		assertEquals(2,Strings.longestValidParanthesis(expr));
		expr = "(()()))";
		assertEquals(6,Strings.longestValidParanthesis(expr));
		expr = ")()()))";
		assertEquals(4,Strings.longestValidParanthesis(expr));
	}
	
	@Test
	public void testLongestSubstringWothoutRepeatCharacters(){
		String str = "abcab";
		assertEquals(3,Strings.longestSubstringWithoutRepeatChar(str));
		str = "aaaa";
		assertEquals(1,Strings.longestSubstringWithoutRepeatChar(str));
		str = "";
		assertEquals(0,Strings.longestSubstringWithoutRepeatChar(str));
		str = "abcd";
		assertEquals(4,Strings.longestSubstringWithoutRepeatChar(str));
	}
	
	@Test
	public void testMinimumWindowSubstring(){
		String s = "abccdabbbb";
		String t = "abd";
		assertEquals("dab",Strings.minimumWindowSubstring(s, t));
	}
	
	@Test
	public void testReverseWords(){
		String s = "Hi This is";
		String expected ="is This Hi";
		String result = Strings.reverseWords(s);
		System.out.println("***" + result+ "**");
		assertEquals(expected,result);
	}

}
