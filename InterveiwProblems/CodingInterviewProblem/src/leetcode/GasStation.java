package leetcode;


/*
 * sum is the total amount of gas at current time, is the gas is not enough for reaching the next station, 
 * advance start until the amount of gas is enough for reaching the next station from current station.
 * if there doesn't exist such a start point, we set up start to next station, and set up sum to 0. 
 */

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if(cost.length != len) return -1;
      
        int[] flag = new int[2*len];
        for(int i = 0; i < len; i++) 
            flag[i] = gas[i] - cost[i];
        for(int j = len; j < len*2; j++)
            flag[j] = flag[j - len];
        
        int sum = 0, start = 0;
        
        for(int i = 0; i < len + start && start < len; ){
            sum += flag[i];
            if(sum >= 0){
                i++;
                continue;
            }
            
            while(sum < 0 && start < i){
                sum -= flag[start];
                start++;
            }
            
            i++;
            if(sum < 0)
                sum = 0;
                start = i;
        }
        
        if(start < len)
            return start;
        return -1;
    }
	public static void main(String[] args) {
	
	}
}
