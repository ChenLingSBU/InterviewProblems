package test;

import leetcodeLib.TreeNode;

public class MaxPathSum {

    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        
        int[] curMax = new int[1];
        curMax[0] = root.val;
        
        maxPathSum(root, curMax);
        
        return curMax[0];
    }
    
    public static int maxPathSum(TreeNode root, int[] curMax){
        if(root == null) return 0;
        
        int curValue = root.val;
        
        int leftMax = maxPathSum(root.left,  curMax);
        int rightMax = maxPathSum(root.right, curMax);
        
        int tmp = Math.max(leftMax, rightMax);
        int result = Math.max(curValue + tmp, curValue);
        
        int maxPath = curValue;
        maxPath = Math.max(maxPath, maxPath + leftMax);
        maxPath = Math.max(maxPath, maxPath + rightMax);
        curMax[0] = Math.max(maxPath, curMax[0]);
        
        return result;
        
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		System.out.println(MaxPathSum.maxPathSum(root));
	}
}
