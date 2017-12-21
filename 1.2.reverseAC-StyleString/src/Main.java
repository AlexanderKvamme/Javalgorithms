import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String[] reverseUs = {"bam", "Shazam"};
		
		for(String str : reverseUs) {
			System.out.println(reverse(str));
		}
	}

	static String reverse(String str) {
		
		ArrayList<String> reversedStr = new ArrayList<String>();
		
		for(int i=str.length(); i > 0; i--) {
			System.out.println("would do something");
		}
		
		return "FAIL";
	}
}
