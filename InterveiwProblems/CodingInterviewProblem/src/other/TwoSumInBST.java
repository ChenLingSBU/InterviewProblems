package other;



/*
 * Given a BST and a value x. Find two nodes in the tree whose sum is equal x. 
 * Additional space: O(height of the tree). It is not allowed to modify the tree.
 * 
 * idea: think about how to solve this problem if the data structure is an int array?
 * we could borrow this big idea. but how to get the min and max value in a BST? 
 * for min, use inorder traversal, for max, use reverse inorder traversal!
 * use two stacks to store the previous node of current node.
 * 
 * notes: for note1 and note2, don't forget to judge whether the current node is root!
 */
import leetcodeLib.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

public class TwoSumInBST {


	public static ArrayList<TreeNode> getNodes(TreeNode root, int target){
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if(root == null) return result;
		Stack<TreeNode> stackMin = new Stack<TreeNode>();
		Stack<TreeNode> stackMax = new Stack<TreeNode>();
		
		TreeNode nodeMin = root, nodeMax = root;
		
		while(nodeMin != null){
			stackMin.push(nodeMin);
			nodeMin = nodeMin.left;	
		}
		
		while(nodeMax != null){
			stackMax.push(nodeMax);
			nodeMax = nodeMax.right;
		}
					
		do{
			nodeMin = stackMin.peek();
			nodeMax = stackMax.peek();
			
			if(nodeMin.val + nodeMax.val == target){
				result.add(nodeMin);
				result.add(nodeMax);
				return result;
			}else if(nodeMin.val + nodeMax.val < target){
				if(nodeMin != root) stackMin.pop(); //note1
				nodeMin = stackMin.peek();
				if(nodeMin != root && nodeMin.right != null ){ //note2
					nodeMin = nodeMin.right;
					while(nodeMin != null){
						stackMin.push(nodeMin);
						nodeMin = nodeMin.left;
					}
				}
			}else { //nodeMin.val + nodeMax.val > target
				if(nodeMax != root)stackMax.pop();
				nodeMax = stackMax.peek();
				if(nodeMax != root && nodeMax.left != null){
					nodeMax = nodeMax.left;
					while(nodeMax != null){
						stackMax.push(nodeMax);
						nodeMax = nodeMax.right;
					}
				}
			}
			
		}while(stackMin.peek() != stackMax.peek());
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(10);
		
		root.left = node1;
		node1.left = node2;
		root.right = node3;
		
		ArrayList<TreeNode> result = TwoSumInBST.getNodes(root, 4);
		for(TreeNode node:result){
			System.out.println(node.val);
		}
	}
}
