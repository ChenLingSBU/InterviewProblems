package leetcode;

/*
 * it's a classical slide window problem.
 * 
 * 1.The most straight forward method is count the total numbers of 0,1,and 2 seperately, and override the Array A accordingly.
 * 
 * 2.Use the pointers scan/slide window method, see codes below. 
 * 
 */

public class SortColors {
	
    public static void sortColors(int[] A) {
        int n = A.length; 
        int i = 0;     //0 pointer
        int j = n - 1; //1 pointer
        int k = n - 1; //2 pointer
        
        while(i <= j){        // i <= j, because all the elements after j are 1 and 2, both greater than 1.
            if(A[i] == 2){
                swap(A, i, k);
                k--;
                if(k < j)
                    j = k;
            }
            else if(A[i] == 1){
                swap(A, i, j);
                j--;
            }else
                i++;
        }
    }
    
    public static void swap(int[] A, int pos1, int pos2){
        int temp = A[pos1];
        A[pos1] = A[pos2];
        A[pos2] = temp;
    }
	public static void main(String[] args) {
		int[] A = {0, 1, 2, 2, 2, 1, 1, 1, 0};
		//int[] A = {1,0};
		SortColors.sortColors(A);
		for(int i = 0; i < A.length; i++){
			System.out.print("" + A[i] + " ");
		}
	}
}
