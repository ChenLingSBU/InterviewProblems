package leetcode;


/*
 *  swap nodes in every two nodes.
 */

import leetcodeLib.ListNode;
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode pre = new ListNode(-1);
        ListNode dummy = pre;
        pre.next = head;
        ListNode cur = head;
        ListNode post = cur.next;
        while(post != null){
            ListNode tmp = cur;
            cur.next = post.next;
            post.next = cur;
            pre.next = post;
            if(cur.next == null) break;
            post = cur.next.next;
            cur = cur.next;
            pre = tmp;
        }      
        return dummy.next;     
    }
	
	public static void main(String[] args) {
	
	}
}
