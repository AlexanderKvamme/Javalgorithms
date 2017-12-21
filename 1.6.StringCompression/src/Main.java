
public class Main {	
	
	public static void main(String[] args) {

		String str = "Aggggabbcccdddd";
		String str2 = "abcdef";
		String expectedResult = "A1g4a1b2c3d4";
		String actualResult = compress(str);
		
		// Perform tests
	
		System.out.printf("\n ended up returning: %s", compress(str));	
		System.out.printf("\n ended up returning: %s", compress(str2));
	}
	
	// Methods
	
	static String compress(String str) { 
		
		System.out.printf("\nCompressing %s", str);
		
		int strI = 0;
		int strJ = 1;
		int builderI = 0; 
		int count = 0;
		
		StringBuilder builder = new StringBuilder();		
		
		while (strJ < str.length()) {
			// Keep going until strJ has seen through all of them 
			builder.append(str.charAt(strI));
			count = 1;
			strJ = strI + 1;
			
			//System.out.printf("\n comparing %s and %s \n", str.charAt(strI), str.charAt(strJ));
			
			// check the following  letters
			while (strJ <= str.length()) {
				
				// I index J is at the end of the line, end it all
				if (strJ == str.length()) {
					builder.append(count);
					break;
					//return builder.toString();
				}
				
				// Keep looping
				if (str.charAt(strJ) == builder.charAt(builderI)) {
					count++;
					strJ++;
				} else {
					// Not the same, so add the number, and move pointers
					builder.append(count);
					builderI+= 2;
					strI = strJ;
					break;
				}
			}
		}

		if (builder.toString().length() < str.length()) {
			return builder.toString();
		} 
		
		return str;

	}
}
