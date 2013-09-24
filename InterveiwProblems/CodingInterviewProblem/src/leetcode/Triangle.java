package leetcode;


/*
 * the problem says "each step you may move to adjacent numbers on the row below", how to understand the adjacent numbers?
 * look at the example below we can find that the "adjacent" here means three number which can directly compound a triangle.
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
* so, the recursion relation is note1.
* 
* There are two ways to solve this problem. top down and bottom up. 
*/

import java.util.ArrayList;

public class Triangle {

    public static int minimumTotalTopDown(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] minSum = new int[triangle.get(triangle.size() - 1).size()];
        minSum[0] = triangle.get(0).get(0);      
        for(int i = 1; i < triangle.size(); i++){
            for(int j = triangle.get(i).size() - 1; j >= 0; j--){
                if(j == 0)
                    minSum[j] = minSum[j] + triangle.get(i).get(j);
                else if(j == triangle.get(i).size() - 1)
                    minSum[j] = minSum[j - 1] + triangle.get(i).get(j);
                else
                    minSum[j] = Math.min(minSum[j - 1], minSum[j]) + triangle.get(i).get(j);
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < minSum.length; i++)
            ret = Math.min(minSum[i], ret);
        return ret;
    }
    
    public static int minimumTotalBottomUp(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] minSum = new int[triangle.get(triangle.size() - 1).size()];
        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i == triangle.size() - 1){
                    minSum[j] = triangle.get(i).get(j);
                    continue;
                }
                
                minSum[j] = Math.min(minSum[j + 1], minSum[j]) + triangle.get(i).get(j); // note1
            }
        }
        
        return minSum[0];
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub1 = new ArrayList<Integer>();
		ArrayList<Integer> sub2 = new ArrayList<Integer>();
		ArrayList<Integer> sub3 = new ArrayList<Integer>();
		ArrayList<Integer> sub4 = new ArrayList<Integer>();
		sub1.add(2);
		sub2.add(3);
		sub2.add(4);
		sub3.add(6);
		sub3.add(5);
		sub3.add(7);
		sub4.add(4);
		sub4.add(1);
		sub4.add(8);
		sub4.add(3);
		triangle.add(sub1);
		triangle.add(sub2);
		triangle.add(sub3);
		triangle.add(sub4);
		
		System.out.println(Triangle.minimumTotalTopDown(triangle));
		System.out.println(Triangle.minimumTotalBottomUp(triangle));
	}

}
