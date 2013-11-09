package other;



/*
 * Give a binary tree, find the lowest common ancestor of two given nodes in the tree.
 *  Each node contains a parent pointer which links to its parent.
 *  Follow up: Could you eliminate the need of extra space?
 *  
 *  getLCA1 uses extra space.
 *  getLCA2 with no extra space.
 *  
 *  Follow up: Find least common ancestor of 2 nodes in the N-ary tree  (will implement later)
 */
import leetcodeLib.TreeNode;
import java.util.HashSet;
public class LowestCommonAncestorOfBinaryTreeII {


	public TreeNode getLCA1(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		while(p != null || q != null){
			if(p != null){
				if(visited.contains(p)) return p;
				p = p.parent;
				visited.add(p);
			}
			if(q != null){
				if(visited.contains(q)) return q;
				q = q.parent;
				visited.add(q);
			}
		}
		
		return null;
	}
	
	public TreeNode getLCA2(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		int hp = getHeight(p);
		int hq = getHeight(q);
		int biggerH = Math.max(hp,hq);
		int smallH = biggerH == hp?hq:hp;
		TreeNode big = biggerH == hp?p:q;
		TreeNode small = big == p?q:p;
		
		int difH = biggerH - smallH;
		while(difH > 0){
			big = big.parent;
			difH--;
		}
		
		while(big != null && small != null){
			if(big == small) return big;
			big = big.parent;
			small = small.parent;
		}
		
		return null;		
	}
	
	public int getHeight(TreeNode node){
		int height = 0;
		while(node != null){
			node = node.parent;
			height++;
		}
		
		return height;
	}
	
	public static void main(String[] args) {

	}
}
