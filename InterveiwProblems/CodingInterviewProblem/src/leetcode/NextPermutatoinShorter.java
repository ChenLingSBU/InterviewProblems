package leetcode;
/*
 * The algorithm is exactly the same as NextPermutatoin:
 * https://github.com/ChenLingSBU/InterviewProblems/blob/master/
 * InterveiwProblems/CodingInterviewProblem/src/leetcode/NextPermutation.java
 * 
 * try to use a simpler way to code. write everyting in one func. 
 * 
 */


import java.util.Arrays;

public class NextPermutatoinShorter {
    public void nextPermutation(int[] num) {
        int end = num.length - 2;
        int index = 0;
        
        while(end >= 0){
            if(num[end] < num[end + 1]){
                index = end;
                break;
            }      
            else
                end--;
        }
       if(end < 0 ){
            Arrays.sort(num);
            return;
        }
        end = num.length - 1;
        while(end >= 0){
            if(num[end] > num[index]){
                int temp = num[end];
                num[end] = num[index];
                num[index] = temp;
                break;
            }            
            end--;
        }
        end = num.length - 1;
        int start = index + 1;
        while(start <= end){
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }
	public static void main(String[] args) {
		int[] num = {1,1,5};
		NextPermutation.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}

}
