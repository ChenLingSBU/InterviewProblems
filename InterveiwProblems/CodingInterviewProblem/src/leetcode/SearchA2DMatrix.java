package leetcode;

public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        
        int col = matrix[0].length - 1;
        int row = 0;
        
        while(row <matrix.length && col >= 0){
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }   
        }    
        return false;    
    }
	public static void main(String[] args) {
		int[][] matrix = {
		                  {1,   3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
		                  };
		int target = 3;
		System.out.println(SearchA2DMatrix.searchMatrix(matrix, target));

	}
}
