package leetcode;

import java.util.Arrays;
import java.util.Hashtable;

public class ThreeSumClosest {
	       public static int threeSumClosest(int[] num, int target) {
	        if(num == null||num.length == 0)
	            return 0;
	        Hashtable<Integer, Integer> hash =  new Hashtable<Integer, Integer>();
	        int min = Integer.MAX_VALUE;
	        Arrays.sort(num);
	        for(int i = 0; i < num.length; i++){
	            int left = i + 1;
	            int right = num.length - 1;
	            while(left<right){
	                int sum = num[i] + num[left] + num[right];
	                int dist = Math.abs(target - sum);
	                if(sum == target) 
	                    return sum;
	                else if(sum > target){
	                if(min>dist){
	                    min = dist;
	                    hash.put(min, sum);   
	                }
	                right--;
	                }
	                else {
	                    if(min>dist){
	                        min = dist;
	                        hash.put(min,sum);
	                    }
	                    left++;
	                }
	            }
	            
	            while(i+1<num.length && num[i] == num[i+1]) i++;// avoid useless iterate. 
	        }
	        
	        return hash.get(min);
	    }

	public static void main(String[] args) {
		int[] num = {1,1,1,0};
		int target = -100;
		System.out.println(ThreeSumClosest.threeSumClosest(num, target));
	}
}
