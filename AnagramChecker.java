import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Feature 1: Checks if two texts are anagrams of each other. Feature 2: Out of
 * all inputs to feature 1: provides all the anagrams for a given string.
 * 
 * @author artakdev
 * @version 1.0
 *
 */

public class AnagramChecker {
	/**
	 * A collection of user inputs
	 */
	static HashSet<String> userInputs = new HashSet<String>();

	/**
	 * Integer input object
	 */
	static Scanner input = new Scanner(System.in);

	/**
	 * Main method
	 * 
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		// Launch the program
		launcher(input);
	}

	/**
	 * A menu where the user can choose an option.
	 * 
	 * @param input - Keyboard input object
	 */
	private static void launcher(Scanner input) {
		// Menu
		System.out.print("\nFeature 1 (1)\nFeature 2 (2)\nExit (3)\nChoose an option: ");
		String selectOption = input.nextLine();

		// Menu options
		if (selectOption.equals("1")) {
			feature1(input, userInputs);
			launcher(input); // Restart the program
		} else if (selectOption.equals("2")) {
			feature2(input, userInputs);
			launcher(input); // Restart the program
		} else if (selectOption.equals("3")) {
			System.out.println("Bye");

			// Close the scanner instance
			input.close();
		} else {
			System.out.println("You can only choose 1, 2 or 3!");
			launcher(input); // Restart the program
		}

	}

	/**
	 * Checks if two texts are anagrams of each other.
	 * 
	 * @param input      - Keyboard input object
	 * @param userInputs - A collection of user inputs
	 */
	private static void feature1(Scanner input, HashSet<String> userInputs) {
		// Input of two strings
		System.out.print("Enter the first string: ");
		String string1 = input.nextLine().toLowerCase();
		System.out.print("Enter the second string: ");
		String string2 = input.nextLine().toLowerCase();

		// Save both inputs in HashSet
		userInputs.add(string1);
		userInputs.add(string2);

		// If both input strings have different lengths, then return to launcher.
		if (string1.length() != string2.length()) {
			noAnagram(string1, string2);
			return;
		}

		// Convert both input strings to char array
		char[] charArray1 = string1.toCharArray();
		char[] charArray2 = string2.toCharArray();

		// Sort chars of both char arrays
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		// If both char arrays match, then it is an anagram.
		if (Arrays.equals(charArray1, charArray2)) {
			isAnagram(string1, string2);
		} else {
			noAnagram(string1, string2);
		}
	}

	/**
	 * Out of all inputs to {@link feature1(Scanner, HashSet<String>)}: provides all
	 * the anagrams for a given string.
	 * 
	 * @param input      - Keyboard input object
	 * @param userInputs - A collection of user inputs
	 */
	private static void feature2(Scanner input, HashSet<String> userInputs) {
		// String input
		System.out.print("Enter a string: ");
		String string3 = input.nextLine().toLowerCase();

		// Convert input strings to char array
		char[] charArray3 = string3.toCharArray();

		// Sort chars of char array
		Arrays.sort(charArray3);

		// List of matches
		List<String> listMatches = new ArrayList<String>();

		// Iterate the collection of user inputs
		for (String innerString : userInputs) {
			// Convert the string to char array
			char[] innerCharArray = innerString.toCharArray();

			// Sort chars of inner char array
			Arrays.sort(innerCharArray);

			if (Arrays.equals(charArray3, innerCharArray)) {
				// Don't print the current user input even if it exists in the input collection
				if (!string3.equals(innerString))
					// Add the match to the list of anagrams
					listMatches.add(innerString);
			}
		}

		// Print the anagrams
		System.out.println(listMatches);
	}

	/**
	 * Prints that the strings are not anagram.
	 * 
	 * @param string1 - First user input
	 * @param string2 - Second user input
	 */
	private static void noAnagram(String string1, String string2) {
		System.out.println(string1 + " and " + string2 + " are not anagram.");
	}

	/**
	 * Prints that the strings are anagram.
	 * 
	 * @param string1 - First user input
	 * @param string2 - Second user input
	 */
	private static void isAnagram(String string1, String string2) {
		System.out.println(string1 + " and " + string2 + " are anagram.");
	}
}
