package leetcode;




/*
 * note1 and note2, it's < cols - 1 and < rows - 1. not < cols and < rows. 
 */
import java.util.ArrayList;
public class SurroundedRegions {

	
    public void solve(char[][] board) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        if(board == null) return;
        int rows = board.length;
        if(rows == 0) return;
        int cols = board[0].length;
        if(cols == 0) return;
        
        for(int row = 0; row < rows; row++){
            if(board[row][0] == 'O'){
                x.add(0);
                y.add(row);
            }
            
            if(board[row][cols - 1] == 'O'){
                x.add(cols - 1);
                y.add(row);
               
            }
        }
        
        for(int col = 1; col < cols - 1; col++){
            if(board[0][col] == 'O'){
                x.add(col);
                y.add(0);
            }
            if(board[rows - 1][col] == 'O'){
                x.add(col);
                y.add(rows - 1);
               
            }
        }
        
        int k = 0;
        while(k < x.size()){
            int xx = x.get(k);
            int yy = y.get(k);
            board[yy][xx] = '#';
            if(xx > 0 && board[yy][xx - 1] == 'O'){ x.add(xx - 1); y.add(yy);}
            if(xx < cols - 1 && board[yy][xx + 1] == 'O') {x.add(xx + 1); y.add(yy);} //note1
            if(yy > 0 && board[yy - 1][xx] == 'O') {x.add(xx); y.add(yy - 1);}
            if(yy < rows - 1 && board[yy + 1][xx] == 'O') {x.add(xx); y.add(yy + 1);} //note2
            k++;
        }
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(board[row][col] == 'O') board[row][col] = 'X';
                if(board[row][col] == '#') board[row][col] = 'O';
            }
        }
        
    }
    
	public static void main(String[] args) {
		
	}
}
