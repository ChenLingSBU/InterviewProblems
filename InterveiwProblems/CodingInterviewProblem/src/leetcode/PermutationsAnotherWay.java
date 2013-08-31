package leetcode;
import java.util.ArrayList;
/*
 * it's the same problem as permutations, but the way for resolution is different. 
 * In this way, the codes look shorter
 */

public class PermutationsAnotherWay {

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        doPermute(num, 0, used, subResult, result);
        return result;
        
    }
    
    public static void doPermute(int[] num, int level, boolean[] used, ArrayList<Integer> subResult, ArrayList<ArrayList<Integer>> result){
        if(level == num.length){
            result.add((ArrayList<Integer>)subResult.clone());
            return;
        }
        
        for(int i = 0; i<num.length; i++){
            if(used[i])
                continue;
            subResult.add(num[i]);
            used[i] = true;
            doPermute(num, level +1, used, subResult, result);
            used[i] = false;
            subResult.remove(subResult.size() - 1);
        }
    }
	public static void main(String[] args) {
		int[] num = new int[4];
		for(int i = 0; i<4; i++){
			num[i] = i+1;
		}
		
		System.out.println(PermutationsAnotherWay.permute(num));
	}

}
