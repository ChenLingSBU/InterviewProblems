package leetcode;


import java.util.ArrayList;

public class Triangle {

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] minSum = new int[triangle.get(triangle.size() - 1).size()];
        minSum[0] = triangle.get(0).get(0);
        for(int i = 1; i < minSum.length; i++){
            minSum[i] = Integer.MAX_VALUE;
        }
        
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
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub = new ArrayList<Integer>();
		sub.add(1);
		ArrayList<Integer> sub1 = new ArrayList<Integer> ();
		sub1.add(2);
		sub1.add(3);
		triangle.add(sub);
		triangle.add(sub1);
		System.out.println(Triangle.minimumTotal(triangle));
	}

}
