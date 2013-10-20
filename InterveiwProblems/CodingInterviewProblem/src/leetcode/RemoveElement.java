package leetcode;


public class RemoveElement {
	
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0) return 0;
        int p1 = 0;
        int p2 = 0;
       
        while(p2 < A.length){
            if(A[p2] != elem)
                A[p1++] = A[p2++];
            else
                p2++;
        }
        
        return p1;
    }
	public static void main(String[] args) {
	
		
	}
}
