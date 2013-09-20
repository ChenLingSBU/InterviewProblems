package leetcode;




/*
 * notes: watch out note1 and note2, note 1 means when reach the leaf, and find the path, remove the last element.
 * note 2 means every time finishes one attempt to left and right, when go back to last call, we should remove the last element. 
 * think about note 1 and note 2.
 */

import java.util.ArrayList;
import leetcodeLib.TreeNode;
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> subResult = new ArrayList<Integer> ();
        if(root == null) return result;
        pathSum(root, sum, result, subResult, 0);
        return result;
     }
     
     public void pathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subResult,int res){
         if(root == null){
             return;
         } 
         res += root.val;
         subResult.add(root.val);
         if(root.left == null && root.right == null && res == sum ){
             result.add((ArrayList<Integer>)subResult.clone());
             subResult.remove(subResult.size() - 1);    // note 1
             return;
             }
         
         pathSum(root.left, sum, result, subResult, res);
         pathSum(root.right, sum, result, subResult, res);
         subResult.remove(subResult.size() - 1); //note2
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
