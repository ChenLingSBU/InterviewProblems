package other;

/*
 * There is a linked list of numbers of length N. N is very large and you don’t know N. 
 * You have to write a function that will return n random numbers from the list. 
 * Numbers should be completely random.  It should be done in O(n).
 * 
 * http://www.geeksforgeeks.org/reservoir-sampling/
 */
import leetcodeLib.ListNode;
import java.util.Random;
public class ReserviorSampling {

	public int[] randomSelectKItems(ListNode head, int n){
		int[] reservior = new int[n];
		ListNode node = head;
		int k = 0;
		Random random = new Random();
		while(node != null){
			if(k < n)
				reservior[k] = node.val;
			else{
				int j = random.nextInt(k + 1);
				if(j < n)
					reservior[j] = node.val;
			}
			node = node.next;
			k++;
		}
		return reservior;
	}
	
	public static void main(String[] args) {
		
	}
}
