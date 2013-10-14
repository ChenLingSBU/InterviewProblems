package leetcode;


/*
 *  it's similar to the Spiral MatrixI and rotate image.
 *  there's only one big difference between Spiral Matrix and Rotate Image is 
 *  we have to deal with n%2 = 1 in Spiral Matrix, while we don't have to in Rotate Image
 *  it's because if the case that n%2 = 1 comes up in the Rotate Image, 
 *  it means we have one element that we didn't touch whose position is n/2, n/2, 
 *  and in rotate image, the element in position of n/2, n/2 ought to be untouched, just leave it alone.
 */
public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int j = 1;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++)
                matrix[first][i] = j++;
            for(int i = first; i < last; i++)
                matrix[i][last] = j++;
            for(int i = last; i > first; i--)
                matrix[last][i] = j++;
            for(int i = last; i > first; i--)
                matrix[i][first] = j++;
        }
        
        if(n%2 == 1){
           matrix[n/2][n/2] = j;
        }
        
        return matrix;
    }
	public static void main(String[] args) {
		int n = 4;
		int matrix[][] = SpiralMatrixII.generateMatrix(n);
		for(int i = 0; i < n; i++){
			if(i!=0)
				System.out.println();
			for(int j = 0; j < n; j++){
				System.out.print(matrix[i][j] + " ");
			}
			
		}
	}
}
