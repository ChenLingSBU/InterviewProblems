package other;


/*
 * Segment a long string into a set of valid words using a dictionary. 
 * Return the maximum number of the subwords.
 * it's Facebook's onsite interview question.
 */

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
public class SegmentString {

	public static int maxSubwords(String s, Set<String> dict){
		int len = s.length();
		int[] dp = new int[len + 1];
		Arrays.fill(dp, 0);
		for(int i = 1; i < len + 1; i++){	
			for(int j = 0; j < i; j++){
				if(dict.contains(s.substring(j, i))){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		return dp[len];
	}
	
	
	public static void main(String[] args) {
		String s = "applepie";
		Set<String> dict = new HashSet<String>();
		dict.add("pie");
		dict.add("pear");
		dict.add("apple");
		dict.add("peach");
		System.out.println(SegmentString.maxSubwords(s, dict));
	}
}
