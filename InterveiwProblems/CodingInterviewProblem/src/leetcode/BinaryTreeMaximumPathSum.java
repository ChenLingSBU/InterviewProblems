package leetcode;



/*
 * think about how many cases there are if we want to find the largest sum?
 * there are 4 cases:
 * 					1. root only
 * 					2. left + root
 * 					3. right + root
 * 					4. left + root + right
 * 
 * Thus every time we can calculate the leftMax and rightMax, then add root, and then find the maximum case in this 4 cases.
 * it's intuitively that we use post order traversal, every time return the largest left and largest right. 
 */
import leetcodeLib.TreeNode;
public class BinaryTreeMaximumPathSum {
	
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
	        int leftMax = maxPathSum(root.left, curMax);
	        int rightMax = maxPathSum(root.right, curMax);
	        int temp = Math.max(leftMax, rightMax);
	        int result = Math.max(curValue, curValue + temp);// maxmum of left or maxmum of right. 
	        int maxPath = curValue;
	        maxPath = Math.max(maxPath, maxPath + leftMax);
	        maxPath = Math.max(maxPath, maxPath + rightMax);
	        curMax[0] = Math.max(maxPath, curMax[0]);
	        return result;
	    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		
		System.out.println(BinaryTreeMaximumPathSum.maxPathSum(root));
	}
}
