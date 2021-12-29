/* JC Abanto (Object-Oriented Programming)
 * 
 * The Title.java class (this class), has the responsibility of printing out the title screen when the drawSplashPage method is called upon. 
 * I managed to get the extension done by storing the title screen in a text file called, "out.txt".
 * I then use a new scanner object that specifically holds the responsibility to read out the text file.
 * 
 */

import java.io.File; // Imports the file class.
import java.io.FileNotFoundException; // Imports the FileNoteFoundException class.
import java.util.Scanner; // Imports the scanner class.

public class Title {
	
	// This static method is responsible for holding the title screen. Once it is called, the title screen gets printed out in the console.
	public static void drawSplashPage() throws FileNotFoundException {
		
		File textFile = new File("out.txt"); // Creates a file object called textFile.
		Scanner fileScanner = new Scanner(textFile); // Creates a new scanner object strictly for reading the textFile.
		while (fileScanner.hasNextLine()) { // Creates a while loop for when there is another line.
			System.out.println(fileScanner.nextLine()); // When there's another line, it'll print out the next line of "out.txt".
		}
		fileScanner.close(); // Closes the fileScanner.
	}
		
}
