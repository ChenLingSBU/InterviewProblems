package other;


/*
 * Shuffle an array.
 * 
 * Fisher and Yates' shuffle algorithm.
 * 
 * ref: http://www.tuicool.com/articles/B3AfQv
 *  	http://www.geeksforgeeks.org/shuffle-a-given-array/
 */

import java.util.Random;
import java.util.Arrays;
public class ShuffleArray {

	public static void shuffeArray(int[] a) {
		if(a == null || a.length == 0) return;
		Random rand = new Random();
		for(int i = a.length - 1; i >= 1; i--){
			int j = rand.nextInt(i + 1);
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 4, 5, 6, 11, 34, 65, 90, 56, 33, 7, 88};
		System.out.println(Arrays.toString(a));
		ShuffleArray.shuffeArray(a);
		System.out.println(Arrays.toString(a));
	}
}
