package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        if(num == null || num.length == 0)
            return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            if(i!=0  && num[i] == num[i-1]){
                continue;
            }
                
            for(int j = i + 1; j < num.length; j++){
                if(j!= i + 1  && num[j] == num[j-1]){
                    continue;
                }
                    
                int left = j + 1;
                int right = num.length - 1;
                while(left < right){
                    if(left != j+1 && num[left] == num[left-1] ){
                        left++;
                        continue;
                    }
                        
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if(sum == target){
                        subResult.add(num[i]);
                        subResult.add(num[j]);
                        subResult.add(num[left]);
                        subResult.add(num[right]);
                        result.add((ArrayList<Integer>)subResult.clone());
                        subResult.clear();
                        left++;
                    }
                    else if(sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        
        return result;
    }
	public static void main(String[] args) {
		int[] num = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(FourSum.fourSum(num, target));
	}

}
