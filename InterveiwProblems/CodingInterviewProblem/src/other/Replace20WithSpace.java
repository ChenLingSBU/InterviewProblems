package other;

public class Replace20WithSpace {
	
	public static String replace(String strIn){
		char[] charArray = strIn.toCharArray();
		int counter = counterChangePostions(charArray, 0);
		int originalLength = charArray.length;
		int newLength = originalLength - 2*counter;
		int changePos;
		for(int i = 0; i< counter; i++){
			changePos = findChangePosition(charArray);
			moveForward(charArray, changePos);
		}	
		return new String(charArray,0,newLength);	
	}
	
	public static void moveForward(char[] charArray, int changePos){
		for(int pos = changePos +1 ; pos + 2 <charArray.length; pos++){
			charArray[pos] = charArray[pos + 2];
		}
	}
	
	public static int counterChangePostions(char[] charArray, int counter){
		for(int i = 0; i< charArray.length; i++){
			if(charArray[i] == '%'){
				counter++;
			}	
		}
		return counter;	
	}
	
	public static int findChangePosition(char[] charArray){
		for(int pos = 0; pos< charArray.length; pos++){
			if(charArray[pos] == '%'){
				charArray[pos] = ' ';
				return pos;
			}	
		}
		return charArray.length - 1; //not find change position
	}

	public static void main(String[] args) {
		String str = "Mr%20John%20smith.";
		System.out.println(Replace20WithSpace.replace(str));
	}

}
