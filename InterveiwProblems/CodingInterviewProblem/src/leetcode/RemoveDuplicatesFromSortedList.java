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
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return head;
        }
        ListNode newHead = head;
        ListNode cur = head;
        head = head.next;
        while(head != null){
            if(head.val == cur.val){
                head = head.next;
                continue;
            }
            else{
                cur.next.val = head.val;
                cur = cur.next;
                head = head.next;
            }
                
            
        }
        cur.next = null;
        return newHead;
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
