package leetcode;


/*
 * find the second half of the list, reverse it, and insert it into the first half.
 */

import leetcodeLib.ListNode;
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode tmpHead = slow.next;
        slow.next = null;
        ListNode newHead = reverse(tmpHead);
        ListNode cur = head;
        ListNode newCur = newHead;
        while(cur != null && newCur != null){
            ListNode tmp = cur.next;
            cur.next = newCur;
            newCur = newCur.next;
            cur.next.next = tmp;
            cur = tmp;
        }
    }
    
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode post = cur.next;
        while(post != null){
            ListNode tmp = post.next;
            post.next = cur;
            cur = post;
            post = tmp;
        }
        dummyHead.next.next = null;
        dummyHead.next = cur;
        return dummyHead.next;
    }
    
	public static void main(String[] args) {
		
	}
}
