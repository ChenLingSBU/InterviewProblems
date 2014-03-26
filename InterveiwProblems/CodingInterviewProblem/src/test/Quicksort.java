package test;

import java.util.Arrays;

public class Quicksort {
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static int partition(int a[], int start, int end) {
		int m = (start + end)/2;
		int pivot = a[m];
		while(start <= end){
			while(a[start] > pivot) start++;
			while(a[end] < pivot) end--;
			if(start <= end){
				int tmp = a[start];
				a[start] = a[end];
				a[end] = tmp;
				start++;
				end--;
			}
			
		}
		
		return start;
	}
	
	public static void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right); 
		if (left < index - 1) { // Sort left half
			quickSort(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
			quickSort(arr, index, right);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 23, 12, 9, 30, 2, 50};
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

}
