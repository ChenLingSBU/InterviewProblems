package leetcode;

/*
 * the result is a ArrayList containing the root node of each tree.
 * 
 * this problem can still be solved by DP. i'm going to implement dp solution later.
 */


import java.util.ArrayList;
import leetcodeLib.TreeNode;
public class UniqueBinarySearchTreesII {
	
    public static ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(0, n - 1);
     }
     
     public static ArrayList<TreeNode> generateTrees(int begin, int end){
         ArrayList<TreeNode> result = new ArrayList<TreeNode>();
         if(begin > end){
             result.add(null);
             return result;
         }
         for(int i = begin; i <= end; i++){
             ArrayList<TreeNode> leftTree = generateTrees(begin, i - 1);
             ArrayList<TreeNode> rightTree = generateTrees(i + 1, end);
             for(int j = 0; j < leftTree.size(); j++){
                 for(int k = 0; k < rightTree.size(); k++){
                     TreeNode node = new TreeNode(i + 1);
                     result.add(node);
                     node.left = leftTree.get(j);
                     node.right = rightTree.get(k);
                 }
             }             
         }         
         return result;
     }
	public static void main(String[] args) {
		int n = 3;
		System.out.println(UniqueBinarySearchTreesII.generateTrees(n));
	}
}
