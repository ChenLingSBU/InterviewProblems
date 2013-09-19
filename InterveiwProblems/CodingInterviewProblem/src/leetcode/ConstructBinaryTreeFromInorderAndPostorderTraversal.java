package leetcode;



/*
 * The idea is similar as "Construct Binary Tree From Inorder and Preorder Traversal"
 * 
 * inorder is used to calculate the size of left subtree and right subtree
 * then we can get the index of current root in postorder. 
 */
import leetcodeLib.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0||postorder.length == 0) 
            return null;
        return buildTree(inorder,postorder,postorder.length - 1, 0, postorder.length);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int r, int start, int end){
        if(start >= end) return null;
        int val = postorder[r];
        TreeNode root = new TreeNode(val);
        int idx = 0;
        while(idx < end && inorder[idx] != val)
            idx++;
        if(idx > 0) 
            root.left = buildTree(inorder, postorder, r-end+idx, start, idx);//it's r - (end - idx), (end - idx) is the size of right subtree
        if(idx + 1 < end)
            root.right = buildTree(inorder,postorder,r-1, idx + 1, end);
        
        return root;
    }
	public static void main(String[] args) {
	
	}
}
