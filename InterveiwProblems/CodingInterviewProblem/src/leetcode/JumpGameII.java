package leetcode;

/*
 * classic two pointers algorithm.
 */

public class JumpGameII {
    public int jump(int[] A) {
        if(A.length == 1) return 0;
        int start = 0;
        int end = 0;
        int minJump = 0;
        
        while(start <= end){
            minJump++;
            int lastEnd = end;
            for(int i = start; i <= lastEnd; i++){
                int possibleDist = i + A[i];
                if(possibleDist >= A.length - 1)
                    return minJump;
                if(possibleDist > end)
                    end = possibleDist;
            }
            start = lastEnd + 1;
        }
        return 0;
    }
	

	public static void main(String[] args) {
		
	}
}
