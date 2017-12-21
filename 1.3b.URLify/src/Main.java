
public class Main {

	public static void main(String[] args) {
		char[] charsToTest = "Alf G".toCharArray(); // Expected output: "Alexander%20Kvamme"
		
		char[] res = URLify(charsToTest);
		System.out.println("result on next line:");
		System.out.print(res);
	}
	
	// Methods
	
	static char[] URLify(char[] chars) {
		
		int oldLength = chars.length;
		int i = 0;
		int spaces = 0;
		
		// Count spaces
		for(i = 0; i < oldLength; i++) {
			if (chars[i] == ' ') {
					spaces++;
			}
		}
		
		// Increase size		
		int newLength = oldLength + spaces * 2;

		// Loop back and move characters to proper position
		char[] newChars = new char[newLength];
		
		int indexOld = oldLength - 1;
		int indexNew = newLength - 1; 
		
		for(indexOld = oldLength-1; indexOld>=0; indexOld--) {
			// Copy over '%20' instead of ' '
			if (chars[indexOld] == ' ') {
				System.out.println("was space");
				newChars[indexNew] = '0';
				newChars[indexNew - 1] = '2';
				newChars[indexNew - 2] = '%';
				indexNew -= 3;
			} else {
				System.out.println(chars[indexOld]);
				// copy over as usual
				newChars[indexNew] = chars[indexOld];
				indexNew--;
			}
		}
		
		// Return
		return newChars;
	}
}

