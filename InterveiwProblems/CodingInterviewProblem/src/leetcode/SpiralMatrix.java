package leetcode;

/*
 *  it's almost the same idea with Rotate Image,
 *  the only difference is here the matrix is m*n, and it's not guaranteed that m == n
 *  
 *  therefore we have some thing to deal with like note1.
 *  take care of the variables' range in the for loop. 
 */
import java.util.ArrayList;
public class SpiralMatrix {
	
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0) return result;
        int n = matrix[0].length;
        if(n == 0) return result;
        
        int min = Math.min(m, n);
        for(int layer = 0; layer < min/2; layer++){
            int first = layer;
            for(int i = first; i < n - 1 - layer; i++)
                result.add(matrix[first][i]);
            for(int i = first; i < m - 1 - layer; i++)
                result.add(matrix[i][n - 1 - layer]);
            for(int i = n - 1 - layer; i > first; i--)
                result.add(matrix[m - 1 - layer][i]);
            for(int i = m - 1 - layer; i > first; i--)
                result.add(matrix[i][first]);
        }
        
        if(min%2 == 1){ // note1.
            if(m > n){
                for(int i = min/2; i <= m - 1 - min/2; i++)
                    result.add(matrix[i][n/2]);
            }else{
                for(int i = min/2; i <= n - 1 - min/2; i++)
                    result.add(matrix[m/2][i]);
            }
        }
        return result;
    }
	public static void main(String[] args) {

	}
}
