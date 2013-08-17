package leetcode;
/*
 * assume we have found the kth permutation, a1 a2 a3....an. 
 * So we should figure out what's the value of every digit, like what's the value of a1,
 * what's the value of a2, and so on.
 * Let's take a1 for example, we know that there're (n-1)! numbers permutations that with the 
 * first value of a1, so we could get the value of a1 by this way:   
 * k1 = k;
 * a1 = k1/(n-1)!
 * Then we get a1, and we continue this way to get a2:
 * k2 = k1%(n-1)!
 * a2 = k2/(n-2)!
 * ....
 * ....
 * Thus we get every element of the permutation. 
 */
public class PermutationSequence {
public String getPermutation(int n, int k) {
        
        if(n < 1 || n > 9) return null;
        int permCount = getFactorial(n);
        if(k < 1 || k > permCount) return null;
        int[] set = initSet(n);
        char[] permutation = new char[n];
        k--; // decrease k by 1, thus we can use k as index.
        for(int i = 0; i < n; i++){
            permCount = permCount/(n-i); // permCount = (n - 1)!.
            int index = k/permCount;
            permutation[i] = (char) ('0' + set[index]);
            //because set[index] has been picked up, we should update the set
            for(int j = index; j < n - i - 1; j++) {
                set[j] = set[j+1];
            }
            k = k%permCount;
        }
        
        return new String(permutation);
        
    }
    
    public int getFactorial(int n) {
        int product = 1;
        while(n > 0) {
            product = product * n;
            n--;
        }
        return product;
    }
    
    public int[] initSet(int n) {
        int[] set = new int[n];
        for(int i = 0; i < n; i++) {
            set[i] = i+1;
        }
        return set;
    }
    
    public static void main(String[] args) {
    	PermutationSequence ps = new PermutationSequence();
    	System.out.println(ps.getPermutation(3, 4));
    }
}
