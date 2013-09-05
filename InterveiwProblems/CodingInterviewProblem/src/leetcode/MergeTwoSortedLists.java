package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * note: here lists two algorithms for solution
 * 1.  make use of "sorted"
 * 		we can create a new list with head node, and add proper node after head one by one. 
 * 
 * 2. use Heap. 
 */
import leetcodeLib.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoListsTwoPointers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode p = head;
            
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        
        if(l1!=null)
            p.next = l1;
        else if(l2!=null)
            p.next = l2;
            
        return head.next;
    }
    
    
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
        	return null;

Comparator<ListNode> comparator = new Comparator<ListNode>() {
	public int compare(ListNode n1, ListNode n2) {
		if (n1.val < n2.val)
			return -1;
		else if (n1.val > n2.val)
			return 1;
		else
			return 0;
		}
	};

	PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(2, comparator);
	ListNode head = null;
	ListNode cur = null;
	if(l1!=null)
		heap.add(l1);
	if(l2!=null)
		heap.add(l2);
	while(!heap.isEmpty()) {
		if (head == null) {
			head = heap.poll();
			cur = head;
			if (cur.next != null)
				heap.add(cur.next);
			} else {
				ListNode newNode = heap.poll();
				cur.next = newNode;
				cur = newNode;
				if (cur.next != null)
					heap.add(cur.next);
				}
		}
	return head;
	}
	
	public static void main(String[] args) {

	}
}
