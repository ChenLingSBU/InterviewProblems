package leetcode;


/*
 * the difficult of this problem is to calculate the index. take below as example, the number indicates the index of that position.
 * 
 * 0   6        12
 * 1  5 7     11 
 * 2 4   8  10
 * 3      9
 */
public class ZigZagConversion {

    public static String convert(String s, int nRows) {
        if(nRows <= 1) return s;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < nRows; i++){
            for(int j = 0, index = i; index < s.length(); j++, index = (2*nRows - 2)*j + i){
                str.append(s.charAt(index));
                if(i == 0 || i == nRows - 1)
                     continue;
                if(index + (nRows - i - 1)*2 < s.length()){
                str.append(s.charAt(index + (nRows - i - 1)*2));
                }
            }
        }
        
        return new String(str);
     }
    
	public static void main(String[] args) {
		String s = "kllozdbndjizayyrljxrfofvyiylqqlbbypcbtqeeydgwdykpvbwmhrkrpwifjljjcllxbrbcxkacikrfmqrvjemzcugnfrw";
		int nRows = 91;
		System.out.println(ZigZagConversion.convert(s, nRows));
	}
}
