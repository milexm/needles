package needles;

/**
 * Displays user' selection menu and starts user's input processing.
 * Note. This is the application starting point.
 * @author Gary
 *
 */
public class Main {

	/**
	 * Displays user' selection menu and starts user's input processing. 
	 * Note. This is the main function called when the program starts.
	 * @param args Null input argument
	 */
	public static void main(String[] args) {
		
		// Generate "too many words" error.  
		// findNeedles("dummy", needles2);
		// System.out.println("--------------------------------");
	
		// Display the selection menu
		SimpleUI.displayMenu();
		// Process user input
		SimpleUI.processUserInput();
		
	}

}
