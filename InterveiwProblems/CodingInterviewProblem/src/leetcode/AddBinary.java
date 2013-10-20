package leetcode;


/*
 * about note1 and note2:
 * look at this case:
 * 
 * int a = 1;
 * what's the value of a after this: a = a--?
 * it's still 1.  don't use this express. use a = a - 1 instead. 
 * 
 */

public class AddBinary {

    public static String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        int posA = a.length() - 1;
        int posB = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(posA >= 0 || posB >= 0){
            int va = posA >= 0? a.charAt(posA) - '0' : 0;
            int vb = posB >= 0? b.charAt(posB) - '0' : 0;
            result.append((va + vb + carry)%2);
            carry = (va + vb + carry)/2;
            posA = posA >= 0? posA - 1 : posA; // note1.
            posB = posB >= 0? posB - 1 : posB; // note2.
        }
        if(carry > 0)
            result.append(1);
        return new String(result.reverse());
    }
    
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(AddBinary.addBinary(a, b));
		int aa = 1;
		aa = aa--;
		System.out.println(aa);
	}
}
