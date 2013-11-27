package leetcode;


/*
 * the idea of the solution of this problem is very straight forward. 
 * However, it's very easy to make bugs. 
 * Be careful to deal with all kinds of pointers. 
 * 
 * mistakes I made: 
 * 1. misunderstand the problem it self, it's reverse all the nodes with length of k, not only swap the first and the kth node;
 * 2. when meet this case, {1,2} 1, I always to make a cycle 1->2->1. be careful.
 */

import leetcodeLib.ListNode;
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        if(head.next == null || k == 1) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
    
        while(cur != null){
            
            int step = 0;
            ListNode post = cur.next;
            while(step < k - 1 && post != null){
                ListNode tmp = post.next;
                post.next = cur;
                cur = post;
                post = tmp;
                step++;
            }
            
            if(step != k - 1){
                
                while(step >= 0){
                    ListNode tmp = cur.next;
                    cur.next = post;
                    post = cur;
                    cur = tmp;
                    step--;
                }
                
                break;
            }
            
            
            ListNode tmp = pre.next;
            tmp.next = post;
            pre.next = cur;
            pre = tmp;
            cur = pre.next;
        }
        
        return dummyHead.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		int k = 2;
		ListNode head = ReverseNodesInKGroup.reverseKGroup(n1, k);
		
		while(head!=null){
			System.out.print(head.val);
			System.out.print(" -> ");
			head = head.next;
		}
		System.out.println("null");
	}
}
