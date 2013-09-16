package leetcode;

/*
 * note, according to the description of problem, we know 1<=m<=n<=length;
 * 
 * The idea is straight forward, we find the newHead node which at m, and tail node which at n, and reverse between m and n.
 * There's one buggy spot is don't forget to check this case : m = 1. like note1. 
 */

import leetcodeLib.ListNode;
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head == null || head.next == null) return head;
        
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode newHead = pre.next;
        ListNode tail = pre.next;
        int step = 0;
        while(step < n - 1){
            tail = tail.next;
            
            if(step < m - 1){
                newHead = newHead.next;
                pre = pre.next;
            }
            
            step++;
        }
        
        ListNode cur =newHead;
        ListNode post = cur.next;
        tail = tail.next;
        while(post != tail){
            ListNode temp = post.next;
            post.next = cur;
            cur = post;
            post = temp;
        }
       newHead.next = tail;
       pre.next = cur;
       
       if(newHead == head) //note1.
            return pre.next;
        else
            return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
