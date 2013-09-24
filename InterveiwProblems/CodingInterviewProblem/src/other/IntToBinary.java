package other;

public class IntToBinary {
	 public static String toFullBinaryString(int num) {
	        char[] chs = new char[Integer.SIZE];
	        for(int i = 0; i < Integer.SIZE; i++) {
	            chs[Integer.SIZE - 1 - i] = (char)(((num >> i) & 1) + '0');
	        }
	        return new String(chs);        
	    }
	public static void main(String[] args) {
		System.out.println(IntToBinary.toFullBinaryString(-20));

	}

}
