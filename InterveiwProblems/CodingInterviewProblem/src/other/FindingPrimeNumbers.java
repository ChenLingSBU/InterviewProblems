package other;


/*
 * Finding prime numbers with the Sieve of Eratosthenes
 * See wiki
 */

public class FindingPrimeNumbers {


	public static int[] findPrimeNum(int max){
		boolean[] isComposite = new boolean[max + 1];
		for(int i = 2; i*i <= max; i++){
			if(!isComposite[i]){
				for(int j = i; i*j <= max; j++)
					isComposite[i*j] = true;			
			}
		}
		
		int primeNum = 0; 
		for(int i = 2; i <= max; i++){
			if(!isComposite[i]) primeNum++;
		}
		
		int[] prime = new int[primeNum];
		int index = 0;
		for(int i = 2; i <= max; i++){
			if(!isComposite[i]) prime[index++] = i;
		}
		
		return prime;
	}
	
	public static void main(String[] args) {
	
		int max = 25;
		
		int[] result = FindingPrimeNumbers.findPrimeNum(max);
		
		for(int num:result){
			System.out.print(num + " ");
		}
	}
}
