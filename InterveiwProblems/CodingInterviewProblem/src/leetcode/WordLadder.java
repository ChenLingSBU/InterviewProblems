package leetcode;



/*
 * it's a classic BFS problem.
 * always keep these elements in minds: 1. shortest path, 2. visited status.
 * 
 * in Java the Queue class is an abstract class, cannot be initiated, and linkedlist can be used as queue. 
 * note1, according to the problem itself, we should return the length of the ladder, not the edit times, so here should be 1, not 0;
 */

import java.util.LinkedList;
import java.util.HashSet;
public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> intQueue = new LinkedList<Integer>();
        HashSet<String> visited = new HashSet<String>();
        wordQueue.add(start);
        intQueue.add(1); //note1.
        if(!start.equals(end)) visited.add(start);
        while(!wordQueue.isEmpty()){
            String word = wordQueue.poll();
            int dist = intQueue.poll();
            if(dist > 1 && word.equals(end)) return dist;
            
            for(int i = 0; i < word.length(); i++){
                char[] wordCopy = word.toCharArray();
               for(char c = 'a'; c <= 'z'; c++){
                   if(wordCopy[i] != c){
                       wordCopy[i] = c;
                       String tmp = new String(wordCopy);
                       if(!visited.contains(tmp) && dict.contains(tmp)){
                           wordQueue.add(tmp);
                           intQueue.add(dist + 1);
                           visited.add(tmp);
                       }
                   }
               }
            }
            
        }
        
        return 0;
     }
	
	
	public static void main(String[] args) {
		
	}
}
