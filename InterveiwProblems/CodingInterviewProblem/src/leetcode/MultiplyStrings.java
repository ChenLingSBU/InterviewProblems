package leetcode;


/*
 * notes: 
 * note1: the length of result that multiplied by a and b has two possible values. 1.) a.length + b.length. 2.) a.length + b.length - 1
 * note2: it's better to explicitly initialize the result and subResult, otherwise may cause some problem while using result.charAt(i) += ....
 * note3: we should add in the reverse way, because we might have carrier to advance to the prior advanced position.
 * note4: we have to check whether there's carrier to the highest position. it's why we start store result in the 1 index other than 0 index in note5.
 * the 0 index position is reversed for carrier.
 */
import java.util.Arrays;
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0'|| num2.charAt(0) == '0') return "0";
        char[] result = new char[num1.length() + num2.length()]; //note1
        int[] subResult = new int[result.length];
        Arrays.fill(result, '0'); //note2
        Arrays.fill(subResult, 0);
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                subResult[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // note5
            }
        }
        
        for(int i = subResult.length - 1; i > 0; i--){//note3
            if(subResult[i] > 9) subResult[i - 1] += subResult[i]/10;
            result[i] += subResult[i]%10;
        }
        
        result[0] += subResult[0]; //note4
        return result[0]=='0'?new String(Arrays.copyOfRange(result, 1, result.length)):new String(result);
    }
	
	public static void main(String[] args) {
		String num1 = "234";
		String num2 = "26";
		System.out.println(MultiplyStrings.multiply(num1, num2));
	}
}
