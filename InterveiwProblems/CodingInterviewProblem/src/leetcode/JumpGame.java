package leetcode;

/*
 * cur is the index.
 * 
 * it's false that if the code was like this:
 * for( int i = cur - 1; i >= 0; i--){
            if(A[i] >= cur - i)
                cur = i;
            else
                break;
        }  
 * consider this case : [2, 0, 0], actually the result should be true, but if written like above, the result is false;
 */

public class JumpGame {

    public boolean canJump(int[] A) {
        int cur = A.length - 1;
        
        for( int i = cur - 1; i >= 0; i--){
            if(A[i] >= cur - i)
                cur = i;
        }  
        return cur == 0;   
    }
	
	public static void main(String[] args) {
		
		
	}
}
