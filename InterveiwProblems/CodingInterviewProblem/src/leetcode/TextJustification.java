package leetcode;


/*
 * Text Justification 中文 : 文本对齐
 * use greedy method, put words as many as possible in one line, 
 * the most tricky point is how to deal with the spaces between words such that the spaces should be as evenly as possible.
 * 
 */
import java.util.ArrayList;
public class TextJustification {

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        int begin = 0, len = 0, n = words.length;
        for(int i = 0; i < n; i++){ // greedy to find the longest string. 
            if(len + words[i].length() + (i - begin) > L){ // (i - begin) is the spaces needed between words.  
                result.add(connect(words, begin, i - 1, len, L, false)); // find the longest string, then use 'connect' to arrange spaces between words.
                begin = i; // start a new line, begin is the index of first word in the new line.
                len = 0; // new length of the new line.
            }
            len += words[i].length();
        }
        result.add(connect(words, begin, n - 1, len, L, true)); // the last line didn't be touched in the for loop, should add last line to Arraylist here.
        return result;
        
    }
    
   
    public String connect(String[] words, int begin, int end, int len, int L, boolean leftJustified){
        StringBuilder str = new StringBuilder();
        int n = end - begin + 1; // n is the number words in this line. end and begin is the index, so we have to add 1, that we can get the words number.
        for(int i = 0; i < n; i++){ // i is used as a offset here. 
            str.append(words[begin + i]);
            addSpace(str, i, n - 1, L - len, leftJustified); // be careful here, it should be (n - 1), because (L - len) means how many spaces we have to pad
                                                             // (L - len)/(n - 1) means we should dived (L-len) into (n-1) blocks.
            												 // why (n - 1)? if we have two words in a line, we have to pad 1 blocks spaces between words.
            												 // if we have 3 words in a line, we have to pad 2 blocks spaces between. so it's (n-1)!
        }
        if(str.length() < L){    // it's the special case that there's only one word in a line, thus we should pad spaces after that word.
            int l = str.length();
            for(int i = 0; i < L - l; i++)
                str.append(" ");
        }
        return new String(str);
    }
    
    public void addSpace(StringBuilder str, int i, int n, int L, boolean leftJustified){
        if(n < 1 || i == n) return; // check whether it's the last word in the line, if it is, then we don't have to pad spaces after the last word.
        int space = leftJustified? 1 : (L/n + (i < L%n? 1 : 0)); // if can the left spaces and right spaces are evenly, it's L/n, otherwsie L/n + 1. 
        for(int j = 0; j < space; j++){
            str.append(" ");
        }
    }
    
	public static void main(String[] args) {
		
	}
}
