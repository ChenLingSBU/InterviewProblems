package leetcode;
/*
 * for this problem, we usually make use of the BST property. 
 * There are some different solutions, but the version below is a simple and neat solution.
 */

import leetcodeLib.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        
        return checkBST(root, min, max);
         
     }
     
     public boolean checkBST(TreeNode node, int min, int max){
         if(node == null) return true;
         if(node.val <= min || node.val >= max) return false;
         
         if(!checkBST(node.left, min, node.val) || !checkBST(node.right, node.val, max)) return false;
         
         return true;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
