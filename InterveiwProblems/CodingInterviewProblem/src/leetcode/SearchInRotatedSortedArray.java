package leetcode;

/*
 * The idea is straight forward, as the array was originally sorted, even if we rotate the array at some point, 
 * it's guaranteed that at least half of the array is in a normal order. 
 * So, we make two partitions at the mid point of the array and to check which part of this array is in a normal order.
 * then we check whether the target is in the range of the half normal order array. if not we have to search in the other half of the array. 
 * 
 * pitfalls here, mistakes I made was :
 * note1, note 3: to check which part of the array is in a normal order, we have to compare A[mid] with A[left]. 
 * cannot be compare  mid with left at note1, and compare mid with right at note3. 
 * 
 * note2: to check whether target is in the range of the half array, we should use >= A[mid], not A[mid + 1]/A[mid - 1], otherwise will cause a bug.
 */

public class SearchInRotatedSortedArray {
    public static int search(int[] A, int target) {
        return search(A, 0, A.length - 1, target);
        }

    
    public static int search(int[] A,int left, int right, int target){
         if(left > right)
            return -1;
         int mid = (left + right)/2;
         if(A[mid] == target)
            return mid;
        
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
                int res = search(A, left, mid - 1, target);
                return res==-1?search(A, mid + 1, right, target):res;
            }
        }
        
        return -1;
    }
	public static void main(String[] args) {
		int[] A = {1,3,5};
		int target = 1;
		System.out.println(SearchInRotatedSortedArray.search(A, target));
	}
}