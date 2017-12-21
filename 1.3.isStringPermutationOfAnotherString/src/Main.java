import java.util.HashMap;

public class Main {

	// Main 
	
	public static void main(String[] args) {
		
		String str1 = "bamm";
		String str2 = "mmba";
		
		System.out.println(isPermutationOf(str1,str2));
	}
	
	// Methods
	
	static boolean isPermutationOf(String str1, String str2) {
	
		// Must be equal length
		if (str1.length() != str2.length()) {
			return false;
		}
		
		int stringLength = str1.length();
		
		HashMap<Character, Integer> characterCountMap = new HashMap<>();
		
		for(int i = 0; i<stringLength; i++) {
			Character currentChar = str1.charAt(i);

			// Insert each character into HashMap
			
			if(characterCountMap.containsKey(currentChar)) {
				// if exists, increment existing value by 1
				Integer newValue = characterCountMap.get(currentChar) + 1;
				characterCountMap.put(currentChar, newValue);
			} else {
				// if doesnt exist, put 1
				characterCountMap.put(currentChar, 1);
			}
		}
		
		// All characters from str1 are now in the map
		// Loop through all of the chars in str2, and if it manages to remove all of them, the strings were permutations of eachother
		// Since we previously assured they were the same length.

		for (int i=0; i < stringLength; i ++) {
			Character currentChar = str2.charAt(i);
			// decrement if it exists in the hashMap, if not, return false
			if(characterCountMap.containsKey(currentChar)) {
				Integer currentValue = characterCountMap.get(currentChar);
				
				if (currentValue <= 0) {
					return false;
				} else {
					// Decrement lettercount by 1
					characterCountMap.put(currentChar, currentValue - 1);
				}
			} else {
				// if doesnt exist, it was not a permutation
				return false;
			}
		}
		return true;
	}
}




