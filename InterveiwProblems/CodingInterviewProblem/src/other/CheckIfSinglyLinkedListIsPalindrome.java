package other;


import leetcodeLib.ListNode;
public class CheckIfSinglyLinkedListIsPalindrome {


	public static boolean isPalindrome(ListNode head){
		if(head == null || head.next == null) return true;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null) slow = slow.next;
		
		ListNode cur = slow, post = slow.next;
		ListNode tail;
		
		while(post != null){
			tail = post.next;
			post.next = cur;
			cur = post;
			post = tail;
		}
		
		slow.next = null;
		slow = cur;
		
		while(slow != null){
			if(head.val != slow.val) return false;
			head = head.next;
			slow = slow.next;
		}
		
		return true;	
	}
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		//ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node5;
		//node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		System.out.println(CheckIfSinglyLinkedListIsPalindrome.isPalindrome(node1));
	}
}
