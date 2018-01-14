package com.company;


import java.util.concurrent.ExecutionException;
import java.util.Optional;

public class Main {

    /*
    * Method should check rotation and return true if if the word can be 'cut' at an index, and then part1 and part2 will change places,
    * and then equal the other string.
    */

    public static void main(String[] args)  {

        // Expected result: true, true true, false, false, false
        String a = "waterbottle";
        String b = "ottlewaterb";
        String c = "ttlewaterbo";
        String d = "tlewaterbot";
        String e = "Shazam";
        String f = "bottlewazer";
        String g = "bottlesnoxr";

        // Print result
        System.out.printf("\nWas rotation: %b\n", isRotation(a, b));
        System.out.printf("\nWas rotation: %b\n", isRotation(a, c));
        System.out.printf("\nWas rotation: %b\n", isRotation(a, d));
        System.out.printf("\nWas rotation: %b\n", isRotation(a, e));
        System.out.printf("\nWas rotation: %b\n", isRotation(a, f));
        System.out.printf("\nWas rotation: %b\n", isRotation(a, g));
    }

    public static boolean isRotation(String a, String b) {

        // Assert: both strings same length, but unique
        if (b.length() != a.length()) { return false; }
        if (b == a) { return true; }

        String goalString = a; // "waterbottle"
        String initialWrongString = b; // "ttlewaterbo"

        StringBuilder sb = new StringBuilder(initialWrongString);
        StringBuilder wrapped = new Optional<StringBuilder>;
        wrapped = Optional.of(sb);

        initialWrongString = shiftRight(sb,goalString.charAt(0)).toString(); // Rotate once, so that the the rotations will be compared against the initial letter for a.

        while (
                !sb.toString().equals(goalString) && // Så lenge den er ulik målet
                !sb.toString().equals(initialWrongString)) // Så lenge den er ulik den initielle stringen
        {
            try {

                sb = shiftRight(sb, goalString.charAt(0));
            } catch (Exception e) {
                System.out.println("ERROR: Got an error");
                System.out.println("SHOULD RETURN FALSE");
                return false;
            }
        }

        /*
        System.out.println("\nDone looping");
        System.out.printf("bam 1: %s", (sb.toString() != goalString));
        System.out.printf("\nbam 2: %s", (sb.toString() != initialWrongString));
        System.out.printf("\n - sb ended up: %s", sb.toString());
        System.out.printf("\n - goalString: %s", goalString);
        */

        if (sb.toString().equals(goalString)) {
            return true;
        } else {
            return false;
        }
    }

    /// Shifts the stringbuilder right, at the index of the first letter of the selected char
    /// - shifting "abcdefg" at 'e' results in "efgabcd"
    private static StringBuilder shiftRight(StringBuilder sbin, Character c) {

        if (sbin.toString().toString().indexOf(c) < 0) {
            return null;
        }

        // Cache
        StringBuilder temp = new StringBuilder();
        temp.append(sbin.toString());

        // Do the actual shifting
        int lastIndexOfFirstLetter = sbin.toString().lastIndexOf(c);
        String x = sbin.substring(0, lastIndexOfFirstLetter).toString();//subSequence(0, lastIndexOfFirstLetter);
        String y = sbin.substring(lastIndexOfFirstLetter, temp.length()).toString();

        // Update and return the new StringBuilder
        temp = new StringBuilder();
        temp.append(y);
        temp.append(x);

        return temp;
    }
}

