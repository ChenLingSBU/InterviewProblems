package leetcode;

/*
 * Negative number is not palindrome Number. 
 * notes: 
 * note1, take 121 for an example, if it's x = x%div, the result is 21, but if it's x = x%vid/10, it's 2.
 * note2. since everytime x loses two digits, therefore, div should divided by 100, not 10. 
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int div = 1;
        while(x/div >= 10){
            div *= 10;
        }
        
        while(x > 0){
            int l = x/div;
            int r = x%10;
            if(l != r) return false;
            x = x%div/10; //note1.
            div /= 100; //note2
        }
        return true;
    }
	public static void main(String[] args) {

	}
}
