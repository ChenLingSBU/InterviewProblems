package other;



/*
 * Write the function which rotates the input array by p positions. 
 * For example, the array [1, 2, 3, 4, 5, 6] rotated by 2 positions returns [5, 6, 1, 2, 3, 4]
 * 
 * note1: i should starts at "start", not 0; other wise when reverseArray(a, p, n- 1) will encounter an error;
 * note2: it should be (i - start). reason as above.
 * 
 * There's a rotate list in leetcode, that uses a different method according to the property of linked list.(review that problem!)
*/

import java.util.Arrays;
public class RotateArray {
	
	public static void reverseArray(int[] a, int start, int end){
		int m = (start + end)%2 == 0? (start + end)/2 : (start + end)/2 + 1;
		for(int i = start; i < m; i++){   // note 1.
			int tmp = a[i];
			a[i] = a[end - (i - start)];  //note 2.
			a[end - (i - start)] = tmp;
		}
	}
	
	public static void rotateArray(int[] a, int p){
		int n = a.length;
		if(p <= 0 || p >= n) return;
		
		reverseArray(a, 0, n - 1);
		reverseArray(a, 0, p - 1);
		reverseArray(a, p, n - 1);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		int p = 2;
		RotateArray.rotateArray(a, p);
		System.out.println(Arrays.toString(a));
	}
}
