package com.rad.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import javax.management.RuntimeErrorException;

public class ArrayQuestions {
	int[] array = { 1, 2, 3, 4, 5, 6, 7 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	static void arrayRotate(int[] arr, int order) {
		if (arr == null || order < 0) {
			return;
		}
		int len = arr.length;
		order = order % len;
		int splitIndex = len - order;
		reverseArray(arr, 0, splitIndex - 1);
		reverseArray(arr, splitIndex, len - 1);
		reverseArray(arr, 0, len - 1);
	}

	static void reverseArray(int[] arr, int start, int end) {
		if (arr == null || (end < start)) {
			return;
		}
		while (end > start) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			end--;
			start++;
		}
	}

	static int evaluateReversePolishExpr(String[] expr) {
		// ["2","3","+","5","*"] (2+3)*5 =5*5=25
		// Go left to right, if number, push,
		// If operator, pop last two compute result, and push back
		Stack<String> st = new Stack<>();
		for (String str : expr) {
			try {
				int intValue = Integer.parseInt(str);
				st.push(String.valueOf(intValue));
			} catch (NumberFormatException e) {
				int second = Integer.parseInt(st.pop());
				int first = Integer.parseInt(st.pop());
				int result = 0;
				switch (str) {
				case "+":
					result = first + second;
					st.push(String.valueOf(result));
					break;
				case "-":
					result = first - second;
					st.push(String.valueOf(result));
					break;
				case "*":
					result = first * second;
					st.push(String.valueOf(result));
					break;
				case "/":
					result = first / second;
					st.push(String.valueOf(result));
					break;
				}
			}
		}
		int result = Integer.parseInt(st.pop());
		if (st.isEmpty()) {
			return result;
		} else {
			throw new IllegalArgumentException();
		}
	}

	static void evaluatePrefixexpression(String[] expr) {
		// +23*4
		// reverse array and use method above
	}

	static float medianOfTwoSortedArrays(int[] arr1, int begin1, int end1, int[] arr2, int begin2, int end2) {
		// This function returns twice the median
		// 0.5 is rounded off to lower integer in JAVA
		if (end1 < begin1 || end2 < begin2) {
			throw new IllegalArgumentException();
		}
		int length1 = end1 - begin1 + 1;
		int length2 = end2 - begin2 + 1;
		int midpoint1 = (begin1 + end1) / 2;
		int midpoint2 = (begin2 + end2) / 2;
		// ADD BASE CASES
		// We will assume that array1 is the smaller
		if (length1 == 1) {
			if (length2 == 1) {
				return (arr1[begin1] + arr2[begin2]);
			} else {
				throw new RuntimeException("Wrong partition");
			}
		}
		if (length1 == 2) {
			if (length2 == 2) {
				return (arr1[begin1] + arr1[end1] + arr2[begin2] + arr2[end2]
						- Math.max(arr1[begin1], Math.max(arr1[end1], Math.max(arr2[begin2], arr2[end2])))
						- Math.min(arr1[begin1], Math.min(arr1[end1], Math.min(arr2[begin2], arr2[end2]))));
			} else {
				throw new RuntimeException("Wrong partition");
			}
		}
		float median1 = getMedianofArray(arr1, begin1, end1);
		float median2 = getMedianofArray(arr2, begin2, end2);
		if (median1 == median2) {
			return median1;
		}
		// In odd arrays include median
		// in even arrays, split in half
		if (median1 > median2) {
			if (length1 % 2 == 0 && length2 % 2 == 0) {
				return medianOfTwoSortedArrays(arr1, begin1, midpoint1, arr2, midpoint2 + 1, end2);
			} else if (length1 % 2 == 0 && length2 % 2 != 0) {
				return medianOfTwoSortedArrays(arr1, begin1, midpoint1, arr2, midpoint2, end2);

			} else if (length1 % 2 != 0 && length2 % 2 == 0) {
				return medianOfTwoSortedArrays(arr1, begin1, midpoint1, arr2, midpoint2 + 1, end2);

			} else if (length1 % 2 != 0 && length2 % 2 != 0) {
				return medianOfTwoSortedArrays(arr1, begin1, midpoint1, arr2, midpoint2, end2);

			}
		} else {
			if (length1 % 2 == 0 && length2 % 2 == 0) {
				return medianOfTwoSortedArrays(arr1, midpoint1 + 1, end1, arr2, begin2, midpoint2);
			} else if (length1 % 2 == 0 && length2 % 2 != 0) {
				return medianOfTwoSortedArrays(arr1, midpoint1 + 1, end1, arr2, begin2, midpoint2);

			} else if (length1 % 2 != 0 && length2 % 2 == 0) {
				return medianOfTwoSortedArrays(arr1, midpoint1, end1, arr2, begin1, midpoint2);

			} else if (length1 % 2 != 0 && length2 % 2 != 0) {
				return medianOfTwoSortedArrays(arr1, midpoint1, end1, arr2, begin2, midpoint2);
			}

		}

		return 0;

	}

