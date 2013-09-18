package leetcode;


/*
 * we can use DFS and BFS to solve this problem.
 * 
 * in BFS, be careful that every time when ready to add element to the result, check whether it's null first.
 */
import leetcodeLib.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
public class BinaryTreeLevelOrderTraversal {
	   
	//DFS
	public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
	       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	       if(root == null) return result;
	       
	       levelOrderDFS(root, result,0);
	       
	       return result;
	    }
	    
	    public void levelOrderDFS(TreeNode root, ArrayList<ArrayList<Integer>> result, int level){
	        if(root == null) return;
	        if(result.size() == level){ // it's a new level that we haven't visited.
	            ArrayList<Integer> subResult = new ArrayList<Integer>();
	            subResult.add(root.val);
	            result.add(subResult);
	        }else{
	            ArrayList<Integer> subResult = result.get(level);
	            subResult.add(root.val);
	        }
	        
	        levelOrderDFS(root.left, result, level + 1);
	        levelOrderDFS(root.right, result, level + 1);
	        
	        return;
	    }
	    
	    
	    
	    //BFS
	    public ArrayList<ArrayList<Integer>> levelOrderBFS(TreeNode root) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
	        if(root == null) return result;
	        levelOrderBFS(root, result);
	        return result;
	    }
	    
	    public void levelOrderBFS(TreeNode root, ArrayList<ArrayList<Integer>> result){
	        LinkedList<TreeNode> cur = new LinkedList<TreeNode> ();
	        cur.add(root);
	       ArrayList<Integer> subResult = new ArrayList<Integer>();
	        subResult.add(root.val);
	        result.add(subResult);
	        while(cur.size() > 0){
	          subResult = new ArrayList<Integer>();
	            LinkedList<TreeNode> parents = cur;
	            cur = new LinkedList<TreeNode>();
	            for(TreeNode parent:parents ){
	                if(parent.left != null)
	                    cur.add(parent.left);
	                if(parent.right != null)
	                    cur.add(parent.right);
	            }
	            for(TreeNode current : cur){
	                if(current != null){
	                subResult.add(current.val);
	                }
	            }
	            if(subResult.size() != 0)
	                result.add(subResult);
	        }
	        
	        return;
	    }
	public static void main(String[] args) {
	
	}
}
