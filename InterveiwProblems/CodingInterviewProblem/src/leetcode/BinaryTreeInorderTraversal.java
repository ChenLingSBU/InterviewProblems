package leetcode;

import leetcodeLib.TreeNode;
import java.util.ArrayList;
import java.util.Stack;
/*
 * For example: 
 * Given binary tree {1,#,2,3}, return [1,3,2]
 * 
 * note: do it iteratively.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeInorderTraversal {

	public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	if( root != null&&root.left !=null){
        		root = root.left;
        		stack.push(root);
        	}
        	else{
        		root = stack.pop();
        		result.add(root.val);
        		if(root.right != null){
        			root = root.right;
        			stack.push(root);
        		}else{
        			root = null; //don't forget this case. 
        		}
        	}
         }
        
        return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = null;
		ArrayList<Integer> result = BinaryTreeInorderTraversal.inorderTraversal(root);
		System.out.println(result);
	}
}
