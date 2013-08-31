package leetcode;
import java.util.ArrayList;

public class Permutations {

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permute(num, 0);    
    }
    
    public static ArrayList<ArrayList<Integer>> permute(int[] num, int index){
        ArrayList<ArrayList<Integer>> permutation;
        
        if(index == num.length){//base case
              permutation = new ArrayList<ArrayList<Integer>>();
              ArrayList<Integer> perm = new ArrayList<Integer>();
              permutation.add(perm);// if it's permutation of String, we can use add("") indicate a null String.
              return permutation;
        }
        int item = num[index];
        ArrayList<ArrayList<Integer>> newPermutation = permute(num, index + 1);
        ArrayList<ArrayList<Integer>> morePermutation = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> subPerm:newPermutation){
        	if(subPerm.size() == 0){ // note here
        		subPerm.add(item);
        		morePermutation.add(subPerm);
        		break;
        	}else{
        	for(int i=0; i<=subPerm.size(); i++){// note here, the range of i is <= subPerm.size(), not <. 
        		ArrayList<Integer> newSubPerm = new ArrayList<Integer>();
        		newSubPerm.addAll(subPerm);
                newSubPerm.add(i, item);
                morePermutation.add(newSubPerm);
                }
        	}
        }
        return morePermutation;
   }
    
	public static void main(String[] args) {
		int[] num = new int[4];
		for(int i = 0; i<4; i++){
			num[i] = i+1;
		}
		
		System.out.println(Permutations.permute(num));

	}
}
