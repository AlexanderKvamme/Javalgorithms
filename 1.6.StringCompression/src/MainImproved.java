
public class MainImproved {
	
	public static void main(String[] args) {

		String str = "abcdef"; // 12
		String str2 = "Aggggabbcccdddd"; // 12
		
		String expectedResult = "A1g4a1b2c3d4";
		String actualResult = compress(str);
		
		// Perform tests on length
	
		System.out.printf("str1 compressedLength: %s \n ", compressedLength(str));	
		System.out.printf("str2 compressedLength: %s \n ", compressedLength(str2));
		
		// Perform tests on actual compression
		System.out.println(compress(str2));
	}
	
	// Methods
	
	static String compress(String str) {
		
		// abbcccdddd
		
		int compressedLength = compressedLength(str);
		int consecutives = 1;
		
		// Guard length will actually improve
		if (compressedLength > str.length()) return str;
		
		// Start compression
		StringBuilder compressed = new StringBuilder(compressedLength);
		
		for(int i = 0; i < str.length(); i++) {

			// if there is no next letter to compare, or, if the next letter is different from the last, add letter and count.
			// - If theres no next letter to compare, the for loop will end and we are done
			// - If the letters are different, 'e4' for example will be added, and we move on to the next character.
			if ((i+1 >= str.length() || str.charAt(i) != str.charAt(i+1))) {
				compressed.append(str.charAt(i));
				compressed.append(consecutives);
				consecutives = 1;
			} else {
				consecutives++;
			}
		}
		
		return compressed.toString();
	}
	
	// Compressed length
	
	static int compressedLength(String str) {
		
		int consecutives = 0;
		int compressedLength = 0;

		for(int i = 0; i < str.length(); i++) {
		
			if ( i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {	
				compressedLength += 1 + String.valueOf(consecutives).length();
				consecutives = 0;
			} else {
				consecutives++;
			}	
		}
		
		return compressedLength;
	}
}

