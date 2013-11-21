package other;



public class BinearySearch {

	public static int binearySearch(int[] A, int target){
		
		int left = 0;
		int right = A.length - 1;
		
		while(left <= right){
			int mid = (left + right)/2;
			if(A[mid] > target){
				right = mid - 1;
			}else if(A[mid] < target){
				left = mid + 1;
			}else return mid;
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int target = 2;
		
		System.out.println(BinearySearch.binearySearch(A, target));
	}
}
