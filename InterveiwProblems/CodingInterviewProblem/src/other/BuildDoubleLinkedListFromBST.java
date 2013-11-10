package other;


/*
 * Build Double LinkedList From BST.
 * inorder BST traversal.
 */
import leetcodeLib.DoubleListNode;
import leetcodeLib.TreeNode;
public class BuildDoubleLinkedListFromBST {

	DoubleListNode head = null;
	DoubleListNode end = null;
	public void buildDoubleLinkedList(TreeNode root){
		TreeNode temp = root;
		if(temp == null) return;
		
		buildDoubleLinkedList(temp.left);
		
		DoubleListNode tmp = new DoubleListNode(temp.val);
		tmp.left = end;
		if(end == null){
			head = end = tmp;
		}else{
			end.right = tmp;
			end = tmp;
		}
		
		buildDoubleLinkedList(temp.right);	
	}
	
	public static void main(String[] args) {
	
	}
}
