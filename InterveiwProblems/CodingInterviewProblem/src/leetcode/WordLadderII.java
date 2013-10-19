package leetcode;




/*
 * note: start and end might be or might not be in the Dictionary
 * 
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
public class WordLadderII {
	
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
    
        HashSet<String> visited = new HashSet<String>();
        ArrayList<HashSet<String>> queue = new ArrayList<HashSet<String>>();
        HashMap<String, HashSet<String>> preMap = new HashMap<String, HashSet<String>>();
    
        int current = 0;
        int previous = 1;
        for(int i = 0; i < 2; i++){
            queue.add(new HashSet<String>());
        }
        queue.get(current).add(start);
        preMap.put(start, new HashSet<String>());      
        while(true){
            int temp = current;
            current = previous;
            previous = temp;
            queue.get(current).clear();
            for(String str : queue.get(previous)){
            	
            	visited.add(str);
            }
            queue.get(current).clear();
            for(String str : queue.get(previous)){  
                for(int i = 0; i < str.length(); i++){
                	char[] word = str.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        if(word[i] != c ){
                            word[i] = c;
                            String tmp = new String(word);
                            if(!visited.contains(tmp) && (dict.contains(tmp)||tmp.equals(end))){
                            	if(!preMap.containsKey(tmp)) preMap.put(tmp, new HashSet<String>());
                                preMap.get(tmp).add(str);
                                queue.get(current).add(tmp);
                                
                            }
                        }
                        
                    }
                   
                }
                
            }
          
            if(queue.get(current).size() == 0)
                 return paths;
            if(queue.get(current).contains(end))
                 break;
        }
        
        ArrayList<String> path = new ArrayList<String>();   
        generatePaths(preMap, paths, path, end);
        return paths;
     }
     
     public static void generatePaths(HashMap<String, HashSet<String>> preMap, ArrayList<ArrayList<String>> paths, ArrayList<String> path, String word){
         if(preMap.get(word).size() == 0){
             path.add(word);
             ArrayList<String> newPath = new ArrayList<String>();
             for(int i = path.size() - 1; i >= 0; i--){
                 newPath.add(path.get(i));
             }
             paths.add(newPath);
             path.remove(path.size() - 1);
             return;
         }
         
         path.add(word);
         
         for(String tmp : preMap.get(word)){
             generatePaths(preMap, paths, path, tmp);
         }
         
         path.remove(path.size() - 1);
     }
	
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		String[] dic = {"hot","dot","dog","lot","log"};
		
		for(String word:dic){
			dict.add(word);
		}
		String start = "hit";
		String end = "cog";
		System.out.println(WordLadderII.findLadders(start, end, dict));	
		
	}
}
