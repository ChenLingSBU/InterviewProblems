package leetcode;


/*
 * DFS is too slow.
 * use cache + top down.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
public class WordBreakII {

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreak(s, dict, map);
    }
    
    public static ArrayList<String> wordBreak(String s, Set<String> dic, HashMap<String, ArrayList<String>> map){
        if(map.containsKey(s)) return map.get(s);
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) return result;
        
        for(int len = 1; len <= n; len++){
            String suffix = s.substring(n - len);
            if(dic.contains(suffix)){
                if(n == len){
                    result.add(suffix);
                    return result;
                }
                String prefix = s.substring(0, n - len);
                ArrayList<String> tmpStrings = wordBreak(prefix, dic, map);
                for(String tmp:tmpStrings){
                    tmp = tmp + " " + suffix;
                    result.add(tmp);
                }
            }
        }
        map.put(s, result);
        return result;
    }
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		String[] words = {"cat", "cats", "and", "sand", "dog"};
		for(String word:words)
			dict.add(word);
	    String s = "catsanddog";
	    System.out.println(WordBreakII.wordBreak(s, dict));
	    
	}
}
