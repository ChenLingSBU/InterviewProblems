package leetcode;
/*
 * when deal with duplicates, we can sort the array first, and then use a boolean array(here used[] for instance) for help. 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationII {
	
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result =  new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);// note here, sort is a key step. 
        doPermute(num, 0, used, subResult, result);
        return result;
    }
    
    public static void doPermute(int[] num, int level, boolean[] used, ArrayList<Integer> subResult, ArrayList<ArrayList<Integer>> result){
        if(level == num.length){
            result.add((ArrayList<Integer>)subResult.clone());
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if(used[i] || i!=0 && num[i] == num[i-1] && used[i - 1])// if without the conditions after ||, it's a standard problem of permutation.
                continue;
            subResult.add(num[i]);
            used[i] = true;
            doPermute(num, level+1, used, subResult, result);
            subResult.remove(subResult.size() - 1);
            used[i] = false;
        }
    }
    
	public static void main(String[] args) {
		int[] num = new int[3];
		num[0] = 1;
		num[1] = 1;
		num[2] = 2;
		System.out.println(PermutationII.permuteUnique(num));
		}
	}
