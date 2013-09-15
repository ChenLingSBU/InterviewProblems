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
        if(head.next == null) return null; // {1}, 1
        
        ListNode p1 = new ListNode(Integer.MIN_VALUE);
        
        p1.next = head;
        ListNode p2 = p1;
        
        for(int i = 0; i < n; i++){
            if(p2.next != null)
                p2 = p2.next;
        }
        
        while(p2!=null && p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        
        if(p1.next == head){
            return p1.next.next;
        }
        p1.next = p1.next.next;
        
        return head;    
    }
	
    
    public static void main(String[] args) {
		
	}

}
