/* JC Abanto (Object-Oriented Programming)
 * 
 * With this project, we were instructed to create a text based game engine
 * that uses the principles of object-oriented programming.
 * 
 * The Main.java class (this class), features the gameStarts static method 
 * which is responsible for most of the game's functions when called upon.
 * 
 * I used a 2D array for this project instead of the 1D array because when
 * mapping out the code, having a grid-system made more sense to me than
 * having a linear-system to illustrate the rooms so I taught myself how to
 * use 2D arrays. I added another neat thing to my arsenal.
 * 
 */

import java.io.FileNotFoundException; // Imports the FileNotFoundException class.
import java.util.Scanner; // Imports the scanner class.

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner theScanner = new Scanner(System.in); // Initializes the scanner.
		Title.drawSplashPage(); // Calls the drawSplashPage method from the Title class.
		theScanner.nextLine(); // Expects the user to press enter to play the game.
		
		gameStarts(theScanner); // Calls the gameStarts method found main.
	}
		
	public static void gameStarts(Scanner theScanner) {
		// A 2D array that holds the different rooms with their array number (coordinates) commented out.
		Room[][] rooms = { { new Room(false, true, true, false, false, false) /*[0][0]*/, new Room(true, true, true, false, false, false) /*[0][1]*/, new Room(true, true, false, false, false, false) /*[0][2]*/, 
				new BossRoom(false, false, false, false, false, false) /*[0][3] (Boss Room)*/, new Room(false, true, true, false, false, true) /*[0][4]*/, new Room(true, false, false, false, false, true) /*[0][5]*/ },
				{ new Room(false, true, true, true, false, false) /*[1][0] (Starting Room)*/, new Room(true, true, false, true, false, false) /*[1][1]*/, new Room(false, false, false, true, false, false) /*[1][2]*/,
				new Room(false, true, false, true, false, false) /*[1][3]*/, new Room(false, true, false, true, false, false) /*[1][4]*/, new Room(false, true, false, false, false, false) /*[1][5]*/},  
				{ new Room(false, true, true, true, false, false) /*[2][0]*/, new Room(true, true, true, true, false, false) /*[2][1]*/, new Room(true, false, false, false, false, false) /*[2][2]*/,
				new Room(false, false, true, true, false, false) /*[2][3]*/, new Room(true, true, false, true, false, false) /*[2][4]*/, new Room(false, true, false, true, false, false) /*[2][5]*/},
				{ new Room(false, false, true, true, false, false) /*[3][0]*/, new Room(true, false, true, true, false, false) /*[3][1]*/, new Room(true, false, false, false, true, false) /*[3[[2]*/,
				new Room(false, false, true, false, true, false) /*[3][3]*/, new Room(true, false, true, true, false, false) /*[3][4]*/, new Room(true, false, false, true, false, false) /*[3][5]*/ } };
		rooms[1][0].drawRoom(theScanner); // Draws the starting room.
		
		while (Room.lost) {
			// While the user is lost, the console will continuously ask the user for another direction while calling the drawRoom and moveRooms method found in the Room class.
			String nextDirection = theScanner.nextLine();
			rooms[Room.xPosition][Room.yPosition].moveRooms(nextDirection);
			rooms[Room.xPosition][Room.yPosition].drawRoom(theScanner);
		}
	}
}
