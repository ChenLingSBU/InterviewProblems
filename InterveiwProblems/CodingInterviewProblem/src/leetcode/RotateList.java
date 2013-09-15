package leetcode;

/*
 * note here, n might be lager than the length of the list.
 * 
 * The algorithm is a little bit tricky.
 * 
 * step 1: 
 * 		run from head to tail, to count the length of the list
 * step 2:
 * 		then connect tail and head by setting tail.next = head;
 * step 3:
 * 		then continue run k steps. k = length - n%length, then the next of cur is the new head, and set cur.next = null. 
 * step 4: 
 * 		return head;
 */

import leetcodeLib.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        
        if(head == null || head.next == null)  return head;
        
        if(n <= 0) return head;  
        ListNode cur = new ListNode(Integer.MIN_VALUE);
        cur.next = head;
        int count = 0;
        
        while(cur.next != null){
            cur = cur.next;
            count++;
        } 
        cur.next = head;
        
        int k = count - n%count;
        
        while(k >0){
            cur = cur.next;
            k--;
        }  
        head = cur.next;
        cur.next = null;
         
        return head;
        
    }
	public static void main(String[] args) {
		
	}
}
