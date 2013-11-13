package other;



/*
 * find K biggest/smallest Elements in an unsorted array. 
 * 
 * two methods: 1.) use quick selection O(n)  2.) use max/min heap
 * 
 * 1.) quick selection is similar to quick sort:
 * 	   main idea is randomly pick up an element as pivot in the array(for simplicity, I picked up the mid-indexed element every time).
 *     put all the elements larger than pivot before pivot. call this half array LESS(pivot is excluded), L is the number of elements in LESS
 *     put all the elements smaller than pivot after pivot. call this half array LARGER(pivot is included) 
 *     if L == k. return.
 *     if L < k, quickSelection(LESS, K); // LESS doesn't contain pivot.
 *     if L > k, quickSelection(LARGER, K - L);
 * 
 *  note1. index is the pivot's index that all the elements before pivot is larger than pivot, all the elements after pivot is smaller than pivot.
 *  note2. index should be included in the LARGER half array. other wise will cause errors.
 *  
 *  
 *  
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.ArrayList;

public class FindKBigestElements {

	/*
	 * Below is quick selection method.
	 */
	public static int[] findKBiggestQuickSelection(int[] a, int k){
		int start = 0;
		int end = a.length - 1;
		quickSelection(a, start, end, k);
		return Arrays.copyOfRange(a, 0, k);
	}
	
	public static void quickSelection(int[] a, int start, int end, int k){
		if(start >= end) return;
		int index = partition(a, start, end); // note1.
		if((index - start) == k ) return;
		else if((index - start) > k)
			quickSelection(a, start, index - 1, k);
 		else if((index - start) < k) 
			quickSelection(a, index, end, k - (index - start)); //note2;
	}
	
	public static int partition(int[] a, int start, int end){
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
	
	
	/*
	 *  Below is Heap method:
	 */
	
	public static ArrayList<Integer> findKBiggestHeap(int[] a, int k){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(a == null || a.length == 0) return result;
		if(k<=0 || k >= a.length) return result;
		int count = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(a.length, Collections.reverseOrder());
		for(int i = 0; i < a.length; i++){
			heap.add(a[i]);
		}
		
		while(!heap.isEmpty() && count < k){
			result.add(heap.poll());
			count++;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] a = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		System.out.println(FindKBigestElements.findKBiggestHeap(a, k).toString());
		System.out.println(Arrays.toString(FindKBigestElements.findKBiggestQuickSelection(a, k)));
	}
}
