package leetcode;



import leetcodeLib.ListNode;
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
	public static void main(String[] args) {
	
	}
}
