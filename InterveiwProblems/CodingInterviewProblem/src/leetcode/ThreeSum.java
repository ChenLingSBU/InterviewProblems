package leetcode;

/*
 * 2sum, 3sum, 4sum, their algo is similar. 
 * 1. sort
 * 2. use if statement to jump over duplicate 
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if(num == null || num.length < 3)
            return new ArrayList<ArrayList<Integer>>();        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        Arrays.sort(num);
        int sum;
        for(int i = 0; i < num.length ; i++){
            if(i!=0 && num[i] == num[i-1])
                continue;
            int left = i + 1;
            int right = num.length - 1;
            while(left < right){
                if(left - 1 > i && num[left] == num[left - 1]){
                    left++;
                    continue;
                }
                
                if(right+1 < num.length && num[right] == num[right + 1]){
                    right--;
                    continue;
                }
                sum = num[i] + num[left] + num[right];
                if(sum == 0){
                    subResult.add(num[i]);
                    subResult.add(num[left]);
                    subResult.add(num[right]);
                    result.add((ArrayList<Integer>)subResult.clone());
                    subResult.clear();
                    left++;
                }
                else if(sum > 0 )
                    right--;
                else 
                    left++;
            }
        }        
        return result;
    }
	public static void main(String[] args) {
		int[] num = {-1,0, 1, 2, -1, -4};
		System.out.println(ThreeSum.threeSum(num));
	}
}
