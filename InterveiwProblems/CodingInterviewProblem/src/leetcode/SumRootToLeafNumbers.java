package leetcode;



import leetcodeLib.TreeNode;
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
    	
        int[] sum = new int[1];
        generateNums(root,0,sum);
        return sum[0];
     }
     
     public void generateNums(TreeNode root, int num, int[] sum){
         if(root == null) return;
         num = num*10 + root.val;
         if(root.left == null && root.right == null){
             sum[0] += num;
             return;
         }
         generateNums(root.left, num, sum);
         generateNums(root.right, num, sum);
     }
     
	public static void main(String[] args) {

	}
}
