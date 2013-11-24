package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import leetcodeLib.ListNode;
public class RemoveDuplicatesFromSortedList {
    
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead.next;
        ListNode cur = dummyHead.next.next;
        
        while(cur != null){
            if(pre.val == cur.val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        
        return dummyHead.next;
    }
    
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode cur = RemoveDuplicatesFromSortedList.deleteDuplicates(head);
		while (cur != null){
			System.out.print(" " + cur.val);
			cur = cur.next;
		}
	}

}
