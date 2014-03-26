package other;

/*
 * find number which is more than half in an array.
 * 
 * Analysis: throw away two different numbers each time until cannot find any two different numbers. 
 * The left numbers are what we are looking for.
 * 
 * Run time complexity is O(n). 
 */


public class MoreThanHalf {

	public static int findNumber(int[] A){
		if(A == null || A.length == 0) return -1;
		int candidate = A[0];
		int count = 1;
		
		for(int i = 1; i < A.length; i++){
			if(count == 0){
				candidate = A[i];
				count++;
			}else{
				if(candidate == A[i]) count++;
				else count--;
			}
		}
		
		return candidate;
	}
	

	public static void main(String[] args) {
		int[] A = {1, 2, 4, 4, 4, 4, 3};
		System.out.println(MoreThanHalf.findNumber(A));
	}

}
