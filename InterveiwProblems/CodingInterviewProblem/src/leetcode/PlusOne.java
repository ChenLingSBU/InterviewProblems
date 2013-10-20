package leetcode;



public class PlusOne {

    public int[] plusOne(int[] digits) {
        if(digits.length == 0 || digits == null) return null;
        
        int carry = 1;
        int pos = digits.length - 1;
        
        while(pos >= 0 && carry > 0 ){
            int tmpVal = digits[pos] + carry;
            digits[pos] = tmpVal%10;
            carry = tmpVal/10;
            pos--;
        }
        
        if(carry > 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            int i = 0;
            while(i < digits.length) newDigits[i + 1] = digits[i++];
            return newDigits;
        }
        
        return digits;
     }
    
	public static void main(String[] args) {

	}
}
