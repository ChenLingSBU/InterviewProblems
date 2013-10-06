package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
public class NQueens {

	   public static ArrayList<String[]> solveNQueens(int n) {
	        ArrayList<String[]> result = new ArrayList<String[]>();
	        if(n < 0) return result;
	        if(n == 1){
	            String[] str = new String[1];
	            str[0] = "Q";
	            result.add(str);
	            return result;
	        }
	       Integer[] columns = new Integer[n];
	       placeQueens(result, columns, n, 0);
	       return result;
	    }
	    
	    public static void placeQueens(ArrayList<String[]> result, Integer[] columns, int n, int row){
	        
	        if(row == n){
	           String[] str = new String[n];
	            for(int r = 0; r < n; r++){
	            	char[] c = new char[n];
	                for(int col = 0; col < n; col++){
	                    if(columns[r] == col)
	                        c[col] = 'Q';
	                    else
	                        c[col] = '.';
	                }
	                str[r] = new String(c);
	            }
	            result.add(str);
	            return;
	        }
	        
	            for(int col = 0; col < n; col++){
	                if(checkValid(columns, row, col, n)){
	                    columns[row] = col;
	                    placeQueens(result, columns, n, row + 1);
	                }
	               
	                
	            }
	   
	    }
	    
	    public static boolean checkValid(Integer[] columns, int r, int col, int n){
	        for(int row1 = 0; row1 < r; row1++){
	            int columns2 = columns[row1];
	            if(columns2 == col)
	                return false;
	            int rowDist = r - row1;
	            int colDist = Math.abs(columns2 - col);
	            if(rowDist == colDist)
	                return false;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		ArrayList<String[]> arr = NQueens.solveNQueens(4);
		for(int i = 0; i < arr.size(); i++){
			System.out.println(Arrays.toString(arr.get(i)));
		}
	}
}
