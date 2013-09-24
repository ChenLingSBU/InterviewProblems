package leetcode;


/*
 * The basic idea is similar to "Maximum subarray". look back to that problem. 
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        
        return maxProfit;
     }
	public static void main(String[] args) {
		
	}
}
