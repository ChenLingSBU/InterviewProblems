package leetcode;


/*
 * Gray Code是格雷码.
 * there are two ways, one is to use math method, another is to use recursion + backtrace.
 * 
 * method 2: 假设有n-1的答案为：G0, G1, ..., Gn，想得到n的答案，只需要在G0...Gn左边加上一
 * 个0，再把G0...Gn颠倒顺序，在左边加上一个1即可。
 * 举例，n=3, 先求n=2, 为：
 * 00，01，11，10
 * 反序，为：
 * 10，11,01,00
 * 在原序每个元素左边加0，得到
 * list1: 000,001,011,010
 * 反序左边加1，得到
 * list2: 110,111,101,100
 */
import java.util.ArrayList;
public class GrayCode {

    public static ArrayList<Integer> grayCodeMath(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 1 << n;
        for(int i = 0; i < count; i++){
        	result.add((i >> 1)^i);  
        }
        
        return result;
    }
    
    public static ArrayList<Integer> grayCodeRecursion(int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n <= 1){
            result.add(0);
            if(n == 1)
                result.add(1);
          return result;
        }else{
            ArrayList<Integer> subRes = grayCodeRecursion(n - 1);
            int highbit = 1 << n - 1;
            for(int i = subRes.size() - 1; i >= 0; i--){
                result.add(subRes.get(i) + highbit);
            }
            
            subRes.addAll(result);
            return subRes;
        }
        
    }
	public static void main(String[] args) {
		int n = 2;	
		System.out.println(GrayCode.grayCodeMath(n));	
 		System.out.println(GrayCode.grayCodeRecursion(n));
	}
}
