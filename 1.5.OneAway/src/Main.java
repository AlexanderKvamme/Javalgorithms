import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		System.out.printf("\n result: %s", isOneAwayFrom("alf", "arf"));
		System.out.printf("\n result: %s", isOneAwayFrom("pale", "ple"));
		System.out.printf("\n result: %s", isOneAwayFrom("pale", "pales"));
		System.out.printf("\n result: %s", isOneAwayFrom("pale", "bale"));
		System.out.printf("\n result: %s", isOneAwayFrom("pale", "bake"));
	}
	
	public static boolean isOneAwayFrom(String firstString, String secondString) {
		
		int lengthDiff = firstString.length() - secondString.length();
		
		// Make sure length is appropriate
		if (Math.abs(lengthDiff) > 1) {
			System.out.println("length provided greater absolute value > 1");
			return false;
		}
		
		// Make map
		HashMap<Character, Integer> map = new HashMap<>(); // <Object, Object>
		
		// put chars form firstString in it
		for (Character c : firstString.toCharArray()) {
			injectCharIntoMap(c, map);
		}
		
		for (Character c : secondString.toCharArray()) {
			extractCharFromMap(c, map);
		}
		
		int totalOffsets = 0;
		for (Character c : map.keySet()) {
			System.out.printf("\n %s = %s", c, map.get(c));
			totalOffsets += Math.abs(map.get(c));
		}
		
		// 1: Could add one, or remove one to make equal
		// 2: could replace one
		return map.size() <= 2;	
	}
	
	// Helper methods
	
	static void injectCharIntoMap(Character c, HashMap<Character, Integer> map) {
		// If exists, increment, if not, make and set to 1
		if (map.containsKey(c)) {
			map.put(c, map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
	}
	
	static void extractCharFromMap(Character c, HashMap<Character, Integer> map) {
		// if character exists, decrement, if it doesnt, put value of -1
		if (map.containsKey(c)) {
			if (map.get(c) == 1) {
				// Leave only values that are not 0. The ones that are 0 are balanced out and this lets you later
				// Count the mismatches. Count keys left (mismatches) should be == 1
				map.remove(c);
			} else {
				map.put(c, map.get(c) - 1);
			}
		} else {
			map.put(c, -1);
		}
	}
}
