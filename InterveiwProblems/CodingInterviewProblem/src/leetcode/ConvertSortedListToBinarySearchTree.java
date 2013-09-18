package leetcode;





import leetcodeLib.TreeNode;
import leetcodeLib.ListNode;
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int end = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            end++;
        }
        ListNode[] h = new ListNode[1];
        h[0] = head;
        return sortedListToBST(h, 0, end - 1);
     }
     
     public TreeNode sortedListToBST(ListNode[] head, int start, int end){
         if(start > end) return null;
         
         int mid = (start + end)/2;
         
         TreeNode leftChild = sortedListToBST(head, start, mid - 1);
         TreeNode root = new TreeNode(head[0].val);
         root.left = leftChild;
         head[0] = head[0].next;
         root.right = sortedListToBST(head, mid + 1, end);
         return root;
     }

	public static void main(String[] args) {
	
	}
}