	static float getMedianofArray(int[] arr, int begin, int end) {
		int length = end - begin + 1;
		if (begin == end) {
			return arr[begin];
		}
		if ((end - begin) == 1) {
			return (arr[begin] + arr[end]) / 2;
		}
		if (length % 2 == 0) {
			return (arr[begin + (length / 2)] + arr[begin + (length / 2) - 1]) / 2;
		} else {
			return arr[begin + ((length - 1) / 2)];
		}
	}

	static int partitionArray(int[] input, int start, int end) {
		int pivot = input[end];
		int i = start;
		int j = end - 1;
		if (start == end) {
			return start;
		}
		while (i < j) {
			while (input[i] < pivot && i < (end - 1)) {
				i++;
			}
			while (input[j] > pivot && j > start) {
				j--;
			}
			if (i < j) {
				swap(input, i, j);
			}
		}
		swap(input, i, end);
		if (i > end || i < start) {
			throw new RuntimeException("Wrong partition");
		}
		return i;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	static int findKthElement(int[] input, int start, int end, int k) {
		System.out.println(start);
		System.out.println(end);
		System.out.println(k);
		int partition = partitionArray(input, start, end);
		System.out.println("Partition is" + partition);
		if ((partition + 1) == (start + k)) {
			return input[partition];
		} else if ((partition + 1) > (start + k)) {
			return findKthElement(input, start, partition - 1, k);
		} else {
			return findKthElement(input, partition + 1, end, k - partition - 1);
		}

	}

	static int[] twoSum(int[] data, int sum) {
		int[] result = new int[data.length];
		int index = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < data.length; i++) {
			int secondNumber = sum - data[i];
			if (hm.containsKey(secondNumber)) {
				result[index++] = hm.get(secondNumber);
				result[index++] = i;
			}
			hm.put(data[i], i);
		}
		return result;
	}

	static int[] mergeTwoSortedArrays(int[] A, int[] B, int m, int n) {
		System.arraycopy(B, 0, B, m, n);
		// A is size m and B is size (m+n)
		int k = 0;
		int i = 0;
		int j = m;
		while (i < m && j < (m + n)) {
			if (B[j] <= A[i]) {
				B[k++] = B[j++];
			} else {
				B[k++] = A[i++];
			}
		}
		if (i == m) {
			while (j < (m + n)) {
				B[k++] = B[j++];
			}

		} else {
			while (i < m) {
				B[k++] = A[i++];
			}
		}
		return B;

	}

	static int[] removeDuplicatesFromSortedArray(int[] arr) {
		if(arr==null|| arr.length<2){
			return arr;
		}
		int i = 1;
		int j = 0;
		while (i < arr.length) {
            if(arr[i]==arr[i-1]){
            	i++;
            }
            else{
            	j++;
            	arr[j]=arr[i];
            	i++;
            }
		}
		int[] newArray = new int[j+1];
		System.arraycopy(arr, 0, newArray, 0, j+1);
		printArray(newArray);
		return newArray;
	}
	
	
	/*
	 * This method allows repetition only once
	 * */
	static int[] removeDuplicatesFromSortedArray2(int[] arr) {
		if(arr==null|| arr.length<2){
			return arr;
		}
		int[] arr2 = new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		int i = 2;
		int j = 1;
		while (i < arr2.length) {
            if((arr2[i]==arr2[i-1])&&(arr2[i-1]==arr2[i-2])){
            	i++;
            }
            else{
            	j++;
            	arr[j]=arr[i];
            	i++;
            }
		}
		int[] newArray = new int[j+1];
		System.arraycopy(arr, 0, newArray, 0, j+1);
		printArray(newArray);
		return newArray;
	}

	private static void printArray(int[] newArray) {
		for(int i:newArray){
			System.out.println(i);
		}
		
	}

}
