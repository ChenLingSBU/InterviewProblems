package other;


import java.util.ArrayList;
public class FindLocalMinimum {

	public ArrayList<Integer> findLocalMin(int[] A){
		ArrayList<Integer> result = new ArrayList<Integer>();
		findLocalMin(A, result, 0, A.length - 1);
		return result;
	}
	
	public void findLocalMin(int[] A, ArrayList<Integer> result, int start, int end){
		if(end - start >= 2){
			int m = (start + end)/2;
			if(A[m] >= A[m - 1] && A[m + 1] >= A[m])
				result.add(A[m]);
			findLocalMin(A, result, start, m);
			findLocalMin(A, result, m, end);
		}
	}
}
