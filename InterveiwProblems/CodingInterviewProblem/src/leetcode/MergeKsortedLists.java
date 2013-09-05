package leetcode;
/*
 * two methods can solve this problem.
 * 1. similar to merge two sorted lists, but add one iterate layer.(it's easy and straightforward, not implemented here)
 * 2. use heap, see codes below;
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import leetcodeLib.ListNode;

public class MergeKsortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
             return null;
         
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
          public int compare(ListNode n1, ListNode n2){
              if(n1.val < n2.val)
                 return -1;
              if(n1.val > n2.val)
                 return 1;
              else
                 return 0;
          }
        };
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
        for(int i = 0; i < lists.size(); i++){
            ListNode node = lists.get(i);
            if(node!=null){
                heap.add(node);
            }
        }
        
        ListNode head = null;
        ListNode cur = null;
        
        while(!heap.isEmpty()){
            ListNode newNode = heap.poll();
            if(head == null){
                head = newNode;
                cur = head;
                if(cur.next!=null)
                     heap.add(cur.next);    
            }else{
                cur.next = newNode;
                cur = cur.next;
                if(cur.next != null)
                     heap.add(cur.next);
            }
        } 
        return head;
     }
	
    public static void main(String[] args) {
		
	}

}
