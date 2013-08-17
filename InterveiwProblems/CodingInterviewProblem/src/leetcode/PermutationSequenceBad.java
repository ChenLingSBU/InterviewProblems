/*
 * Use DFS method, can pass the small judge, time out when tried the large cases.
 * 
 */


package leetcode;

import java.util.ArrayList;

public class PermutationSequenceBad {
	public String getPermutation(int n, int k) {
        if(n<1 || n>9)
            return null;
        if(k<1 || k>factorial(n))
            return null;
        int[] array = initArray(n);
        
        StringBuilder out = new StringBuilder();
        
        boolean[] used = new boolean[n];
        
        int level = 0;
        
        ArrayList<String> permutations = new ArrayList<String>();
        
        getPermutation(array, k, out, used, permutations, level);
        
        return permutations.get(k-1);
        
    }
    
    public void getPermutation(int[] array, int k, StringBuilder out, boolean[] used, ArrayList<String> permutations, int level){
        
        if(permutations.size() == k)
            return;
            
        
        for(int i = 0; i<array.length; i++)
        {
            if(used[i])
                continue;
            out.append("" + array[i]);
            used[i] = true;
            
            if(array.length == level + 1)
                permutations.add(out.toString());
                
            getPermutation(array, k, out, used, permutations, level+1);
            
            used[i] = false;
            out.setLength(out.length() - 1);
        }     
    }
     
    public int[] initArray(int n){
        int[] array = new int[n];
        int i = 1;
        int index = 0;
        while(i <= n){
            array[index++] = i++;
        }  
        return array;
    }
    
    public int factorial(int n){
        int product = 1;
        while(n>0){
            product = product*n;
            --n;
        }
        
        return product;
    }
	public static void main(String[] args) {
		
		PermutationSequenceBad perm = new PermutationSequenceBad();
		
		System.out.println(perm.getPermutation(9, 171669));
		
		
	}

}
