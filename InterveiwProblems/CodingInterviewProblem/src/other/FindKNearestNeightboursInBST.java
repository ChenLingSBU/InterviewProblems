package other;



/*
 * find K nearest neightbours to a Value in a BST.
 * 
 * note: when meet a BS/BST problem, we should think about those traversal.
 */
import java.util.Queue;
import java.util.LinkedList;
import leetcodeLib.TreeNode;
public class FindKNearestNeightboursInBST {

	public Queue<TreeNode> getKNearest(TreeNode root, int target, int K){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) return queue;
		getKNearest(root, target, K, queue);
		return queue;
	}
	
	public void getKNearest(TreeNode root, int target, int K, Queue<TreeNode> queue){
		if(root == null) return;
		getKNearest(root.left, target, K, queue);
		
		if(queue.size() < K ) queue.add(root);
		else{
			if(Math.abs(root.val - target) < Math.abs(queue.peek().val - target)){
				queue.poll();
				queue.add(root);
			}
		}
		
		getKNearest(root.right, target, K, queue);
	}

	public static void main(String[] args) {

	}
}
