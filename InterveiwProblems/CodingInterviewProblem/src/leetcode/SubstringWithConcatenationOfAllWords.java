package leetcode;

/*
 * Brute force, O(M*N).
 * 
 * note, there may have repeat words in L. To myself, The most important thing is really understand the problem itself.!
 * 
 */


import java.util.ArrayList;
import java.util.Hashtable;
public class SubstringWithConcatenationOfAllWords {
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(S == null || S.length() == 0) return null;
        if(S.length() < L.length) return result;
        if(L.length == 0|| L ==null) {
            return result;
        }
        
        Hashtable<String, Integer> wordHash = new Hashtable<String, Integer>();
        Hashtable<String, Integer> curHash = new Hashtable<String, Integer>();
        
        for(int i = 0; i < L.length; i++){
            if(!wordHash.containsKey(L[i]))  // containsKey, not contain()
                wordHash.put(L[i], new Integer(1));
            else{
                wordHash.put(L[i], wordHash.get(L[i]) + 1);
            }    
        }
        
        for(int i = 0; i <= S.length() - L.length*L[0].length(); i++){ // it's 'i <= ' not 'i<'
            curHash.clear();
            for(int j = 0; j < L.length; j++){
                String w = S.substring(i+j*L[0].length(), i+j*L[0].length() + L[0].length());
                if(!wordHash.containsKey(w))
                    break;
                if(!curHash.containsKey(w)){
                    curHash.put(w, new Integer(1));
                }
                else{
                  curHash.put(w, curHash.get(w)+1);
                  if(curHash.get(w) > wordHash.get(w))
                        break;
            }
            
            if(j == L.length - 1) //note here, j == L.length - 1. not j == L.length. j++ is the last step in the for loop. 
                result.add(i);      
        }                       
    }    
    return result;
}

	public static void main(String[] args) {
		String s ="barfoothefoobarman";
		String[] l = {"foo", "bar"};
		
		System.out.println(SubstringWithConcatenationOfAllWords.findSubstring(s, l));
	}

}
