package leetcode;




/*
 * 
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
