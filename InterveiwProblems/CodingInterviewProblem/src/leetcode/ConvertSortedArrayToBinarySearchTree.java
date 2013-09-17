package leetcode;


/*
 * use bst's property.
 * 
 * note: we will get a ascending order array when we do in order traversal of BST.
 */
import leetcodeLib.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        int start = 0;
        int end = num.length - 1;
        
        return sortedArrayToBST(num, start, end);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        
        return root;
    }
	
	public static void main(String[] args) {
		
	}
}
