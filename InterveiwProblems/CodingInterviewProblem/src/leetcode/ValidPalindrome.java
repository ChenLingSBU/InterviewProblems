package leetcode;

public class ValidPalindrome {
	
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;        
        while(start <= end){
            while(!isValidCharacter(charArray[start])){
                start++;
                if(start > end) return true;
            }                
            while(!isValidCharacter(charArray[end])){
                 end--;
                 if(start > end) return true;
            }    
            if(charArray[start] == charArray[end]){
                start++;
                end--;
                continue;
            }
            else
                return false;
        }
        return true;        
    }
    
    public static boolean isValidCharacter(char c){
        if(c >= 'a' && c <='z' || c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
    
    
	public static void main(String[] args) {
		String s = "1a2";
		System.out.println(ValidPalindrome.isPalindrome(s));		
	}
}
