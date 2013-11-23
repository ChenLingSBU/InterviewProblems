package leetcode;

/*
 * we can use Bucket sort here, but we need do a little modification here.
 * The idea of Bucket sort is straight forward here, but there are a few tricks that to make the codes without bugs. 
 * And the codes below can also deal with the cases with duplicates. 
 * In bucket sort: if A[i] != i, swap A[i] and A[A[i]], but here we cannot use this mapping.
 * think about what if there's only one element in A, like A = {1}. 
 * if we use A[0] = A[A[0]], it will cause index of A out of bonds. 
 * so I use A[i] = i + 1 to solve this problem.
 * 
 * Notes: 
 * 		note1: use A[i] != i + 1;
 * 		note2: be careful of the corner cases, if A[i] <= 0, we should break. and A[i] == A[A[i] - 1] is used to deal with duplicates.
 * 
 */

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        
        for(int i = 0; i < n; i++){
            while(A[i] != i + 1){  // note 1
             if(A[i] <= 0 || A[i] > n || A[i] == A[A[i] - 1]) // note 2
                 break;
             int temp = A[i];
             A[i] = A[temp - 1];
             A[temp - 1] = temp;
             }
            }   
        for(int i = 0; i< n; i++)
            if(A[i] != i + 1)
                 return i + 1;
        return n + 1;    
     }
	
	public static void main(String[] args) {
		int[] A = {3,-1,23,7,21,12,8,9,18,21,-1,16,1,13,-3,22,23,13,7,14,3,6,4,-3};
		//int [] A ={1};
		System.out.println(FirstMissingPositive.firstMissingPositive(A));
	}
}
