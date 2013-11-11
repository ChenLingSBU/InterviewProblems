package other;


/*
 * check whether a graph is bigraph.
 * 
 * Graph G[][] is Ajacency Matrix. 
 * 
 * ref: http://www.geeksforgeeks.org/bipartite-graph/
 */
import java.util.Queue;
import java.util.LinkedList;

public class WhetherGraphIsBigraph {
	
	public static boolean isBigraph(int[][] G){
		int len = G.length;
		int[] color = new int[len];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < len; i++){
			color[i] = -1;
		}
		
		color[0] = 1;
		queue.add(0);
		
		while(!queue.isEmpty()){
			int u = queue.poll();
			for(int v = 0; v < len; v++){
				if(G[u][v] != 0 && color[v] == -1){
					color[v] = 1 - color[u];
					queue.add(v);
				}else if(G[u][v] != 0 && color[v] == color[u])
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
	
		int[][] G = {{0, 1, 0, 1},
		             {1, 0, 1, 0},
		             {0, 1, 0, 1},
		             {1, 0, 1, 0}};
		
		System.out.println(WhetherGraphIsBigraph.isBigraph(G));
	}
}
