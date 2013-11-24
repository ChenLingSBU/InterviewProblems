package leetcode;

/*
 *  This problem has tricky! we will get screwed if we wanna directly operate the nodes.
 *  
 *  Instead, we should use the tricky that we create two lists, one is less than x, the other is no-less than x, then connect them together!
 *  
 */


import leetcodeLib.ListNode;

public class PartitionList {
	
    public static ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        
        ListNode dummyFirst = new ListNode(-1);
        ListNode firstEnd = dummyFirst;
        ListNode dummySecond = new ListNode(-1);
        ListNode secondEnd = dummySecond;
        
        ListNode cur = head;
        
        while( cur != null){
            if(cur.val < x){
                firstEnd.next = cur;
                firstEnd = firstEnd.next;
            }else{
                secondEnd.next = cur;
                secondEnd = secondEnd.next;
            }
            
            cur = cur.next;
        }
        
        secondEnd.next = null;
        
        firstEnd.next = dummySecond.next;
        
        return dummyFirst.next;
    }
    
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		int x = 3;
		ListNode head = n1;
		while(head != null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		
		System.out.println("null");
		
		head = PartitionList.partition(n1, x);
		
		while(head != null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		
		System.out.println("null");
	}
}
