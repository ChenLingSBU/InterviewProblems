package leetcode;


/*
 * 
 */
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Arrays;
public class Anagrams {
	   public static String sortChars(String s){
	        char[] c = s.toCharArray();
	        Arrays.sort(c);
	        return new String(c);
	    }
	    
	public static ArrayList<String> anagrams(String[] strs) {
	    ArrayList<String> result = new ArrayList<String>();
	    if(strs == null || strs.length == 0) return result;
	    Hashtable<String, ArrayList<String>> hash = new Hashtable<String, ArrayList<String>>();
	    for(String str:strs){
	        String key = sortChars(str);
	        if(!hash.containsKey(key)){
	            hash.put(key, new ArrayList<String>());
	        }
	        ArrayList<String> sub = hash.get(key);
	        sub.add(str);
	    }
	    
	    for(ArrayList<String> element: hash.values()){
	        if(element.size() > 1)
	    	    result.addAll(element);
	    }
	    return result;
	}


	public static void main(String[] args) {
		String[] strs = {"",""};
		System.out.println(Anagrams.anagrams(strs));
	}
}
