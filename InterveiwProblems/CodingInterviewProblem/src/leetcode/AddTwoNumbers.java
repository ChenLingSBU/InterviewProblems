package leetcode;



import leetcodeLib.ListNode;
public class AddTwoNumbers {
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode cur = new ListNode(-1);
        ListNode dummyHead = cur;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 == null? 0 : l1.val;
            int val2 = l2 == null? 0 : l2.val;
            int val = val1 + val2 + carry;
            ListNode node = new ListNode(val%10);
            carry = val/10;
            cur.next = node;
            cur = cur.next;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
        }
        if(carry > 0)
            cur.next = new ListNode(1);
        return dummyHead.next;
    }
    
	public static void main(String[] args) {
		
	}
}
