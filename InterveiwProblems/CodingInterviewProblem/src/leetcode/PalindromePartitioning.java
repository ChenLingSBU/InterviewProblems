package leetcode;



/*
 * find all possible solutions, it's obviously that we should use DFS. 
 * make a better understand of DFS. 
 */
import java.util.ArrayList;
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> output = new ArrayList<String>();
        if(s == null || s.length() == 0) return result;
        dfs(s, result, output, 0);
        return result;
    }
    
    public void dfs(String s, ArrayList<ArrayList<String>> result, ArrayList<String> output, int start){
        if(start == s.length()){
            result.add((ArrayList<String>)output.clone());
            return;
        }
        
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                output.add(s.substring(start, i+1));
                dfs(s, result, output, i+1);
                output.remove(output.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
	
	public static void main(String[] args) {
	
	}
}
