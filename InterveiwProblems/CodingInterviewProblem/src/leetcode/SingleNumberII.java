package leetcode;



public class SingleNumberII {

	
	/*
	 * note here, must use long a. otherwise would be error here. 
	 */
    public int singleNumber(int[] A) {
        int[] arr = new int[32];
        for(int num : A)
           generateBits(arr, num);
        int result = 0;
        for(int i = 0; i < 32; i++){
            result |= (arr[i] % 3) << i;
        }
        
        return result;
     }
     
     public void generateBits(int[] A, int num){
         int counter = 0;
         long a = 1;//note
         while(counter < 32){
             if((num & (a<<counter)) > 0)
                 A[counter]++;
             counter++;
         }
     }
     
	public static void main(String[] args) {

	}
}
