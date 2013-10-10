package leetcode;


/*
 * it's classic stack used matching problem.
 * we can use one stack, every time if it's an open parentheses, push it into stack
 * every time if it's a close parentheses, if the top of stack is not the open parentheses in the type of the close parentheses,
 * return false.
 * 
 * don't forgot to check whether stack is empty, like note 1.
 */
import java.util.Stack;
public class ValidParentheses {

    public static boolean isValid(String s) {
       Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
                 continue;
            }
            if(stack.empty() || (s.charAt(i) == ')' && stack.peek() != '(')) //note1. 
                return false;
            if(stack.empty() || (s.charAt(i) == ']' && stack.peek() != '['))
                return false;
            if(stack.empty() || (s.charAt(i) == '}' && stack.peek() != '{'))
                return false;
            stack.pop();
        }
        if(!stack.empty())
            return false;
        return true;
    }
	public static void main(String[] args) {
		String s = "[])";
		System.out.println(ValidParentheses.isValid(s));
	}
}
