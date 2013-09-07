package leetcode;


/*
 * strStr problem.
 * 
 * two algorithms:
 * 1. brute force, O(n*n);
 * 2. KMP O(n+m)
 * 	  In KMP, the processing of prefix function and the strstr function is similar,
 * 	  in prefix, needle is compared to itself, in strstr, needle is compared to haystack.
 * 	  if confused of prefix and strstr function, read chapter 32 of introduction to algorithm. 
 */

public class StrStr {
    public static String strStrBruteForce(String haystack, String needle) {
        
        if(haystack == null && needle == null) return new String("");
        
        int n = haystack.length();
        int m = needle.length();
        
        if(n<m) return null;
        
        if(needle == null || m == 0) return haystack;
        
        for(int i = 0; i < n; i++){
            if(n-i < m) break;          // avoid useless iterate.
            for(int j = 0; j < m; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){   //note here, haystack.charAt(i+j) not haystack.charAt(i) 
                	break;
                }      
                if(j == m-1) return haystack.substring(i); // compare j and needle.length. return substring(i)
            }    
        }
        return null;   
    }
    
    public static String strStrKMP(String haystack, String needle) {
        if(haystack == null && needle == null) return new String("");
        
        if(haystack.length() < needle.length()) return null;
        
        if(needle == null || needle.length() == 0) return haystack;
        
        int[] p = prefix(needle);
        
        int k = -1;
        for(int i = 0; i < haystack.length(); i++){ //i starts from 0
            
            while(k > -1 && needle.charAt(k+1) != haystack.charAt(i))
                k = p[k];
            if(needle.charAt(k+1) == haystack.charAt(i)) // no k > -1 inside if. 
                k++;
            if(k == needle.length() - 1)     //k is index, so it's k == needle.length() - 1, not k == needle.length().
                return haystack.substring(i - k); // i is index, k is index, so can do subtract operation .
        }
        
        return null;     
    }
    
    public static int[] prefix(String needle){
        int[] p = new int[needle.length()];
        int k = -1;
        p[0] = -1;
        
        for(int i = 1; i < needle.length(); i++){ // i starts from 1; 
            while(k > -1 && needle.charAt(k+1) != needle.charAt(i))
                k = p[k];
            if(needle.charAt(k + 1) == needle.charAt(i))
                k = k + 1;
            p[i] = k;
        }
        
        return p;
    }
    

	public static void main(String[] args) {
		String haystack = "aaa";
		String needle = "a";
		System.out.println(StrStr.strStrBruteForce(haystack, needle));
		System.out.println(StrStr.strStrKMP(haystack, needle));

	}

}
