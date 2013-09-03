package leetcode;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        if(A.length == 1)
            return 1;
        int pos = 1;
        int count = 0;
        for(int i = 1; i < A.length; i++ ){
            if(A[i] == A[i-1]){
                count ++;
                if(count<2){
                    A[pos++] = A[i]; //note, it's not correct, if written as pos++.
                }
                continue;
            }
            else{
                  count = 0;
                  A[pos++] = A[i];
                
            }
        }
        return pos;
    }
	public static void main(String[] args) {
		int[] A = {1,1,1,1,3,3};
		int length = RemoveDuplicatesFromSortedArrayII.removeDuplicates(A);
		A = Arrays.copyOfRange(A, 0, length);
		for(int i = 0; i< A.length; i++){
			System.out.print(" " + A[i]);
		}
	}
}
