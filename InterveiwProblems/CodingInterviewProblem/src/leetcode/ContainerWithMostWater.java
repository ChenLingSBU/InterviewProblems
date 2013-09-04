package leetcode;

/*
 * idea: the area of a container is based on the shorter side. 
 * use greedy method, two pointers scan. 
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        
        while(i<j){
            int area = (j - i)*Math.min(height[i], height[j]);
            result = Math.max(result, area);
            if(height[i] < height[j]) 
                i++;
            else
                j--;
        }     
        return result;
    }
	public static void main(String[] args) {
		
	}
}
