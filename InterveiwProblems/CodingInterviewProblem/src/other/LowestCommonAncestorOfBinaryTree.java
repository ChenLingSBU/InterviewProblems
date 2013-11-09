package other;


/*
 * Find the lowest common ancestor of two given nodes in a given binary tree
 */
import leetcodeLib.TreeNode;
public class LowestCommonAncestorOfBinaryTree {
	
	
	public static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		if(root == q || root == p) return root;
		TreeNode L = getLCA(root.left, p, q);
		TreeNode R = getLCA(root.right, p, q);
		if(L != null && R != null) return root;
		return L != null ? L:R;
	}
	
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		System.out.println(LowestCommonAncestorOfBinaryTree.getLCA(node1, node5, node6).val);
		
	}
}
