package leetcode;

import leetcodeLib.TreeNode;

public class BalancedBinaryTree {

	   public boolean isBalanced(TreeNode root) {
	       if(root == null) return true;
	       int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
	       if(diff > 1) return false;
	       else return isBalanced(root.left) && isBalanced(root.right);
	        
	    }
	    
	    public int getHeight(TreeNode root){
	        if(root == null) return 0;
	        
	        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	    }
	    
	public static void main(String[] args) {
		
	}
}
