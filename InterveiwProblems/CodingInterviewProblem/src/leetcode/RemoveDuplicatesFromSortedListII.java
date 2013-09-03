package leetcode;

import leetcodeLib.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode cur = newHead;
        boolean isDup;
        while(head!=null){
             isDup = false;
             while(head.next!=null && head.val == head.next.val){
                 isDup = true;
                 head = head.next;
             }
             if(isDup){
                 head = head.next;
                 cur.next = head;
                 continue;
             }
             cur.next = head;
             cur = cur.next;
             head = head.next;
        }
        
        return newHead.next;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		head = RemoveDuplicatesFromSortedListII.deleteDuplicates(head);
		while(head!=null){
			System.out.print(""+head.val+ " ");
			head=head.next;
		}	
	}
}
