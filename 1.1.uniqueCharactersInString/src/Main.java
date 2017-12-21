
// This O(n) time complexity, O(n) space complexity. You could trade the O(n) in space and get a O(n^2) 
// to reduce space complexity to O(n) by using a selectionSort type of comparing.

public class Main {

	public static void main (String[] args) {
		
		// Strings to test
		String[] uniqueStrings = {"alf", "ale0tom", " !-x+?", "fralk"};
		String[] notUniqueStrings = {"ploinp", "aa", "..", "dredriksen"};
		
		// Print out results
		for(String str : uniqueStrings) {
			System.out.println(isUnique(str));
		}
		
		for(String str : notUniqueStrings) {
			System.out.println(isUnique(str));
		}
		
		// Print out results frmo the bitflag style checker
		for(String str : uniqueStrings) {
			System.out.printf("\nboolean unique should be true: %s", isUniqueBoolean(str));
		}
		for(String str : notUniqueStrings) {
			System.out.printf("\nboolean unique should be false: %s", isUniqueBoolean(str));
		}
	}
	
	// Good old fashioned isUnique
	
	public static Boolean isUnique(String str) {
		
		boolean[] usedCharacters = new boolean[256];
		
		for (int i = 0;i < str.length(); i++) {
			int charAsInt = str.charAt(i);
			
			// Modify bool
			if (usedCharacters[charAsInt]) {
				return false;
			} else {
				usedCharacters[charAsInt] = true;
			}
		}
		
		return true;
	}
	
	// Bitwise operation based
	
	public static Boolean isUniqueBoolean(String str) {
		
		long bitMask = 0;
		
		for(int i = 0; i<str.length(); i++) {
			//System.out.printf("bitmask starts at: %s", bitMask );
			int characterValue = str.charAt(i) - 'a'; // a = 0, b = 1, ect.
			// make a bitflag for this char, and or it with the bitmask
			int charMask = 1 << characterValue; // bit set to 1, if 'a', shift 0 to the left. If 'b' shift 1 to the left
			//charMask << characterValue;
			//System.out.printf("\n bitmask: %s", Integer.toBinaryString(bitMask));
			//System.out.printf("\n charmask: %s", Integer.toBinaryString(charMask));
			
			if((bitMask&charMask) > 0 ) {
				return false;
			}
			
			bitMask|=charMask;
		}
		
		return true;
	}
	
	// Testprinting methods
	
	static void printBoolean(boolean[] bools) {
		System.out.println("Bool was:");
		for (boolean b : bools) {
			System.out.print(b ? 1:0);
		}
		System.out.println();
	}
}

