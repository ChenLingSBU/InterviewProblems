package leetcode;


/*
 *  similar to Sudoku Solver
 *  https://github.com/ChenLingSBU/InterviewProblems/blob/master/InterveiwProblems/CodingInterviewProblem/src/leetcode/SudokuSolver.java
 */

import java.util.Arrays;
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                else{
                    if(!checkValid(board, i, j))
                        return false;
                }
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
		
	}
}
