package leetcode;


/*
 * 1. be careful of the case that p1.next = head. like {1->2->3->null}, n = 3. 
 * 2. remember it's p1.next = p1.next.next. not p1 = p1.next;
 */
import leetcodeLib.ListNode;

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

public class RemoveNthNodeFromEndOfList {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode tail = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        
        while(n - 1 > 0){
            tail = tail.next;
            n--;
        }
        
        while(tail.next != null){
            tail = tail.next;
            cur = cur.next;
            pre = pre.next;
        }
        
        pre.next = cur.next;
        cur.next = null;
        
        return dummyHead.next;
        
    }
	
    
    public static void main(String[] args) {
		
	}

}
