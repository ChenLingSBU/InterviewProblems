package leetcode;


/*
 * it's the same idea of I. but while recursion, do right child first. 
 * other wise will have some case cause error. eg: 21307912#10##88####7###
 */
import leetcodeLib.TreeLinkNode;
public class PopulatingNextRightPointersInEachNodeII {
    
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root.next;
        while(cur != null){
           if(cur.left != null || cur.right != null){
               cur = cur.left == null? cur.right:cur.left;
               break;
           }
           cur = cur.next;
        }
        
        if(root.left != null)
            root.left.next = root.right == null? cur:root.right;
        
        if(root.right != null)
            root.right.next = cur;
        
        connect(root.right);
        connect(root.left);
    }
	public static void main(String[] args) {
	
	}
}
