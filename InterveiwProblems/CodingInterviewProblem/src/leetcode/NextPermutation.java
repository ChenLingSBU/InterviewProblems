package leetcode;
/*
 * Algorithm: 
 * 1. from right to left, find the first number violates the increasing trend, we call this number partition number;
 * 2. from right to left, find the first number which is larger than the partition number, we call this number change number;
 * 3. swap partition number and change number;
 * 4. reverse all the numbers after the partition number.
 */


import java.util.Arrays;

public class NextPermutation {
    public static class Element{
        public int value;
        public int index;
    }
    
    public static void nextPermutation(int[] num) {
        Element partition = findPartitionNum(num);
        if(partition == null){
            Arrays.sort(num);
            return;
        }
        Element change = findChangeNum(num, partition);
        
        swap(num, partition.index, change.index);
        reverse(num, partition.index + 1);
        
    }
    
    public static Element findPartitionNum(int[] num) {
        Element partition = new Element();
        for (int i = num.length - 1; i >= 1; i--){
            if(num[i - 1] < num[i]){
                partition.value = num[i-1];
                partition.index = i - 1;
                return partition;
            }
        }
        return null;
    }
    
    public static Element findChangeNum(int[] num, Element partition){
        Element change = new Element();
        for(int i = num.length - 1; i >= 0; i--){
            if(num[i] > partition.value){
                change.value = num[i];
                change.index = i;
                return change;
            }
        }
        return null;
    }
    
    public static void swap(int[] num, int pos1, int pos2){
        int temp = num[pos1];
        num[pos1] = num[pos2];
        num[pos2] = temp;
    }
    
    public static void reverse(int[] num, int pos){
        if(pos == num.length - 1)
            return;
        int j = num.length - 1;
        int temp;
        while(pos <= j){
            temp = num[pos];
            num[pos]=num[j];
            num[j] = temp;
            pos++;
            j--;
        }
    }
    
	public static void main(String[] args) {
		int[] num = {1,1,5};
		NextPermutation.nextPermutation(num);
		for(int i = 0; i< num.length; i++){
			System.out.print(" "+ num[i] );
		}
	}
}
