package leetcode;


/*
 * Remember how to get the height of a BT? max(get(root.left) + get(root.right)) + 1;
 * 
 * the idea is similar, but cannot directly use equation above, use this as note1. 
 */

import leetcodeLib.TreeNode;

public class MinimumDepthOfBinaryTree {
	
    public int minDepth(TreeNode root) {
        
        return minDepth(root, false);
          
      }
      
      public int minDepth(TreeNode node, boolean hasBrother){
          if(node == null)
              return hasBrother?Integer.MAX_VALUE:0;
          
          int minL = minDepth(node.left, node.right!=null);// note1.
          int minR = minDepth(node.right, node.left!=null);
          
          return Math.min(minL, minR) + 1;
      }
	
	public static void main(String[] args) {
	}
}
