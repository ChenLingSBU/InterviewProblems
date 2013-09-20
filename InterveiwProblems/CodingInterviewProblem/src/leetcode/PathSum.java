package leetcode;


/*
 * mistakes I made:
 * public boolean hasPathSum(TreeNode root, int sum, int result){ 
        if(root == null) return false;
        
        if(root.left == null && root.right == null && result == sum) return true;
   mistake:     boolean left = hasPathSum(root.left, sum, result + root.left.val);  
        boolean right = hasPathSum(root.right, sum , result + root.right.val); 
        return left||right;
    }
    
    cannot guarantee root.right is not null, thus may cause problem when access root.right.val when root is null.
 */

import leetcodeLib.TreeNode;

public class PathSum {
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        return hasPathSum(root, sum, 0);    
    }
    
    public boolean hasPathSum(TreeNode root, int sum, int result){ 
        if(root == null) return false;
        result += root.val;
        if(root.left == null && root.right == null && result == sum) return true;
        boolean left = hasPathSum(root.left, sum, result);
        boolean right = hasPathSum(root.right, sum , result); 
        return left||right;
    }

	public static void main(String[] args) {
	
	}
}
