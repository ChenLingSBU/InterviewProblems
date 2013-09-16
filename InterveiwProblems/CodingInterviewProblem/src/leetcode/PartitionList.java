package leetcode;

/*
 *  This problem has tricky! we will get screwed if we wanna directly operate the nodes.
 *  
 *  Instead, we should use the tricky that we create two lists, one is less than x, the other is no-less than x, then connect them together!
 *  
 *  Notes: 
 *  		note1 avoid bugs that in case {1,1}, x = 0, in this case the first list is null;
 *  		note2, if we do not do this, the last element might have connection to the element in the original list. thus cause cycle bugs. 
 */


import leetcodeLib.ListNode;

public class PartitionList {
	
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode dummyFrontHead = new ListNode(Integer.MIN_VALUE);
        ListNode dummyFrontEnd = dummyFrontHead;
        
        ListNode dummyBackHead = new ListNode(Integer.MIN_VALUE);
        ListNode dummyBackEnd = dummyBackHead;
        
        ListNode cur = head;
        
        while(cur != null){
            if(cur.val < x){
                dummyFrontEnd.next = cur;
                dummyFrontEnd = dummyFrontEnd.next;
            }else{
                dummyBackEnd.next = cur;
                dummyBackEnd = dummyBackEnd.next;
            }
            
            cur = cur.next;
        }
        
        if(dummyBackHead.next != null)  //note1
            dummyFrontEnd.next = dummyBackHead.next;
        
        if(dummyBackEnd.next != null)  //note2
        	dummyBackEnd.next = null;
        
        
        return dummyFrontHead.next;
            
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
		
		ListNode head = PartitionList.partition(n1, x);
		
		while(head != null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		
		System.out.println("null");
	}
}
