package other;



/*
 * Minimum number of coins needed to represent an amount.
 * Given a set of currency denominations, find the minimum number of coins needed to represent an amount
 */
import java.util.Arrays;
public class MinimumNumberOfCoins {

	public static int minNum(int[] set, int amount){
		int[] c = new int[amount + 1];
		Arrays.fill(c, Integer.MAX_VALUE);
		c[0] = 0;
		for(int i = 1; i <= amount; i++){		
			for(int j = 0; j < set.length; j++){
				if(i - set[j] >= 0){
					c[i] = Math.min(c[i - set[j]] + 1, c[i]);
				}else
					break;
			}
		}		
		return c[amount];
	}
	
	public static void main(String[] args) {
		int[] set = {1, 3, 5};
		int amount = 11;
		System.out.println(MinimumNumberOfCoins.minNum(set, amount));
	}
}
