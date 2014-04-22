package other;

/*
 * it's a real onsite interview problem from Marin.
 * problem:
 * Give an integer array, the range of each element in this array is between 1 and N, 
 * The length of this array is N + 1.
 * Question:
 * 1.) what can we infer from the description above?
 * ans: there must have duplicate element in this array.(Pigeonhole principle)
 * 
 * 2.) find any one duplicate element in this array,
 * 	   requirements: 1.) in place
 * 					 2.) no extra space 
 * 					 3.) cannot modify elements.
 * use binary search method. 
 * notice: Usually in binary search, the start and end point is the index, but here the start and end is the value,
 * it's in the value space.
 */



public class FindDuplicate {
	
	public static int findDup(int[] a){
        int n=a.length-1;
        int start=1, end=n,mid=0,count=0;
        while(start<end){
        	mid=(start + end)/2;
            count=0;
            for(int i=0;i<=n;i++){
            	if(a[i]<=mid)
            		count++;
            	}
            if(count<=mid)
            	start=mid+1;
            else
            	end=mid;
        }
        return start;
    }

	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,6};
		System.out.println(FindDuplicate.findDup(a));
	}
}
