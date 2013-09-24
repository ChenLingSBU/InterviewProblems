package other;



/*
 * 代码用的位移法，这个不知道算不算作弊。
 * 普通方法参考 http://www.360doc.com/content/11/0308/14/5327079_99222581.shtml
 */
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
