package other;

import java.util.Arrays;

/*
 * Given three arrays: A,B,C, you can get three element a,b,c from each of them. Find the minimum distance |a-b| + |b-c| + |c-a|.
 */
public class MinimumDistanceOfThreePoints {
	//public static int findMiniDistance(int[] A, int[] B, int[] C){
		
	//}//
		public static int[] minizeDistance(int[] a, int[] b, int[] c) {
			int[] minIndexes = null;
			Integer minVal = null;
			int i=0, j=0, k=0;
			while (true) {
				int curMin = Math.max(a[i] - b[j], 
					Math.max(b[j] - c[k], c[k] - a[i]));
				if (minVal == null || curMin < minVal) {
					minVal = curMin;
					minIndexes = new int[]{i, j, k};
				}
				boolean canIncI = i != a.length-1;
				boolean canIncJ = j != b.length-1;
				boolean canIncK = k != c.length-1;
				if (!canIncI && !canIncJ && !canIncK)
					break;	
				if (canIncI && (!canIncJ || a[i] < b[j]) 
					&& (!canIncK || a[i] < c[k]))
					++i;
				else if (canIncJ && (!canIncK || b[j] < c[k]))
					++j;
				else
					++k;
					
			}
			return minIndexes;
		}
	
	public static void main(String[] args) {
		int[] a = {100};
		int[] b = {10, 20};
		int[] c = {1, 10000};
		
		int[] d = minizeDistance(a, b, c);
		
		System.out.println(Arrays.toString(d));

	}

}
