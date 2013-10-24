package leetcode;


/*
 * since the time complexity should be linear, and cannot use extra space, use xor. 
 */

public class SingleNumber {

	
    public int singleNumber(int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++){
            result ^= A[i];
        }
        return result;
    }
    
	public static void main(String[] args) {
	
	}
}
