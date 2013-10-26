package leetcode;



import leetcodeLib.RandomListNode;
import java.util.Hashtable;
public class CopyListWithRandomPointer {

	
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        Hashtable<RandomListNode, RandomListNode> nodeMap = new Hashtable<RandomListNode, RandomListNode>();
        return copyRandomList(head, nodeMap);
    }
    
    public static RandomListNode copyRandomList(RandomListNode head, Hashtable<RandomListNode, RandomListNode> nodeMap){
        if(head == null) return null;
        RandomListNode node = null;
        if(!nodeMap.containsKey(head)){
            node = new RandomListNode(head.label);
            nodeMap.put(head, node);
            node.next = copyRandomList(head.next, nodeMap);
            node.random = copyRandomList(head.random, nodeMap);
        }
        else{
            node = nodeMap.get(head);
        }
        return node;
    }
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(-1);
		head.next = null;
		head.random = null;
		CopyListWithRandomPointer.copyRandomList(head);
	}
}
