package leetcode;


/*
 * two methods: 
 * 
 * 1.) use one stack and prev flag to record the previous node.
 *     For this method, we have to deal with different cases. 
 * 2.) use two stack. See codes below. This method is toooooo magical!. 
 * 
 */

import leetcodeLib.TreeNode;
import java.util.ArrayList;
import java.util.Stack;
public class BinaryTreePostorderTraversal {

    public ArrayList<Integer> postorderTraversalTwoStack(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stackIn = new Stack<TreeNode>();
        Stack<TreeNode> stackOut = new Stack<TreeNode>();
        stackIn.push(root);
        while(!stackIn.isEmpty()){
            TreeNode node = stackIn.pop();
            stackOut.push(node);
            if(node.left != null)
                stackIn.push(node.left);
            if(node.right != null)
                stackIn.push(node.right);
        }
        
        while(!stackOut.isEmpty()){
            result.add(stackOut.pop().val);
        }
        
        return result;
    }
      
    
    public ArrayList<Integer> postorderTraversalOneStack(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur, prev;
        prev = null;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.peek();
            // go down left or right
            if(prev == null || prev.left == cur || prev.right == cur){
                if(cur.left != null)
                    stack.push(cur.left);
                else if(cur.right != null)
                    stack.push(cur.right);
            }else if(prev == cur.left){
            	// go up from left
                if(cur.right != null) stack.push(cur.right);
            }else{
            	// go up from right
                result.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        
        return result;
    }
    
    
    
    
	public static void main(String[] args) {

	}
}
