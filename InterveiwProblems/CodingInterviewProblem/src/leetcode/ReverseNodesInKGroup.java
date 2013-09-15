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
            if(head == null) return null;
            if(head.next == null || k == 1)
                return head;
                
            ListNode newHead = new ListNode(Integer.MIN_VALUE);
            newHead.next = head;
            ListNode cur = head;
            ListNode pre = newHead;
            ListNode post = cur.next;
            
            while(cur != null){
                int step = 0;
                post = cur.next;
                while(step < k - 1 && post != null){
                    ListNode temp = post.next;
                    post.next = cur;
                    cur = post;
                    post = temp;
                    step++;
                }
                
                if(step != k - 1){ // note 1.     
                    ListNode temp = post; // note 2. 
                    post = cur;
                    cur = temp;
                    k = 0;
                    while(k < step){
                        temp = post.next;
                        post.next = cur;
                        cur = post;
                        post = temp;
                        k++;
                    }                  
                    break;
                }              
                ListNode temp = pre.next;
                pre.next = cur;
                temp.next = post;
                pre = temp;
                cur = pre.next;        
            }
            
            return newHead.next;
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
