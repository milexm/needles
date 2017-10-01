package needles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Displays a selection menu for the user. Processes the  user's input and calls the proper 
 * method based on the user's selection. 
 * @author Gary
 *
 */
public class SimpleUI {
	
	// Instantiate Scanner object to read user's input.
	protected static Scanner _input = new Scanner(System.in);
	
	// List of words to search.
	private static String[] needles = {"summer", "breeze", "children", "parfume", "eve"};
		
	// List (too big) of words to search.
	// private static String[] needles2 = {"summer", "breeze", "children", "parfume", "eve", "corn"}; 
	
	private static long startTime, finishTime, diff;


	// Menu entries.
	private static ArrayList<String> menuEntries = new  ArrayList<String>(
			Arrays.asList(
							"s  -  Standard Implementation", 
							"i1 -  First Improved Implementation", 
							"i2 -  Second Improved Implementation", 
							"m  -  Display menu",
							"x  -  Quit the application"
						)
	);
																					
	// Array of strings to be searched. 
	private static String[] haystack = {
		"Where are you going, summer 'breeze'?", 
		"'children' \r jumping \t parfume \b of blossoms \f eve \n fresh corn",
		"'children' \r jumping \t parfume \b of blossoms \f eve \n fresh \n eve 'breeze'"
	};	
		
	private static String readUserInput() {
		System.out.print(">>");
		String result = String.valueOf(_input.nextLine());
		return result;
	}
	
	 private static String dividerLine(String c, int length)
	 {
	     String divider = "";
	     for(int i = 0; i < length; i++)
	         divider = divider.concat(c);
	
	     return divider;
	 }
	
	 
	 /*
	  * Displays the application menu.
	  * @param menuentries The array containing the menu entries. 
	  */
	 public static void displayMenu() {
		
		 // Display menu header.
		 System.out.println(dividerLine("*", 66));
	
		// Display menu entries.
	 	Iterator<String> i = menuEntries.iterator();
	 	while (i.hasNext()) {
	 		System.out.println(i.next());
	 	}	
	 	
	 	// Display menu footer.
	 	System.out.println(dividerLine("*", 66));
	 }
	 
	 public static void processUserInput() {
		 
		 while (true) {
		
			// Get user input.
			String userSelection = readUserInput().toLowerCase();	
			// Normalize user's input.
			String normalizedUserSelection = userSelection.trim().toLowerCase();
			
	
			try{
				// Exit the application.
				if ("x".equals(normalizedUserSelection)){
					break;
				}
				else
					if ("m".equals(normalizedUserSelection)) {
						// Display menu
						displayMenu();
						continue;
					}
				
			}
			catch (Exception e){
				// System.out.println(e.toString());
				System.out.println(String.format("Input %s is not allowed%n", userSelection));
				continue;
			}
			
			performOperation(normalizedUserSelection);
		
		 }
	 }
		 
	 /*
	  * Execute user's selection.
	  */
	 private static void performOperation(String operation) {
	
		// Select operation to perform.
		switch(operation) 
		{
		
			case "s": {
			
				try{
					
					startTime = System.currentTimeMillis();
					// Search for needles in the haystack. 
					for (int k=0; k < haystack.length; k++){
						Needles.findNeedles(haystack[k], needles);
						System.out.println();
					}
					finishTime = System.currentTimeMillis();
					diff = (finishTime - startTime);
					System.out.println("Used time:" + diff + "ms");
					
				}
				catch (Exception e){
					System.out.println(String.format("%s", e.getMessage()));
				}
				break;
			}
			case "i1": {
				
				try{
					startTime = System.currentTimeMillis();
					// Search for needles in the haystack. 
					for (int k=0; k < haystack.length; k++){
						Needles.findNeedles2(haystack[k], needles);
						System.out.println();
					}
					finishTime = System.currentTimeMillis();
					diff = (finishTime - startTime);
					System.out.println("Used time:" + diff + "ms");
				}
				catch (Exception e){
					System.out.println(String.format("%s", e.getMessage()));
				}
				break;
			}
			case "i2": {
				
				try{
					startTime = System.currentTimeMillis();
					// Search for needles in the haystack. 
					for (int k=0; k < haystack.length; k++){
						Needles.findNeedles3(haystack[k], needles);
						System.out.println();
					}
					finishTime = System.currentTimeMillis();
					diff = (finishTime - startTime);
					System.out.println("Used time:" + diff + "ms");
				}
				catch (Exception e){
					System.out.println(String.format("%s", e.getMessage()));
				}
				break;
			}
			default: {
				System.out.println(String.format("%s is not allowed", operation));
				break;
			}
		}

	}
}
