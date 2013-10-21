package leetcode;

/*
 * using rolling array.
 */
import java.util.ArrayList;
public class PascalsTriangleII {

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        if(rowIndex < 0) return row;
        int i = 1;
        row.add(1);
        while(i <= rowIndex + 1){
            for(int j = i - 1; j > 0; j--){
                if(j == i - 1)
                	row.add(1); 
                else
                    row.set(j, row.get(j)+row.get(j - 1));
                }
            
            i++;
        }
        
        return row;
    }
	public static void main(String[] args) {
		int rowIndex = 3;
		System.out.println(PascalsTriangleII.getRow(rowIndex));
	}

}
