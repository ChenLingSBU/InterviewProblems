package leetcode;

/*
 * The difference between SubsetsII and Subsets is that in SubsetsII it's allowed to have duplicates.
 * deal with duplicates problems(combination and permutation): 1. sort array first.
 * 															   2. in the recursion, add one more if statement as below. 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);  // requirement is non-descending order
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        result.add(new ArrayList<Integer>());     // don't forget null subsets!
        subsetsWithDup(num, 0,0, result, subResult);
        return result;
    }
    public static void subsetsWithDup(int[] num, int start, int level, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subResult){
        if(level == num.length)
            return;    
        for(int i = start; i<num.length; i++){
            if(i!=start && num[i] == num[i-1]){ // this statement deal with the duplicate case.
                continue;
            }
            subResult.add(num[i]);
            result.add((ArrayList<Integer>)subResult.clone());
            subsetsWithDup(num, i+1, level + 1, result, subResult);
            subResult.remove(subResult.size() - 1);
            }
        }
	
	public static void main(String[] args) {
		int[] num = {1,2,2};
		System.out.println(SubsetsII.subsetsWithDup(num));
	}
}
