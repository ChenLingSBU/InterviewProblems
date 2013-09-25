package leetcode;

/*
 * test cases:
 * input n = 3, 
 * 
 * output: [{1,#,2,#,3},{1,#,3,2},{2,1,3},{3,1,#,#,2},{3,2,#,1}]
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
