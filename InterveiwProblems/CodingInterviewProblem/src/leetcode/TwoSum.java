package leetcode;

/*
 * There are two algorithms, one is brute force which is O(N*N), another is two pointers scan, O(NlogN);
 */

import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {
    public static int[] twoSumBruteForce(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            return null;
        
        int[] result = new int[2];
        int i = 0;
        int j = i + 1;
        while(i<numbers.length){
            if((numbers[i] + numbers[j]) == target){
                result[0] = i +1;
                result[1] = j + 1;
                return result;
            }else{
                j++;
                if(j == numbers.length){
                    i++;
                    j = i +1;
                }
            }
        }
        return null;
    }
    
    public static class Pair implements Comparable<Pair> {
    	public int index;
    	public int val;
    	public Pair(int index, int val){
    		this.index = index;
    		this.val = val;
    	}
    	
    	public int compareTo(Pair pair){
    		if(this.val<pair.val) 
    			return -1;
    		else if(this.val == pair.val)
    			return 0;
    		else
    			return 1;	
    	}
    }
    
    public static int[] twoSumNlogn(int[] numbers, int target){
    	Pair[] pair = new Pair[numbers.length];
    	int sum;
    	int[] result = new int[2];
    	for(int i = 0; i<numbers.length; i++){
    		pair[i] = new Pair(i, numbers[i]);
    	}
    	Arrays.sort(pair);// don't forget sort
    	int left = 0;
    	int right = numbers.length - 1;
    	while(left < right){
    		sum = pair[left].val + pair[right].val;
    		if(sum == target){
    			result[0] = Math.min(pair[left].index + 1, pair[right].index + 1);
    			result[1] = Math.max(pair[left].index + 1, pair[right].index + 1);
    			return result;
    		}
    		if(sum < target) 
    			left++;
    		else 
    			right--;	
    	}
    	return null;	
    }
     
    public static void main(String[] args) {
		int[] num = {2,1,9,4,4,56,90,3};
		int target = 8;
		//int[] result = TwoSum.twoSumBruteForce(num, target);
		int[] result = TwoSum.twoSumNlogn(num, target);
		System.out.print(""+ result[0]+" ");
		System.out.print(""+ result[1]+ " ");
	}
}
