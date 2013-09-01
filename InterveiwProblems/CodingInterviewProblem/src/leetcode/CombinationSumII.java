package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        Arrays.sort(num);
        doComb(num, target, 0, 0, result, subResult);
        return result;    
    }
    
    public static void doComb(int[] num, int target, int pos, int curSum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subResult){
        if(curSum > target) return; 
        if(curSum == target){
            if(!result.contains(subResult)){
            result.add((ArrayList<Integer>)subResult.clone());
            return;
            }
            return;
        }
        
        for(int i = pos; i< num.length; i++ ){
            curSum+=num[i];
            subResult.add(num[i]);
            doComb(num, target, i + 1, curSum, result, subResult); 
            subResult.remove(subResult.size() - 1);                  
            curSum-=num[i];                                  
        }
    }
	public static void main(String[] args) {
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(CombinationSumII.combinationSum2(num, target));
		}
	}
