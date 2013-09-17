package leetcode;


/*
 * use the property of BST that we will get a sorted array with ascending order if we make in order traversal of a BST.
 * Thus every time we record last element as pre we visited, and compare it's element with current visiting element, 
 * if pre.val > current.val, set first = pre, second = current, and then continue traveling until all the nodes are visited.
 * 
 * note1. here if we write the codes as below:
 * if(nodes[pre] != null && nodes[pre].val > root.val){//note1
        if(nodes[first] == null)                             
            nodes[first] = nodes[pre];
        nodes[second] = root;  
        return;  
    }
    
    we will not get the right answer. why? consider this case. {2,3,1} ----{root, left, right}
    
    it means we have to visit all the nodes. 
 */

import leetcodeLib.TreeNode;


public class RecoverBST {
	
    public void recoverTree(TreeNode root) {
    if(root == null) return;
    
    TreeNode[] nodes = new TreeNode[3];
    int pre = 0;
    int first = 1;
    int second = 2;
    nodes[pre] = null;
    nodes[first] = null;
    nodes[second] = null;
    walkThroughTree(root, nodes, pre, first, second);
    swap(nodes[first], nodes[second]);    
}

public void walkThroughTree(TreeNode root, TreeNode[] nodes, int pre, int first, int second){
    if(root == null)
        return;
        
    walkThroughTree(root.left, nodes, pre, first, second);
    
    if(nodes[pre] != null && nodes[pre].val > root.val){//note1
        if(nodes[first] == null)                             
            nodes[first] = nodes[pre];
        nodes[second] = root;    
    }
    
    nodes[pre] = root;
    walkThroughTree(root.right, nodes, pre, first, second);
}

public void swap(TreeNode first, TreeNode second){
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}
	public static void main(String[] args) {
		
	}
}
