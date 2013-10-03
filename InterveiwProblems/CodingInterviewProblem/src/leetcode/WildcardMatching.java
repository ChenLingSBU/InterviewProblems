package leetcode;

/*
 * cannot pass large judge.
 * will try DP/greedy  solution later.
 */


public class WildcardMatching {

	   public static boolean isMatch(String s, String p) {
	        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
	    }
	    
	    public static boolean isMatch(char[] s, char[] p, int sIndex, int pIndex){
	        
	        if( pIndex < p.length && p[pIndex] == '*'){
	            while(pIndex < p.length && p[pIndex] == '*') pIndex++;
	            if(pIndex == p.length) return true;
	            while(sIndex < s.length && !isMatch(s, p, sIndex, pIndex))
	                sIndex++;
	            return sIndex != s.length;
	        }
	        else if(pIndex == p.length || sIndex == s.length) return (pIndex == p.length && sIndex == s.length)?true:false; 
	        else if(p[pIndex] == s[sIndex] || p[pIndex] == '?') return isMatch(s, p, ++sIndex, ++pIndex);
	        else return false;
	    }
	public static void main(String[] args) {
		String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
		String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
		System.out.println(WildcardMatching.isMatch(s, p));
	}
}
