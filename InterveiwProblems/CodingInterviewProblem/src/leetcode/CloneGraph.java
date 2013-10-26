package leetcode;



/*
 * use DFS here. 
 * we could still use BFS. 
 */
import java.util.Hashtable;
import leetcodeLib.UndirectedGraphNode;
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        Hashtable<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneGraph(node, nodeMap);
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Hashtable<UndirectedGraphNode, UndirectedGraphNode> nodeMap) {
       if(node == null) return null;
      
       UndirectedGraphNode newNode = null;
       
       if(!nodeMap.containsKey(node)){
           newNode = new UndirectedGraphNode(node.label);
           
           nodeMap.put(node, newNode);
           
           for(int i = 0; i < node.neighbors.size(); i ++){
               UndirectedGraphNode neighborNode = cloneGraph(node.neighbors.get(i),nodeMap);
               newNode.neighbors.add(neighborNode);
           }
       }else{
           newNode = nodeMap.get(node);
       }
       
       return newNode;
       
    }
	public static void main(String[] args) {
	
	}
}
