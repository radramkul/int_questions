package com.rad.interview;

public class SearchSort {
	public static int binarySearch(int[] arr, int low, int high, int number) {
		if (arr == null || low < 0 || high >= arr.length) {
			return -1;
		}
		if (low == high) {
			return arr[low] == number ? low : -1;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == number) {
			return mid;
		}

		if (number > arr[mid]) {
			return binarySearch(arr, mid + 1, high, number);
		} else {
			return binarySearch(arr, low, mid - 1, number);
		}

	}

	public static void insertionSort(int[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				int temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}

	public static void quickSort(int[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}

		quickSortHelper(arr, 0, arr.length - 1);

	}

	private static void quickSortHelper(int[] arr, int start, int end) {
		if (start >= end || start < 0 || end > arr.length - 1) {
			return;
		}

		int pivot = arr[end];
		int i = start;
		int j = end - 1;

		while (i <= j && i < arr.length && j >= 0) {
			while (i < arr.length - 1 && arr[i] < pivot) {
				i++;
			}
			while (j >= 0 && arr[j] > pivot) {
				j--;
			}

			// Swap i,j
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
		}

		// Swap arr[i] and pivot
		if (i <= end && i >= 0) {
			int temp = arr[end];
			arr[end] = arr[i];
			arr[i] = temp;
		}

		// i pivot index now

		quickSortHelper(arr, start, i - 1);
		quickSortHelper(arr, i + 1, end);

	}

	public static void mergeSort(int[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}

		mergeSortHelper(arr, 0, arr.length - 1);

	}

	private static void mergeSortHelper(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		mergeSortHelper(arr, start, mid);
		mergeSortHelper(arr, mid + 1, end);

		// Merge two sorted arrays
		merge(arr, start, mid, mid + 1, end);

	}

	private static void merge(int[] arr, int start1, int end1, int start2, int end2) {

		if (start1 > end1 || start2 > end2) {
			return;
		}
		int[] temp = new int[arr.length];
		System.arraycopy(arr, 0, temp, 0, arr.length);

		int i = start1;
		int j = start2;
		int k = start1;
		while (i <= end1 && j <= end2) {
			if (temp[i] < temp[j]) {
				arr[k++] = temp[i++];
			} else {
				arr[k++] = temp[j++];
			}

		}

		if (i > end1) {
			while (j <= end2) {
				arr[k++] = temp[j++];
			}
		} else {
			while (i <= end1) {
				arr[k++] = temp[i++];
			}

		}

	}

}
