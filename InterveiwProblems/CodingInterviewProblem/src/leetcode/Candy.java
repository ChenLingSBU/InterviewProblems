package leetcode;


/*
 * 1-dim dp.   
 * 3 situations: note1; note2; note3. 
 */

public class Candy {

    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] == ratings[i - 1]) //note1
                dp[i] = 1;
            if(ratings[i] > ratings[i - 1])  //note2
                dp[i] = dp[i - 1] + 1;
            if(ratings[i] < ratings[i - 1]){ //note3
                dp[i] = 1;
                if(dp[i - 1] == 1){
                    int j = i;
                    while(j >= 1 && ratings[j] < ratings[j - 1] && dp[j] == dp[j - 1]){
                        dp[j - 1]++;
                        j--;
                    }
                }
            }
        }
        
        int sum = 0;
        for(int num : dp)
            sum += num;
        return sum;
    }
	
	public static void main(String[] args) {
	
	}
}
