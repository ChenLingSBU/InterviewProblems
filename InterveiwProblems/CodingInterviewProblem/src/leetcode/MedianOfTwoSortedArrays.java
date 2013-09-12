package leetcode;
import java.util.Arrays;

/*
 * For this problem, it's much straight forward if the requirement is in O(n), we just simply merge them and then find the median element. 
 * But here, it's O(log(n+m)) required, it's more like we should do it in a Binary Search way. and thus, this problem is transfered to 
 * find Kth element in two sorted Arrays.
 * we have to consider two situations, one is the total length of A and B is odd, the other situation is even.
 * 1.) even case:
 * 	   we should add the ((m+n)/2)th element and ((m+n)/2+1)th element, and them divided by 2. 
 * 2.) odd case:
 * 	  in this case, the median element is ((m+n)/2 + 1)th element;
 *    
 * notes: m and n is the length of B and A, but m/2 and n/2 is the index of the median of B and A.(Because int type divide operation, it's a little bit confused though)
 * note1. because m/2 and n/2 indicate the index, while k starts from 1, indicate kth element, so here we should use m/2 + n/2 + 1. 
 * note2. pay attention to Arrays.copyOfRange method, here is a pitfall that the second argument of this method is not the length, 
 *        it indicates the index of last element(exclusive). so second arg = first arg + length. I spent lots of time debugging in this method for the second argument.
 * 		  
 */


public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        if((m + n) % 2 == 0){
            return (getMedian(A, B, (m+n)/2) + getMedian(A, B, (m+n)/2 + 1))/2.0;
        }else{
            return getMedian(A, B, (m + n)/2 + 1);
        }
         
     }
     
     public static double getMedian(int A[], int B[], int k){
         int n = A.length;
         int m = B.length;
         if(n <= 0) return B[k - 1];
         if(m <= 0) return A[k - 1];
         if(k <= 1) return Math.min(A[0], B[0]);
         
         if(A[n/2]>=B[m/2]){
             if(n/2 + m/2 + 1 >= k){ // note1.
                 return getMedian(Arrays.copyOfRange(A, 0, n/2), B, k);
             }else
                 return getMedian(A, Arrays.copyOfRange(B, m/2 + 1,m/2 + 1+ m - m/2 -1 ), k - m/2 -1); // note2
         }
        else{
             if(n/2 + m/2 + 1 >= k){
                 return getMedian(A, Arrays.copyOfRange(B, 0, m/2), k);
             }else{
                 return getMedian(Arrays.copyOfRange(A, n/2 + 1 ,n/2+1 + n - n/2 -1),B, k - n/2 -1);
             }
         }
     }
	public static void main(String[] args) {
		int[] A = {4};
		int[] B = {1,2,3,4,5,6,7,8,9};
		System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(A, B));	
	}
}
