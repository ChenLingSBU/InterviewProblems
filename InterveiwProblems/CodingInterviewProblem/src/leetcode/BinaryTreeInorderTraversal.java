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
	    TreeNode  node = root;
	    stack.push(node);
	    while(!stack.isEmpty()){
	        if(node != null && node.left != null){ //block 1.  here node != null is used to judge the result of node 1. 
	            node = node.left;
	            stack.push(node);
	        }else{
	            node = stack.pop();
	            result.add(node.val);
	            if(node.right != null){
	                node = node.right;
	                stack.push(node);
	            }else
	                node = null; // note 1: don't forget this, otherwise can jump over block1. 
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
