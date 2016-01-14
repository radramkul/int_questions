package com.rad.interview;

import java.util.Arrays;

public class Questions {
	public static void main(String[] args){
		int[] arr = {1,2,4,6,7,8,5};
		int[] rotated ={5,6,0,1,2,3,4};
		int[] sorted1 ={1,3,5,7,9};
		int[] sorted2 = {2,4,6,8,10};
		System.out.println("Median is" + 
				medianOfTwoSortedArrays(sorted1,0,4,sorted2,0,4));
		//rotateArray2(arr,2);
		//printArray(arr)
		//System.out.println(findMinRotatedArray(rotated,0,rotated.length-1));
		/*
		int sum =0;
		for(int i:arr){
			sum=sum^i;
		}
		System.out.println(sum);
		Arrays.sort(arr);
		printArray(arr);*/


	}
	static void printArray(int[] arr){
		for(int i:arr){
			System.out.print(i+"\t");
		}
		System.out.println();
	}

	static void rotateArray(int[] arr,int k){
		//Method 1: Rotate one by one : k times
		int len= arr.length;
		for(int i=0;i<k;i++){
			int begin = arr[len-1];
			for(int j=len-1;j>0;j--){
				arr[j]=arr[j-1];
			}
			arr[0]=begin;
		}
	}

	static void rotateArray2(int[] arr,int k){
		int[] newArray = new int[arr.length+k];
		System.arraycopy(arr, 0, newArray, 0,arr.length);
		for(int i=0;i<arr.length;i++){
			arr[(i+k)%arr.length] = newArray[i];
		}
	}

	static float medianOfTwoSortedArrays(int[] arr1,int low1, int high1,int[]arr2, int low2, int high2){
		if(arr1==null || arr2==null){
			return Integer.MAX_VALUE;
		} 
		//Lets assume both arrays are of same size
		if((high1-low1)==1){
			int low = Math.max(arr1[low1],arr2[low2]);
			int high = Math.min(arr1[high1], arr2[high2]);
			return (low+high)/2;
		}
		if(high1==low1){
			return (arr1[low1]+arr2[low2])/2;
		}
		float median1 = getMedian(arr1,low1,high1);
		float median2 = getMedian(arr2,low2,high2);
		int medianIndex = (high1+low1)/2;
		int medianIndex2 = (high2+low2)/2;
		if(median1 > median2){
			if((high1-low1)%2==0){
				return medianOfTwoSortedArrays(arr1,low1,medianIndex,arr2,medianIndex2,high2);
			}
			else{
				return medianOfTwoSortedArrays(arr1, low1, medianIndex, arr2, medianIndex2+1, high2);
			}
			
		}
		else{
			if((high1-low1)%2==0){
				return medianOfTwoSortedArrays(arr1,medianIndex,high1,arr2,low2,medianIndex2); 
			}
			else{
				return medianOfTwoSortedArrays(arr1,medianIndex+1,high1,arr2,low2,medianIndex2); 	
			}
			
		}


	}

	static float getMedian(int[]arr, int low, int high){
		if((high-low)%2==0){
			//Odd length array
			return arr[(high+low)/2];
		}
		else{
			//event length
			int index1 = (high+low)/2;
			int index2= index1+1;
			return (arr[index1]+ arr[index2])/2;
		}
	}
	static float findMinRotatedArray(int[] arr,int left, int right){
		if(arr==null){
			return Integer.MAX_VALUE;
		}
		int middle = (left+right)/2;

		if(arr[left]<=arr[right]){
			return arr[left];
		}
		if((right-left) ==1){
			return Math.min(arr[left],arr[right]);
		}
		if(arr[left]>arr[middle]){
			return findMinRotatedArray(arr,left,middle);
		}
		else{
			return findMinRotatedArray(arr,middle,right);
		}

	}
	
	

}
