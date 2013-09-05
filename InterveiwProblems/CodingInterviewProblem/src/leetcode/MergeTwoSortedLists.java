package leetcode;

/*
 * note, make use of "sorted"
 * we can create a new list with head node, and add proper node after head one by one. 
 */
import leetcodeLib.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode p = head;
            
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        
        if(l1!=null)
            p.next = l1;
        else if(l2!=null)
            p.next = l2;
            
        return head.next;
    }
	
	public static void main(String[] args) {

	}
}
