package leetcode;


/*
 * 1.left Parent: as long as we haven't used up all the left parentheses, we can always insert a left parentheses,
 * 2.right parent: we can insert a right parent parenthese as long as it it won't lead to a syntax error.
 * syntax error: we will get a syntax error if there are more right parentheses than left.
 */
import java.util.ArrayList;

public class GenerateParentheses {

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if(n < 1) return result;
        char[] str = new char[n*2];
        generateParenthesis(result, str, n, n, 0);
        return result;
    }
    
    public static void generateParenthesis(ArrayList<String> result, char[] str, int leftParent, int rightParent, int count){
        if(leftParent < 0 || rightParent < leftParent) return;
        if(leftParent == 0 && rightParent == 0){
            result.add(new String(str));
            return;
        }else{
            if(leftParent > 0){
                str[count] = '(';
                generateParenthesis(result, str, leftParent - 1, rightParent, count + 1);
            }
            if(rightParent > leftParent){
                str[count] = ')';
                generateParenthesis(result, str, leftParent, rightParent - 1, count + 1);
            }
        }
    }
	
	public static void main(String[] args) {
		System.out.println(GenerateParentheses.generateParenthesis(2));
	}
}
