package leetcode;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int mergedIndex = m + n -1;// index of last element of new Array(merged Array)
        int lastA = m - 1;// index of last element of A
        int lastB = n - 1;
        while(lastB >= 0 && lastA >= 0){
            if(B[lastB] > A[lastA]){
                A[mergedIndex--] = B[lastB--];   
            }
            else{
                A[mergedIndex--] = A[lastA--];
            }
        }
        while(lastB >= 0){
            A[mergedIndex--] = B[lastB--];
        } 
        return;
    }
	public static void main(String[] args) {
		
	}
}
