package other;


/*
 * the same as find median of two sorted Arrays. 
 * O(log(n + m))
 */
import java.util.Arrays;
public class FindKthSmallestNumberInTwoSortedArrays {

	public static int getKthNumber(int[] A, int[] B, int K){
		int n = A.length;
		int m = B.length;
		if(n == 0) return B[K - 1]; 
		if(m == 0) return A[K - 1];
		if(K <= 1) return Math.min(A[0],B[0]);
		
		if(A[n/2] >= B[m/2]){
			if(n/2 + m/2 + 1 >= K)
				return getKthNumber(Arrays.copyOfRange(A, 0, n/2), B, K);
			else
				return getKthNumber(A, Arrays.copyOfRange(B, m/2 + 1, m), K - m/2 - 1);
		}
		else{
			if(n/2 + m/2 + 1 >= K)
				return getKthNumber(A, Arrays.copyOfRange(B, 0, m/2), K);
			else
				return getKthNumber(Arrays.copyOfRange(A, n/2 + 1, n ), B, K - n/2 - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1 ,3, 6, 15};
		int[] B = {2, 7, 8, 10};
		int K = 5;
		System.out.println(FindKthSmallestNumberInTwoSortedArrays.getKthNumber(A, B, K));
	}
}
