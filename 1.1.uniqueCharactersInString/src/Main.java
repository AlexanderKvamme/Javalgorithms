
public class Main {

	public static void main (String[] args) {
		
		// Strings to test
		String[] uniqueStrings = {"Alf", "Ale0tom", " !-x+?"};
		String[] notUniqueStrings = {"aa", "  ", "99", "Fredriksen"};
		
		// Print out results
		for(String str : uniqueStrings) {
			System.out.println(isUnique(str));
		}
		for(String str : notUniqueStrings) {
			System.out.println(isUnique(str));
		}
	}
	
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
	
	static void printBoolean(boolean[] bools) {
		System.out.println("Bool was:");
		for (boolean b : bools) {
			System.out.print(b ? 1:0);
		}
		System.out.println();
	}
}

