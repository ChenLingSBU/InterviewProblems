package other;


/*
 * 	Get the intersection node of two linked lists.
 * There are two singly linked lists in a system. 
 * By some programming error the end node of one of the linked list got linked into the second list, 
 * forming a inverted Y shaped list. 
 * Write a program to get the point where two linked list merge
 */
import leetcodeLib.ListNode;
public class GetIntersection {

	public static ListNode getIntersection(ListNode l1, ListNode l2){
		
		int len1 = getLength(l1);
		int len2 = getLength(l2);
		ListNode tail1 = getTail(l1);
		ListNode tail2 = getTail(l2);
		
		if(tail1 != tail2) return null;
		
		ListNode longer = len1 >= len2?l1:l2;
		ListNode shorter = longer == l1? l2:l1;
		int difLen = Math.abs(len1 - len2);
		while(difLen > 0){
			longer = longer.next;
			difLen--;
		}
		
		while(shorter != null && longer != null){
			if(shorter == longer) return shorter;
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return null;
	}
	
	public static int getLength(ListNode l){
		if(l == null) return 0;
		int length = 0;
		while(l != null){
			l = l.next;
			length++;
		}
		
		return length;
	}
	
	public static ListNode getTail(ListNode l){
		if(l == null) return null;
		ListNode node = l;
		while(node.next != null)
			node = node.next;
		return node;
	}
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node6.next = node7;
		node7.next = node8;
		node8.next = node3;
		
		ListNode inter = GetIntersection.getIntersection(node1, node6);
		System.out.println(inter.val);
	}
}
