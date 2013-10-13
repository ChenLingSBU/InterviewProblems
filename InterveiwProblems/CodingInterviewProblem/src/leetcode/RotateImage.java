package leetcode;


/*
 * The trick is how to calculate the index.
 * we can calculate first index and last index every time when we enter a new layer.
 * note2: i must less than last, cannot be less or equal. otherwise the last element in the row or col will be calculated two times.
 */

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++ ){
            int first = layer; // note1
            int last =  n - 1 - layer;
            for(int i = first; i < last; i++){//note2
               int offset = i - first;
               int top = matrix[first][first + offset];
               matrix[first][first + offset] = matrix[last - offset][first];
               matrix[last - offset][first] = matrix[last][last - offset];
               matrix[last][last - offset] = matrix[first + offset][last];
               matrix[first + offset][last] = top;
            }
        }
     }

	public static void main(String[] args) {

	}
}
