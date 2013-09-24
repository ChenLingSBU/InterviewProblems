package leetcode;

public class BestTimeToBuyAndSellStockII {

	   public int maxProfit(int[] prices) {
	       if(prices == null || prices.length == 0) return 0;
	       
	       int maxProfit = 0;
	       int start = prices[0];
	       
	       for(int i = 1; i < prices.length; i++){
	           if(prices[i] > prices[i - 1])
	                continue;
	            maxProfit += prices[i - 1] - start;
	            start = prices[i];
	       }
	       
	       maxProfit += prices[prices.length - 1] - start;
	       
	       return maxProfit;
	    }
	public static void main(String[] args) {
		
	}
}
