package leetcode;


/*
 * DP version will be updated soon. 
 */

public class RegularExpressionMatching {

	   public static boolean isMatch(String s, String p) {
		   
	        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
	    }
	    
	    public static boolean isMatch(char[] s, char[] p, int sIndex, int pIndex){
	        if(pIndex == p.length) return sIndex == s.length;
	        
	        if(pIndex == p.length - 1 || p[pIndex + 1] != '*'){
	            if(sIndex < s.length && (p[pIndex] == s[sIndex] || p[pIndex] == '.') )
	                return isMatch(s, p, sIndex + 1, pIndex + 1);
	            return false;
	        }
	        else {
	            while(sIndex < s.length && (p[pIndex] == s[sIndex] || p[pIndex] == '.' )){
	                if(isMatch(s, p, sIndex, pIndex + 2))
	                    return true;
	                sIndex++;
	            }
	            
	            return isMatch(s, p, sIndex, pIndex + 2);
	        }
	        
	    }
	    
	    
	public static void main(String[] args) {
			String s = "aaaac";
			String p = "ab*c*";
			System.out.println(RegularExpressionMatching.isMatch(s, p));
	}
}
