package leetcode;

/*
 * this problem is classic two pointers scan problem.
 * the idea is find the largest element in A, and mark it as middle element,
 * Scan from left to middle,
 * Scan from right to middle.
 * 
 * PS: mid is the index of the largest element in A. mid is the index!!
 */
public class TrappingRainWater {
	public static int trap(int[] A){ 
	        if(A == null || A.length == 0)
	             return 0;
	        int h = 0;
	        int water = 0;
	        int mid = 0;  //find the largest element in A as mid element, then scan from two sides of A to mid. 
	        
	        for(int i = 0; i < A.length; i++){
	            if(A[mid] < A[i])
	                 mid = i;
	        }
	       
	        // scan from left
	        for(int i = 0; i <  mid; i++){
	            if(h > A[i])
	                 water+= h - A[i];
	            else
	                 h = A[i];
	        }
	        
	        //scan from right
	        h = 0;
	        for(int i = A.length - 1; i > mid; i--){
	            if(h > A[i])
	                 water+=h - A[i];
	             else
	                 h = A[i];
	        } 
	        return water;
	     }
	
	
	public static void main(String[] args) {
		int[] array = { 0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(TrappingRainWater.trap(array));

	}

}
