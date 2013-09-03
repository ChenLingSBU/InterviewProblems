package leetcode;
/*
 * note, the problem requires the new length of the new Array, not the repeated times. 
 */

public class RemoveDuplicatesFromSortedArray {
	
    public static int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        if(A.length == 1)
            return 1;
        int pos = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] == A[i-1])
                continue;
            else
                A[pos++] = A[i];
        } 
        return pos;
    }
  
	public static void main(String[] args) {
		int[] A = {1,1,2};
		System.out.println(RemoveDuplicatesFromSortedArray.removeDuplicates(A));
		}	
}
