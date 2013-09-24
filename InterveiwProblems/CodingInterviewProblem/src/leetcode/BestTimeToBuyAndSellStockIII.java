package leetcode;



/*
 * the meaning of the problem is to make the array into 2 partitions, thus the total sum of the two partitions are maximum.
 * The tricky is :
 * we scan the array two times. 
 * 1. the first time, scan the array from left to right, and store info in firstPart[i], i means maximum profit ending at i
 * 2. the second time, scan from the right to left, store info in secondPart[j], here j means maximum profit start at j.
 * Thus we have two windows, and every time we store the max sum of firstPart[i] and secondPart[i].
 * By this way we have made the max profit at most two transactions.  
 */


public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
        int maxProfit = 0;
        int[] firstPart = new int[prices.length];
        int[] secondPart = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            minV = Math.min(minV, prices[i]);
            if(i > 0){
                firstPart[i] = Math.max(firstPart[i - 1], prices[i] - minV);
            }
        }
        
        for(int i = prices.length - 1; i >= 0; i--){
            maxV = Math.max(maxV, prices[i]);
            if(i < prices.length - 1){
                 secondPart[i] = Math.max(secondPart[i + 1], maxV - prices[i]);
            }
             maxProfit = Math.max(maxProfit, firstPart[i] + secondPart[i]);
        }
        
        return maxProfit;
     }
	public static void main(String[] args) {
		
	}
}
