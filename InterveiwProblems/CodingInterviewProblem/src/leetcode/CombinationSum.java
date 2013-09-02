package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        Arrays.sort(candidates);
        doComb(candidates, target, 0, 0, result, subResult);
        return result;    
    }
    
    public static void doComb(int[] candidates, int target, int pos, int curSum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subResult){
        if(curSum > target) return; //this if statement avoids many useless recursions
        if(curSum == target){
        	if(!result.contains(subResult)){
                result.add((ArrayList<Integer>)subResult.clone());
                return;
                }
                return;
        }
        if(pos == candidates.length) return;
        
        for(int i = pos; i< candidates.length; i++ ){
            curSum+=candidates[i];
            subResult.add(candidates[i]);
            doComb(candidates, target, i, curSum, result, subResult); // because element can be repeated, so it's 'i' here
            subResult.remove(subResult.size() - 1);                   // if not allowed to repeat, here would be 'i+1'
            curSum-=candidates[i];                                   // don't forget remove last element. 
        }
    }
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(CombinationSum.combinationSum(candidates, target));
	}
}
