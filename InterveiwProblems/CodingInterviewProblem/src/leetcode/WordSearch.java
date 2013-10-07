package leetcode;


/*
 * it's a backtrace problem.
 * tricks: 
 * 1. use step[4][2] to calculate the left, up, right, down neighbors index.
 * 2. like note1, to restrict the range of the neighbors index, in case the neighbors index is out of bound.
 * 
 */

public class WordSearch {

	
    public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        boolean[][] used = new boolean[board.length][board[0].length];
        int[][] step = new int[4][2]; // step[i][0] indicates x, step[i][1] indicates y
        step[0][0] = -1; step[0][1] = 0 ; //left neighbor
        step[1][0] = 0 ; step[1][1] = -1; //up neighbor
        step[2][0] = 1 ; step[2][1] = 0 ; //right neighbor
        step[3][0] = 0 ; step[3][1] = 1 ; //down neighbor
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(used[i][j])
                    continue;
                
                if(board[i][j] == word.charAt(0)){
                    used[i][j] = true;
                    if(exist(step, used, board, word, i, j, 1))
                        return true;
                    used[i][j] = false;
                }
                    
            }
        }
        return false;
    }
    
    public static boolean exist(int[][] step, boolean[][] used, char[][] board, String word, int y, int x, int length){
        
        if(length == word.length())
            return true;
        
        for(int i = 0; i < 4; i++){
            int xx = x + step[i][0];
            int yy = y + step[i][1];
            if(xx >=0 && xx < board[0].length && yy >= 0 && yy < board.length){ //note1
                if(used[yy][xx])
                    continue;
                if(board[yy][xx] == word.charAt(length)){
                    used[yy][xx] = true;
                    if(exist(step, used, board, word, yy, xx, length + 1))
                        return true;
                    used[yy][xx] = false;
                }
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(WordSearch.exist(board, word));
	}
}
