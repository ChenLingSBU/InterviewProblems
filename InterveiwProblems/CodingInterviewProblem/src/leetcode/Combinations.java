package leetcode;

import java.util.ArrayList;
/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,If n = 4 and k = 2, a solution is:
 * 
 * [2,4],[3,4],[2,3],[1,2],[1,3],[1,4]
 * 
 */

public class Combinations {
	public static  ArrayList<ArrayList<Integer>> combine(int n, int k){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>>result = new ArrayList<ArrayList<Integer>> ();
		int[]nums = init(n);
		combine(n, k, nums, 0, 0, subset, result);
		return result;
	}
	
	public static void combine(int n, int k, int[] nums, 
							   int level, int pos, 
							   ArrayList<Integer> subset, 
							   ArrayList<ArrayList<Integer>> result){
		if(level == k){
			result.add((ArrayList<Integer>)subset.clone()); // clone returns no type, we should cast type explicitly.
			return;
		}
		for(int i = pos; i < n; i++){
			subset.add(nums[i]);
			combine(n, k, nums, level+1, i+1, subset, result);
			subset.remove(subset.size() - 1);
		}
	}
	
	public static int[] init(int n){
		int[] nums = new int[n];
		for(int i = 0; i<n; i++){
			nums[i] = i+1;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = Combinations.combine(4, 2);
		System.out.println(result);
	}
}
