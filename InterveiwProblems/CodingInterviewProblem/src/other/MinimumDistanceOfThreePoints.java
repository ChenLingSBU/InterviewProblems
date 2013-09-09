package other;

import java.util.Arrays;

/*
 * Given three sorted(ascending order) arrays: A,B,C, you can get three element a,b,c from each of them. Find the minimum distance |a-b| + |b-c| + |c-a|.
 * Note: if these three arrays are not sorted, sort them first. in this situation, it's O(nlogn);
 * Solution:
 * 	 it's a classic pointers scan/ slide window question, and it's a real interview problem of Google;
 *   if we assume a>b>c, then we have a - b + b - c + a - c = 2a - 2c = 2(a - c);
 *   the equation above means the final result we want is 2 times the max value minus the min value;
 *   then advance the min value , update max value minus min value again.
 *   after scan all the element of the three arrays, return the final result;
 */
public class MinimumDistanceOfThreePoints {
	public static int findMiniDistance(int[] A, int[] B, int[] C){
		int minValue = Integer.MAX_VALUE;
		int i = 0;//pointer of A
		int j = 0;//pinter of B
		int k = 0;//pointer of C
		
		while(true){
			if(i == A.length && j == B.length && k == C.length)
				break;
			int curMax = Math.max(A[i], Math.max(B[j], C[k])); // note1.
			int curMin = Math.min(A[i], Math.min(B[j], C[k])); // note2.
			int curValue = curMax - curMin;
			if(curValue < minValue)
				minValue = curValue;
			if(curMin == A[i]){
				if(i + 1 < A.length) i++;   // watch out here, it's i+1, not i. otherwise may cause out of bounds in lines of -
				else break;                 // - note1 and note2 after i reached the very last element of array. same below. 
			}else if(curMin == B[j]){
				if(j + 1 < B.length) j++;
				else break;
			}
			else {
				if(k + 1< C.length) k++;
				else break;
			}
		}
		
		return 2*minValue;	
	}
	
	public static void main(String[] args) {
		int[] a = {100};
		int[] b = {10, 20};
		int[] c = {1, 10000};
		
		System.out.println(MinimumDistanceOfThreePoints.findMiniDistance(a, b, c));
	}
}
