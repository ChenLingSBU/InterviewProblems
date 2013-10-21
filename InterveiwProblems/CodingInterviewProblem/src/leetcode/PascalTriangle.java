package leetcode;


import java.util.ArrayList;
public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return triangle;
        int i = 1;
        while(i <= numRows){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j < i; j++ ){
                if(j == 0 || j == i - 1) row.add(1);
                else{
                    row.add(triangle.get(i-2).get(j)+triangle.get(i-2).get(j-1));
                }
            }
            triangle.add(row);
            i++;
        }
        
        return triangle;
    }
	
	public static void main(String[] args) {
	
	}
}
