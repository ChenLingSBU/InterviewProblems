package other;



/*
 *  Find the max and min elements of an unsorted integer array using a minimal number of comparisons
 *  
 *  
 *  solution:This algorithm has a runtime complexity of: O( (3n/2) - 2 ).
 *  The first loop has a complexity of n/2. We start at the first element, 
 *  and for each pair of elements following that we perform a test to see which is higher. 
 *  The higher number goes into the even index, while the smaller goes into the odd index. 
 *  So, at the end of this loop, we know that the maximum lies in an even index, and the minimum lies in an odd index.
 *  The following 2 loops takes n/2 - 1. We only need to go through half the elements to find the maximum, 
 *  and the other half for the minimum. 
 *  The -1 comes from the fact that we don't look at the first number 
 *  in each of those subsets because we initialize our max/min variables to those values.
 *  Thus, summing the complexity of each loop:
 *  = n/2 + n/2 - 1 + n/2 - 1
 *  = n/2 + n - 2= 3n/2 - 2
 *  O( (3n/2) - 2 )
 */
public class FindMaxAndMin {

	
	public static int max, min;
	
	public  void getMaxMin(int[] a){
		int n = a.length;
		if(n <= 0) return;
		if(n == 1){
			max = min = a[0];
			return;
		}
		

		for(int i = 0; i + 1 < n; i += 2){
			if(a[i] < a[i + 1]){
				int tmp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = tmp;
			}
		}
		
		min = a[1];
		max = a[0];
		
		for(int i = 2; i < n; i += 2)
			if(max < a[i]) max = a[i];
		
		
		for(int i = 3; i < n; i += 2)
			if(min > a[i]) min = a[i];
			
	    if(n % 2 == 1) min = Math.min(min, a[n - 1]);
	}
	
	// O(2n) time
	public  void getMaxMinOn(int[] a){
		int n = a.length;
		if(n <= 0) return;
		if(n == 1){
			max = min = a[0];
			return;
		}
		
		max = min = a[0];
		
		for(int ele : a){
			max = Math.max(max, ele);
			min = Math.min(min, ele);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {0,4,1,8,2,3,7,5,6};
		FindMaxAndMin find = new FindMaxAndMin();
		find.getMaxMin(a);
		//find.getMaxMinOn(a);
		System.out.println(max);
		System.out.println(min);
	}
}
