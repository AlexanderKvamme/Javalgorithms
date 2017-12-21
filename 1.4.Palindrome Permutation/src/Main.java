
public class Main {

	public static void main(String[] args) {
		
		// Test
		
		String[] shouldBeTrue = {"baccab", "bacab", "tact coa"};
		String[] shouldBeFalse = {"bac", "alf", "dork"};
	
		System.out.println("The next words should be TRUE");
		for (String word : shouldBeTrue) {
			System.out.printf("\n%s \n", isPalindromePermutation(word));
		}
		
		System.out.println("The remaining words should be FALSE");
		
		for (String word : shouldBeFalse) {
			System.out.printf("\n%s \n", isPalindromePermutation(word));
		}
	}
	
	// Methods
	
	public static boolean isPalindromePermutation(String str) {
		
		boolean[] bitvector = new boolean[256];
		char[] chars = str.toCharArray();
		
		// Flagged bitvectors indicate and odd number of a letter. ie. 0001 indicates that there are 1,3,5... etcs occurrences of 'a'
		
		for (int i = 0; i<str.length(); i++) {
			
			int characterValue = chars[i] - ' ';
			
			// Spaces can be shuffled around and can be even or odd and
			// still make a palindrome. should not be counted as a character
			if (chars[i] == ' ') {
				continue;
			}
			
			if (bitvector[characterValue] == true) {
				bitvector[characterValue] = false;
			} else {
				bitvector[characterValue] = true;
			}
		}
		
		// Testprint
		
		for (boolean b : bitvector) {
			System.out.printf("%s", b == false ? 0 : 1);
		}
		
		// Return true or false
		int oddOccurences = 0;
		
		for (boolean b : bitvector) {
			if (b == true) {
				oddOccurences++;
			}
		}
		
		return oddOccurences<=1;
	}
	
	// toggle method
	
	
}

