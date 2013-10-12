package leetcode;

/*
 * two algorithms
 * 1. O(m+n)space.
 * 2. constant space.
 * 
 * for method 2: we just use the matrix itself to store information we want. but how?
 * we use the first row and first col as storage. 
 * everytime if there's an element in this row or this col, we set the same col of the first row 0, set the same row of the first col 0
 * then use this information to set up all the positions other than the first row and first col
 * at last, to set up the first row and first col.
 * 
 */
public class SetMatrixZeroes {

    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m <= 0 || n <= 0) return;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i]||col[j])
                    matrix[i][j] = 0;
            }
        }
        
    }
    
    
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        //detect the first row and first col;
        for(int col = 0; col < n; col++){
            if(matrix[0][col] == 0){
                 row0 = true;;
                 break;
            }
        }
        
        for(int row = 0; row < m; row++){
            if(matrix[row][0] == 0){
                col0 = true;;
                break;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                     matrix[i][j] = 0;
            }
        }
        
        if(row0){
            for(int i = 0; i < n; i++)
                 matrix[0][i] = 0;
        }
        if(col0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        
     }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
