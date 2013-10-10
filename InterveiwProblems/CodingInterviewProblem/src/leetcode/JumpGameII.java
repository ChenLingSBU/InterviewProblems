package leetcode;

/*
 * current using method is greedy, another method is dp, will implent dp method later.
 * greedy:
 * record the longest distance last time and record the current longest distance.
 * it's obvious that current longest distance depends on the longest distance jump in last time.
 * when i > lastend(last longest distance), it means every possible value has been considered, and we need another jump.
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
