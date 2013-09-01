package leetcode;
/*
 * the Subsets problem is actually the same as combination problem.
 */


import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        
        Arrays.sort(S);  // requirement is non-descending order
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        result.add(new ArrayList<Integer>());     // don't forget null subsets!
        subsets(S, 0,0, result, subResult);
        return result;
    }
    public static void subsets(int[] S, int start, int level, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subResult){
        if(level == S.length)
            return;    
        for(int i = start; i<S.length; i++){
            subResult.add(S[i]);
            result.add((ArrayList<Integer>)subResult.clone());
            subsets(S, i+1, level + 1, result, subResult);
            subResult.remove(subResult.size() - 1);    
        }    
    }
	public static void main(String[] args) {
		int[] S = {1,2,3};
		System.out.println(Subsets.subsets(S));
	}
}
