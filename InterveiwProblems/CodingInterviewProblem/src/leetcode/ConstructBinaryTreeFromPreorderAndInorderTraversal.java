package leetcode;


/*
 * note, every node in the preorder array is a root, 
 * and if node n in the indorder array, all nodes left to n is n's left nodes, nodes right to n is n's right nodes, n is the root. 
 */
import leetcodeLib.TreeNode;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null||preorder.length == 0 || inorder.length == 0) return null;
        if(preorder.length != inorder.length) return null;
        int size = preorder.length;
        return buildTree(preorder, inorder, 0, 0, size);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int r, int start, int end){
        if(start >= end) return null;  //note, start >= end, incorrect if start > end
        int val = preorder[r];
        TreeNode root = new TreeNode(val);
        int idx = 0;
        while(idx < end && inorder[idx] != val)
            idx++;
        if(idx < end)
            root.left = buildTree(preorder, inorder, r + 1, start, idx);
        if(idx + 1 < end)
            root.right = buildTree(preorder,inorder, r + idx - start + 1, idx + 1, end);//(idx - start) is the number of nodes in the left side. 
        
        return root;
    }
	public static void main(String[] args) {
		
	}
}
