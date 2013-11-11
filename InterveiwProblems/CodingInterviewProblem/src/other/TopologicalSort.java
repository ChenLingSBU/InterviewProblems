package other;


/*
 * Toplogical Sort.
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, 
 * vertex u comes before v in the ordering. 
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 * 
 * Here use adjacent list to represent Graph. and we use hashmap as adjacent list.
 * Graph(1, set(2,3,4)), here the nodes in set are all the nodes which are incoming to node 1. 
 * 
 * 
 */

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;


public class TopologicalSort {
		
	public static ArrayList<Integer> topologicalSort(HashMap<Integer, Set<Integer>> Graph){
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		Queue<Integer> degreeZero = new LinkedList<Integer>();
		
		while(!Graph.isEmpty()){
			for(int key : Graph.keySet()){
				if(Graph.get(key).isEmpty())
					degreeZero.add(key);		
			}
			
			for(int key:degreeZero)
				Graph.remove(key);
			
			while(!degreeZero.isEmpty()){
				int node = degreeZero.poll();
				sorted.add(node);
				for(int key:Graph.keySet()){
					if(Graph.get(key).contains(node))
						Graph.get(key).remove(node);
				}
			}
		}
		
		return sorted;
	}
	
	
	public static void main(String[] args) {
		HashMap<Integer, Set<Integer>> Graph = new HashMap<Integer, Set<Integer>>();
		Set<Integer> set0 = new HashSet<Integer>();
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set5 = new HashSet<Integer>();
		set0.add(1);
		set0.add(2);
		set1.add(2);
		set1.add(5);
		set5.add(4);
		Graph.put(0, set0);
		Graph.put(1, set1);
		Graph.put(2, new HashSet<Integer>());
		Graph.put(4, new HashSet<Integer>());
		Graph.put(5, set5);
		System.out.println(TopologicalSort.topologicalSort(Graph).toString());
	}
}
