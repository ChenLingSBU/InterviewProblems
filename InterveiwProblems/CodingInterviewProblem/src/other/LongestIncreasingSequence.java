package other;


/*
 * longest increasing sequence: this question has two different ways. 
 * 1.) dp, O(n^2);
 * 2.) dp + binery search, O(nlogn); 
 * 
 * dp[i] means the length of longest increasing sequence ending at a[i].  "i" is the index.
 * 
 * note: in the second algorithm, maxLenSequnce[i] means the smallest ending element while the longest length is i + 1;
 * please refer to http://www.felix021.com/blog/read.php?1587
 */

public class LongestIncreasingSequence {
	
	public int getLIS1(int[] a){
		int[] dp = new int[a.length];
		dp[0] = 1;
		int maxLen = Integer.MIN_VALUE;
		for(int i = 1; i < a.length; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(a[j] < a[i] && dp[j] + 1 > dp[i]){
					dp[i] = dp[j] + 1;
					maxLen = Math.max(maxLen, dp[i]);
				}
			}
		}
		
		return maxLen;
	}
	
	public int getLIS2(int[] a){
		if(a == null || a.length == 0) return -1;
		int[] maxLenSequnce = new int[a.length];
		maxLenSequnce[0] = a[0];
		int len = 1;
		for(int i = 1; i < a.length; i++){
			if(a[i] > maxLenSequnce[len - 1]) maxLenSequnce[len++] = a[i];
			else{
				int pos = binearySearch(maxLenSequnce, a[i]);
				maxLenSequnce[pos] = a[i];
			}
		}
		
		return len;
	}
	
	public int binearySearch(int[] b, int target){
		if(b == null || b.length == 0) return -1;
		int left = 0;
		int right = b.length - 1;
		while(left <= right){
			int mid = (left + right)/2;
			if(target >= b[mid]){
				left = mid + 1;
			}else
				right = mid - 1;
		}
		
		return left;
	}

	
	public static void main(String[] args) {
	
	}
}
