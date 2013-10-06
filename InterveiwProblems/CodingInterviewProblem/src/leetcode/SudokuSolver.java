package leetcode;


/*
 * classic example of backtrace.
 * note: be careful of note1 and note2.
 */
import java.util.Arrays;

public class SudokuSolver {
	
	public static void solveSudoku(char[][] board){
		solve(board);
	}

    public static boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.')
                    continue;
                for(char k = '1'; k <= '9'; k++){
                    
                    board[i][j] = k;
                    if(checkValid(board, i, j)){
                    	if(solve(board))
                    		return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkValid(char[][] board, int x, int y){
        boolean[] flag = new boolean[9]; //note1
        for(int i = 0; i < 9; i++){
            if(board[x][i] >= '1' && board[x][i] <='9'){
                if(!flag[board[x][i] - '1']){
                    flag[board[x][i] - '1'] = true;
                }
                else 
                    return false;
            }
        }
        
        Arrays.fill(flag, false);
        
        for(int i = 0; i < 9; i++){
            if(board[i][y] >= '1' && board[i][y] <= '9'){
                if(!flag[board[i][y] - '1']){
                    flag[board[i][y] - '1'] = true;
                }
                else
                    return false;
            }
        }
        
        Arrays.fill(flag, false);
        
        int xx = x/3*3;//note2
        int yy = y/3*3;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[xx + i][yy + j] >= '1' && board[xx + i][yy + j] <= '9'){
                    if(!flag[board[xx + i][yy + j] - '1'])
                        flag[board[xx + i][yy + j] - '1'] = true;
                    else
                        return false;
                }
            }
       
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},
						  {'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},
						  {'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},
						  {'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},
						  {'.','.','.','2','7','5','9','.','.'}};
		SudokuSolver.solveSudoku(board);
		
		for(int i = 0; i < board.length; i++){
			System.out.println();
			for(int j = 0; j < board[0].length; j++){
				System.out.print(" " + board[i][j]);
				
			}
		}
	}
}
