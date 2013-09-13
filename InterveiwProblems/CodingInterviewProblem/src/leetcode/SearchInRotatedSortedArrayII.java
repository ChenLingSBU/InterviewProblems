package leetcode;

/*
 * All the same as Search In Rotated Sorted Array. 
 * Because in that problem, I have considered the duplicates situation.
 * 
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] A, int target) {
        return search(A, 0, A.length - 1, target);
        }

    
    public static boolean search(int[] A,int left, int right, int target){
         if(left > right)
            return false;
         int mid = (left + right)/2;
         if(A[mid] == target)
            return true;
        
        if(A[mid] < A[left]){// note 1
            if(target <=A[right] && target >= A[mid])  // note 2
                return search(A, mid + 1, right, target);
            else
                return search(A, left, mid - 1, target);
        }
        
        else if(A[mid] > A[left]){  //note 3;
            if(target >= A[left] && target <= A[mid])
                return search(A, left, mid - 1, target);
            else{
                return search(A, mid + 1, right, target);
            }
        }
        
        else if(A[mid] == A[left]){ // if there have dups in the array. 
            if(A[mid] < A[right]){
                return search(A, mid + 1, right, target);
            }
            else{
                boolean res = search(A, left, mid - 1, target);
                return res==false?search(A, mid + 1, right, target):res;
            }
        }
        
        return false;
    }
    
   
	public static void main(String[] args) {
		int[] A = {1,3,5};
		int target = 1;
		System.out.println(SearchInRotatedSortedArray.search(A, target));
	}
}
