package other;

/*
 * It's a Facebook interview question.
 * use classic two pointers/slide window method.
 *
 * Implement a function string balanceParanthesis(String s); which given a String s consisting of some
 * parenthesis returns a string s1 in which parenthesis are balanced and differences between s and s1 are minimum. 
 * Eg - "(ab(xy)u)2)" -> "(ab(xy)u)2" ")))(((" ->""
 *
 */

/*
 * Solution:
 * Here Balance in the problem means the total num of '(' is as the same as the total num of ')'.
 * It's another classic two pointers scan problem.  see codes below for details.
 */

public class BalanceParanthesis {
	public static String balanceParanthesis(String s){
		int last = s.length() - 1;    // last index of s
		int pairs = 0;
		String balance = "";
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				while(s.charAt(last)!=')' && last > i)
					last--;
				if(last <= i) continue;
				else{
					pairs++;
					balance+=s.charAt(i);
					}
				}
			else if(s.charAt(i) == ')'){
				if(pairs > 0){
					pairs--;
					balance+=s.charAt(i);
					}
				}
			else 
				balance+=s.charAt(i);
				
			}
		
		return balance;
	}
				
	public static void main(String[] args) {
		String s = "(ab(xy)u)2)";
		System.out.println(BalanceParanthesis.balanceParanthesis(s));
	}
}
