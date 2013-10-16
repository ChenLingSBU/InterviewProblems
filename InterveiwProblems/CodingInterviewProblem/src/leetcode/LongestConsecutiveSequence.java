package leetcode;

/*
 * the requirement is in O(n), so we should consider using Hash. 
 * don't forget to add note 1 and note2. we should update these either.
 */

import java.util.Hashtable;
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        Hashtable<Integer, int[]> hash = new Hashtable<Integer, int[]>();
        for(int i = 0; i < num.length; i++){
            if(hash.containsKey(num[i])) continue;
            int cur = num[i];
            int low = cur;
            int high = cur;
            if(hash.containsKey(cur - 1)) low = hash.get(cur - 1)[0];
            if(hash.containsKey(cur + 1)) high = hash.get(cur + 1)[1];          
            if(low != cur) hash.get(low)[1] = high; // note1
            if(high != cur) hash.get(high)[0] = low; // note2
            int[] pair = new int[2];
            pair[0] = low;
            pair[1] = high;
            hash.put(cur, pair);
            maxLen = Math.max(maxLen, high - low + 1);
        }
        
        return maxLen;
    }
	
	public static void main(String[] args) {
		int[] num = {1,3,5,2,4};
		System.out.println(LongestConsecutiveSequence.longestConsecutive(num));
	}
}
