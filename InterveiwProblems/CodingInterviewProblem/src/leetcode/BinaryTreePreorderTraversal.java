package leetcode;


import java.util.ArrayList;
import java.util.Stack;
import leetcodeLib.TreeNode;
public class BinaryTreePreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        result.add(root.val);
        TreeNode node = root.left;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                result.add(node.val);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        
        return result;
    }
    
	public static void main(String[] args) {

	}
}
