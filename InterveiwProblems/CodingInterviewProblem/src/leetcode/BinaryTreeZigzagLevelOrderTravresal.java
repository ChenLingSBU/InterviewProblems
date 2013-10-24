package leetcode;

/*
 * just scan level by level
 * set up a flag to see whether need to reverse the order of that level.
 */

import java.util.ArrayList;
import leetcodeLib.TreeNode;
import java.util.Collections;
public class BinaryTreeZigzagLevelOrderTravresal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<ArrayList<TreeNode>> queue = new ArrayList<ArrayList<TreeNode>>();
        queue.add(new ArrayList<TreeNode>());
        queue.add(new ArrayList<TreeNode>());
        int previous = 1, current = 0;
        queue.get(current).add(root);
        boolean reverse = false;
        while(!queue.get(current).isEmpty()){
            queue.get(previous).clear();
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            for(TreeNode node : queue.get(current)){
                tmp.add(node);
            }
            if(reverse) Collections.reverse(tmp);
            ArrayList<Integer> subResult = new ArrayList<Integer>();
            for(TreeNode node:tmp)
                 subResult.add(node.val);
            result.add(subResult);
            for(TreeNode node: queue.get(current)){
                if(node.left != null)
                   queue.get(previous).add(node.left);
                if(node.right != null)
                   queue.get(previous).add(node.right);
            }
            
            reverse = reverse?false:true;
            int temp = current;
            current = previous;
            previous = temp;
        }
        return result;
     }
    
	public static void main(String[] args) {
		
	}
}
