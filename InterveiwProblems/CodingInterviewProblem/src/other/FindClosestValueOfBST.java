package other;


/*
 * don't forget note1 !
 * 
 */
import leetcodeLib.TreeNode;

public class FindClosestValueOfBST {
	
	public TreeNode getNode(TreeNode root, int value){
		if(root == null) return null;
		if(root.val == value) return root; // note1
		if(value < root.val){
			if(root.left == null) return root;
			TreeNode p = getNode(root.left, value);
			return Math.abs(p.val - value) < Math.abs(root.val - value)?p:root;
		}else{
			if(root.right == null) return root;
			TreeNode q = getNode(root.right, value);
			return Math.abs(q.val - value) < Math.abs(root.val - value)? q:root;
		}
	}
	
	public static void main(String[] args) {
	
	}
}
