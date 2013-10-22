package leetcode;


/*
 * pre-order traversal.
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
import leetcodeLib.TreeLinkNode;
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null)
            root.right.next = root.next == null? null:root.next.left;
        connect(root.left);
        connect(root.right);
        
    }

	public static void main(String[] args) {
	
	}
}
