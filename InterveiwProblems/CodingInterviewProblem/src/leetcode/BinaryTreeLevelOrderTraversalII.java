package leetcode;


/*
 * reverse the result of the Binary Tree level order traversal......
 */

import leetcodeLib.TreeNode;
import java.util.ArrayList;
public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	       if(root == null) return result;
	       
	       levelOrderBottom(root, result,0);
	       ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>> ();
	       while(result.size() != 0){
	           finalResult.add(result.get(result.size() - 1));
	           result.remove(result.size() - 1);
	       }
	       return finalResult;
	    }
	    
	    public void levelOrderBottom(TreeNode root, ArrayList<ArrayList<Integer>> result, int level){
	        if(root == null) return;
	        if(result.size() == level){ // it's a new level that we haven't visited.
	            ArrayList<Integer> subResult = new ArrayList<Integer>();
	            subResult.add(root.val);
	            result.add(subResult);
	        }else{
	            ArrayList<Integer> subResult = result.get(level);
	            subResult.add(root.val);
	        }
	        
	        levelOrderBottom(root.left, result, level + 1);
	        levelOrderBottom(root.right, result, level + 1);
	        
	        return;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
