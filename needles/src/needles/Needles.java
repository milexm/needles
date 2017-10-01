package needles;

import java.util.HashMap;
import java.util.Map;
/**
 * Contains the methods to search for the specified words (needles) contained in a string (haystack).
 * Displays the results accordingly.
 * Note. The class contains 3 methods: a "standard" one which uses the suggested approach; a first improved method
 * which moves the split operation outside the loop to improve execution speed; a second improved performance method 
 * which uses a hash map to improve execution speed.   
 * @author Gary
 */
public class Needles {
	
	/**
	 * Searches for words in the passed string.
	 * The function first checks whether the size of needles is greater than 5. 
	 * If it is, it prints an "error" and subsequently exits. If not, it splits the haystack 
	 * string over a number of characters (including single and double quotes, tabs, newlines, word boundaries, 
	 * form feeds and carriage returns) into an array of words called words.
	 * Each "needle" (element of the needles array) is compared to each element of the words array and if 
	 * a "needle" is encountered as an element of the words array, a "counter" for the respective needle is incremented.
	 * After the search, each needle is displayed along with the number of times it occurred in the haystack.
	 * @param haystack - The string to be searched.
	 * @param needles  - The array containing the words to search. 
	 */
	public static void findNeedles(String haystack, String[] needles){
		
		if(needles.length > 5){
			System.err.println("Too many words!");
		}

		else{
			
			int[] countArray = new int[needles.length];
			for(int i = 0; i < needles.length; i++){
				String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0);
				for(int j = 0; j < words.length; j++){
					if(words[j].compareTo(needles[i]) == 0){
						countArray[i]++;
					}
				}
			}
			for (int j = 0; j < needles.length; j++) {
				System.out.print(String.format("[%s:%d]", needles[j], countArray[j]));
			}
		}	
		
	}

	/**
	 * Searches for words in the passed string.
	 * Note. Moved the split operation outside the loop to improve performance. 
	 * @param haystack - The string to be searched.
	 * @param needles  - The array containing the words to search. 
	 */
	public static void findNeedles2(String haystack, String[] needles){
		
		
		String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0);
		
		if(needles.length > 5){
			System.err.println("Too many words!");
		}

		else{
			int[] countArray = new int[needles.length];
			
			for(int i = 0; i < needles.length; i++){
				for(int j = 0; j < words.length; j++){
					if(words[j].compareTo(needles[i]) == 0){
						countArray[i]++;
					}
				}
			}
			for (int j = 0; j < needles.length; j++) {
				System.out.print(String.format("[%s:%d]", needles[j], countArray[j]));
			}
		}
		
	}
	
	
	/**
	 * Searches for words in the passed string.
	 * Note. Improve performance by splitting the haystack string into words and creating 
	 * a hash map. It is a lot faster to access map than to iterate through an array of strings.
	 * @param haystack - The string to be searched.
	 * @param needles  - The array containing the words to search. 
	 */
	public static void findNeedles3(String haystack, String[] needles)  {
		
		// Hold all unique words in a hash map. 
		// Keep a count of each occurrence of the needle in the haystack.
		Map<String, Integer> needlesCount = new HashMap<String, Integer>();
		
		// Check if there are too many words
		if (needles.length > 5) {
			System.err.println("Too Many words");
		}
		
		/* Split the haystack string into words and create a hash map. 
		 * It is a lot faster to access map than to iterate through an array of strings.
		 */
		String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0);
		for (String word: words) {
			Integer count = needlesCount.get(word);
			
			// Set the initial value to 1
			if (count == null) {
				needlesCount.put(word, 1);
			// Found an occurrence, increment its value
			} else {
				count++;
				needlesCount.put(word, count);
			}
		}
		
		// Iterate over needle and fetch its value if the word exists in the haystack hash map. 
		for (String needle: needles) {
			System.out.print(String.format("[%s:%d]", needle, needlesCount.get(needle)));
		}
		
	}

}
