package leetcode;



 
import leetcodeLib.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode mr = mostRight(cur.left);
                mr.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
        
    }
    
    public TreeNode mostRight(TreeNode node){
        while(node != null && node.right != null)
            node = node.right;
        
        return node;
    }
	

	public static void main(String[] args) {
		
	}
}
