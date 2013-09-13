package leetcode;
/*
 * The problem requires O(log n), obviously it uses binary search algorithms.
 * pitfalls: 
           Be careful of note1 and note2, we should constrain the value of start and end, otherwise it may cause array index out of bonds.
 */

import java.util.Arrays;

public class SearchForARange {

    public static int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = A.length - 1;
        int start = findStart(A, left, right, target);
        if(start == -1){
            result[0] = -1;
            result[1] = -1;
        }else{
            int end = start;
            while(end <= right && A[end] == target)  //note 1.
                 end++;
            end--;
            result[0] = start;
            result[1] = end;
            return result;
        }
        
        return result;
        
     }
     
     
     public static int findStart(int[] A, int left, int right, int target){ // return -1 if cannot find start position
         if(left > right) return -1;
         int mid = (left + right)/2;
         if(A[mid] == target){
             while(mid >= 0 && A[mid] == target) // note 2.
                 mid--;
             return mid + 1;
         }
         
         if(A[mid] > target)
             return findStart(A, left, mid - 1, target);
         else
             return findStart(A, mid + 1, right, target);
             
        
     }
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
		int target = 8;
		System.out.println(Arrays.toString(SearchForARange.searchRange(A, target)));
	}
}
