package leetcode;
/*
 * The problem requires O(log n), obviously it uses binary search algorithms.
 * pitfalls: 
           Be careful of note1 and note2, we should constrain the value of start and end, otherwise it may cause array index out of bonds.
           
 * Here are two method : 1. bineary search  2. bineary search + o(n)
 * 
 * for Method 1:
 * 		  notes:
 * 				for note1 and note2, here are different initial value.
 * 				for note2, because upper here initialize with A.length, such subtract 1 in note3.
 * 				if for note2, we initialize upper with A.length - 1, it may cause bugs like: [1, 3], 1. 
 * 				the expectation result is [0,0], but the real result is [0, 1].
 * 		
 */

import java.util.Arrays;

public class SearchForARange {

    public static int[] searchRange2(int[] A, int target) {
        int[] result = new int[2];
        if(A == null || A.length == 0){
            Arrays.fill(result, -1);
            return result;
        }
        
        binearySearch2(A, 0, A.length - 1, target, result);
        
        return result;
    }
    
    public static void binearySearch2(int[] A, int left, int right, int target, int[] result){
        if(left > right){
            Arrays.fill(result, -1);
            return;
        }
        
        int mid = (left + right)/2;
        if(A[mid] == target){
            int l = mid - 1;
            int r = mid + 1;
            while(l >= left && A[l] == target) l--;
            while(r <= right && A[r] == target) r++;
            result[0] = l + 1;
            result[1] = r - 1;
            return;
        }
        
        if(A[mid] > target)
            binearySearch2(A, left, mid - 1, target, result);
        else 
            binearySearch2(A, mid + 1, right, target, result);
    }
    
    public static int[] searchRange1(int[] A, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if(A == null || A.length == 0) return result;
        
        int lower = 0;
        int upper = A.length - 1; //note1
        int mid;
        
        while(lower < upper){
            mid = (lower + upper)/2;
            if(A[mid] < target)
                lower = mid + 1;
            else
                upper = mid;
        }
        if(A[lower] != target) return result;
        result[0] = lower;
        
        upper = A.length;//note2
        
        while(lower < upper){
            mid = (lower + upper)/2;
            if(A[mid] > target)
                upper = mid;
            else
                lower = mid + 1;
        }
        
        result[1] = upper - 1;//note3
        
        return result;
        
        
    }
    
	public static void main(String[] args) {
		int[] A = {1};
		int target = 1;
		System.out.println(Arrays.toString(SearchForARange.searchRange2(A, target)));
		System.out.println(Arrays.toString(SearchForARange.searchRange1(A, target)));
		
	}
}
