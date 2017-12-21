
public class MainRefactored {

	public static void main(String[] args) {
		

		boolean[] vector = new boolean[3];
		
		vector = vector - 1;
		printBitvector(vector);
	}
	
	// Methods
	
	public static boolean isPalindromePermutation(String str) {
		
		boolean[] bitvector = new boolean[256];
		char[] chars = str.toCharArray();
		
		// Flagged bitvectors indicate and odd number of a letter. ie. 0001 indicates that there are 1,3,5... etcs occurrences of 'a'
		
		for (int i = 0; i<str.length(); i++) {
			int character = chars[i];
			int characterValue = getCharValue(chars[i]);
			
			// Spaces can be shuffled around and can be even or odd and
			// still make a palindrome. should not be counted as a character
			if (character == ' ') {
				continue;
			}
			
			if (bitvector[characterValue] == true) {
				bitvector[characterValue] = false;
			} else {
				bitvector[characterValue] = true;
			}
		}
		
		printBitvector(bitvector);
		
		// Return true or false based on the count of odd occurences
		int oddOccurences = 0;
		
		for (boolean b : bitvector) {
			if (b == true) {
				oddOccurences++;
			}
		}
		
		return oddOccurences<=1;
	}
	
	// Helper Methods
	
	static int getCharValue(char c) {
		return c - ' ';
	}
	
	static void printBitvector(boolean[] bitvector) {
		for (boolean b : bitvector) {
			System.out.printf("%s", b == false ? 0 : 1);
		}
	}
}

