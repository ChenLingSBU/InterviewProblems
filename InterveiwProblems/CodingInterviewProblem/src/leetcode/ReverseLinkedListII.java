package leetcode;

/*
 * note, according to the description of problem, we know 1<=m<=n<=length;
 * 
 */

import leetcodeLib.ListNode;
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode pre = dummyHead;
        ListNode post;
        
        int step = n - m;
        
        while(m > 0){
            cur = cur.next;
            m--;
        }
        
        post = cur.next;
        
        while(pre.next != cur)
            pre = pre.next;
        
        while(step > 0 && post != null){
            ListNode tmp = post.next;
            post.next = cur;
            cur = post;
            post = tmp;
            step--;
        }
        
        pre.next.next = post;
        pre.next = cur;
        
        return dummyHead.next;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
