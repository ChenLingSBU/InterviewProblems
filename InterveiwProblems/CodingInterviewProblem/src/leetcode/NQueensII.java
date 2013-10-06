package leetcode;

public class NQueensII {

    public int totalNQueens(int n) {
        int[] columns = new int[n];
        int[]count = new int[1];
        placeQueens(count,columns, n, 0);
        return count[0];
     }
     
     public static void placeQueens(int[] count,int[] columns, int n, int row){
 	        
 	        if(row == n){
 	           count[0]++;
 	           return;
 	        }
 	        
 	            for(int col = 0; col < n; col++){
 	                if(checkValid(columns, row, col, n)){
 	                    columns[row] = col;
 	                    placeQueens(count, columns, n, row + 1);
 	                }
 	               
 	                
 	            }
 	   
 	    }
 	    
 	    public static boolean checkValid(int[] columns, int r, int col, int n){
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
	
	}
}
