package leetcode;



/*
 * the largest Roman Number is 3888;
 * deal with digit one by one.
 * and in roman function, there are 4 different cases we need deal with them separately.
 * note1: how to get the number in each digit. 
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        
        str.append(roman(num/1000%10, '0', '0', 'M')); // note1
        str.append(roman(num/100%10, 'M', 'D', 'C'));
        str.append(roman(num/10%10, 'C', 'L', 'X'));
        str.append(roman(num%10, 'X', 'V', 'I'));
        
        return new String(str);
    }
    
    public String roman(int num, char ten, char five, char one){
        StringBuilder s = new StringBuilder();
        if(num == 9){
            s.append(one);
            s.append(ten);
        }
        else if(num >= 5){
            s.append(five);
            while(num-- > 5)
                s.append(one);
        }
        else if(num == 4){
            s.append(one);
            s.append(five);
        }
        else{
            while(num-- > 0)
                s.append(one);
        }
        
        return new String(s);
    }
	public static void main(String[] args) {
		
	}
}
