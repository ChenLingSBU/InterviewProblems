package leetcode;


/*
 * it's 2dim DP, using rolling array. 
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        if(S.length() < T.length()) return 0;
        int[] matches = new int[T.length() + 1];
        matches[0] = 1;
        for(int i = 1; i <= T.length(); i++){
            matches[i] = 0;
        }
        
        for(int i = 1; i <= S.length(); i++){
            for(int j = T.length(); j >= 1; j--){
                if(S.charAt(i - 1) == T.charAt(j - 1))
                    matches[j] += matches[j - 1];
            }
        }
        
        return matches[T.length()];
    }
	
	public static void main(String[] args) {
	
	}
}
