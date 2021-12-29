/* JC Abanto (Object-Oriented Programming)
 * 
 * The Room.java class (this class), holds the characteristics of every room in the game.
 * Big features found in this class are the drawRoom object method and the moveRoom object method
 * which draws the rooms and moves the user from room to room. 
 * 
 * Something I thought was clever when building the game engine was using xPositions and yPositions
 * to manipulate what room to draw in the 2D array. What this does is, it actually makes the user move
 * room to room instead of drawing a room on top another room if that makes sense.
 * 
 */

import java.util.Scanner; // Imports the scanner class.

public class Room {
	// I couldn't put the xPosition and yPosition back in the main class and you said it was okay if I couldn't.
	// I believe it can't be done because the moveRooms method is in this class. I would need to move it over to Main.java to move the variables there too.
	// I probably could but I feel like the moveRooms method is most appropriate in the Room class because I organized this class to contain anything and
	// everything that dealt with the characteristics of the rooms. It also helps because the booleans of every exit are here and that's what my if statements
	// rely on when moving from room to room.
	protected static int xPosition = 1; // This integer controls the x position behaviour of the user. Its current value is set to the starting xPosition.
	protected static int yPosition = 0; // This integer controls the y position behaviour of the user. Its current value is set to the starting yPosition.
	protected static boolean lost = true; // A lost boolean is created which allows a while loop.
	private boolean northExit; // This boolean has the responsibility for checking for a north exit.
	private boolean eastExit; // This boolean has the responsibility for checking for an east exit.
	private boolean southExit; // This boolean has the responsibility for checking for a south exit.
	private boolean westExit; // This boolean has the responsibility for checking for a west exit.
	private boolean stairExit; // This boolean has the responsibility for checking for stairs.
	private boolean easterEgg; 
	
	public boolean getEasterEgg() { // Here is a forced example of a getter method which allows the private boolean easterEgg to be accessed.
		return this.easterEgg; // Here is the return method that is practically mandatory for every getter.
	}
	public void setEasterEgg(boolean egg) { // Here is a forced example of a setter method which allows the boolean to be modified.
		this.easterEgg = egg; // Here, the easterEgg is set to be equal to the parameter, "egg."
	}
	
	// This is my constructor method that models what each room parameters will look like.
	public Room(boolean n, boolean e, boolean s, boolean w, boolean st, boolean egg) {
		this.northExit = n;
		this.eastExit = e;
		this.southExit = s;
		this.westExit = w;
		this.stairExit = st;
		this.easterEgg = egg;
	}
	// This object method is responsible for drawing each room.
	// The character is marked with the symbol "o" and possible directions are marked with ^, >, v, <.
	// The list of if statements hold certain conditions for every room. In the main class where the 2D array is created, that's where each room is assigned its conditions.
	public void drawRoom(Scanner theScanner) {
		if (!this.northExit && this.eastExit && this.southExit && this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'E', 'S', or 'W' to move in that direction."
					+ "\n\n___________________________________"
					+ "\n\n <               o               > "
					+ "\n_____________         _____________"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   v   |/////////////"
					+ "\n/////////////|       |/////////////");
		}
		else if (this.northExit && this.eastExit && this.southExit && this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'N', 'E', 'S', or 'W' to move in that direction."
					+ "\n\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n_____________|       |_____________"
					+ "\n\n <               o               > "
					+ "\n_____________         _____________"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   v   |/////////////"
					+ "\n/////////////|       |/////////////");
		}
		else if (!this.northExit && this.eastExit && this.southExit && !this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'E' or 'S' to move in that direction."
					+ "\n             ______________________"
					+ "\n/////////////|"
					+ "\n/////////////|   o               > "
					+ "\n/////////////|        _____________"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   v   |/////////////"
					+ "\n/////////////|       |/////////////");
		}
		else if (this.northExit && this.eastExit && this.southExit && !this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'N', 'E', or 'S' to move in that direction."
			+ "\n\n/////////////|       |/////////////"
			+ "\n/////////////|   ^   |/////////////"
			+ "\n/////////////|       |/////////////"
			+ "\n/////////////|       |_____________"
			+ "\n/////////////|"
			+ "\n/////////////|   o               > "
			+ "\n/////////////|        _____________"
			+ "\n/////////////|       |/////////////"
			+ "\n/////////////|       |/////////////"
			+ "\n/////////////|   v   |/////////////"
			+ "\n/////////////|       |/////////////");
		}
		else if (this.northExit && this.eastExit && !this.southExit && !this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nThere's a note in the room! Type in 'E' to read the note and 'N' to exit room."
					+ "\n\n/////////////|       |/////////////"
					+ "\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |_____________"
					+ "\n/////////////|                 __  |"
					+ "\n/////////////|   o         >  |--| |"
			        + "\n/////////////|                |__| |"
					+ "\n/////////////|_____________________|");
		}
		else if (this.northExit && this.eastExit && !this.southExit && this.westExit && !this.stairExit && !easterEgg ) {
			System.out.println("\nType in 'N', 'E', or 'W' to move in that direction."
					+ "\n\n/////////////|       |/////////////"
					+ "\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n_____________|       |_____________"
					+ "\n\n <               o               > "
					+ "\n___________________________________");
		}
		else if (!this.northExit && !this.eastExit && !this.southExit && this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'W' to return to the room.");
			System.out.println("\n/////////////|       |/////////////"
			+ "\n/////////////|   ^   |/////////////"
			+ "\n/////////////|       |/////////////"
			+ "\n/////////////|       |_____________"
			+ "\n/////////////|                 __  |"
			+ "\n/////////////|          <   o |--| |"
	        + "\n/////////////|                |__| |"
			+ "\n/////////////|_____________________|");
	        System.out.println("\n\nThe note reads: \"Mr. P is awesome.\"");
		}
		else if (this.northExit && !this.eastExit && !this.southExit && !this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nA dead end. Type in 'N' to exit room."
					+ "\n\n/////////////|       |/////////////"
					+ "\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   o   |/////////////"
			        + "\n/////////////|       |/////////////"
					+ "\n/////////////|_______|/////////////");
		}
		else if (this.northExit && !this.eastExit && this.southExit && this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'N', 'S', or 'W' to move in that direction."
					+ "\n\n/////////////|       |/////////////"
					+ "\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n_____________|       |/////////////"
					+ "\n                     |/////////////"
					+ "\n <               o   |/////////////"
					+ "\n_____________        |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   v   |/////////////"
					+ "\n/////////////|       |/////////////");
		}
		else if (!this.northExit && !this.eastExit && this.southExit && this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'S' or 'W' to move in that direction."
					+ "\n_____________________"
					+ "\n                     |/////////////"
					+ "\n <               o   |/////////////"
					+ "\n_____________        |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   v   |/////////////"
					+ "\n/////////////|       |/////////////");
		}
		else if (this.northExit && !this.eastExit && !this.southExit && !this.westExit && this.stairExit && !easterEgg) {
			System.out.println("\nYou found stairs! Type in 'S' to go downstairs and 'N' to exit room."
					+ "\n\n/////////////|       |/////////////"
					+ "\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   o   |/////////////"
					+ "\n/////////////|       |/////////////"
			        + "\n/////////////|_  v   |/////////////"
					+ "\n/////////////| |_    |/////////////"
			        + "\n/////////////|   |_  |/////////////"
					+ "\n/////////////|_____|_|/////////////");
		}
		else if (!this.northExit && !this.eastExit && this.southExit && !this.westExit && this.stairExit && !easterEgg) {
			System.out.println("\nType in 'N' to go upstairs and 'S' to exit room."
					+ "\n\n              _______       "
					+ "\n/////////////|    _| |/////////////"
					+ "\n/////////////|  _|   |/////////////"
					+ "\n/////////////|_|     |/////////////"
					+ "\n/////////////|   ^   |/////////////"
			        + "\n/////////////|       |/////////////"
			        + "\n/////////////|   o   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   v   |/////////////"
					+ "\n/////////////|       |/////////////");
		}
		else if (!this.northExit && this.eastExit && !this.southExit && this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nA tunnel! This is promising. Type in 'E' or 'W' to move in that direction."
					+ "\n  _________________________________"
					+ "\n             "
					+ "\n    <             o             > "
					+ "\n  _________________________________");
		}
		else if (!this.northExit && this.eastExit && !this.southExit && !this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nA dead end. Type in 'E' to exit room."
					+ "\n              _____________________"
					+ "\n/////////////|"
					+ "\n/////////////|   o               > "
					+ "\n/////////////|_____________________");
		}
		else if (this.northExit && !this.eastExit && !this.southExit && this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nType in 'N' or 'W' to move in that direction."
					+ "\n\n/////////////|       |/////////////"
					+ "\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n_____________|       |/////////////"
					+ "\n                     |/////////////"
					+ "\n <               o   |/////////////"
					+ "\n_____________________|/////////////");
		}
		else if (!this.northExit && !this.eastExit && this.southExit && !this.westExit && !this.stairExit && !easterEgg) {
			System.out.println("\nThe Boss Room"
					+ "\n              ____________________"
					+ "\n/////////////|                    |"
					+ "\n/////////////|                    |"
					+ "\n/////////////|        ____________|"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////| x     |/////////////"
					+ "\n/////////////|__   __|/////////////"
					+ "\n/////////////    o    /////////////");
		}
		else if (!this.northExit && this.eastExit && this.southExit && !this.westExit && !this.stairExit && easterEgg) {
			System.out.println("\nThere seems to be something at the end of this hall. Type in 'S' to search the rest of the room and 'E' to exit the room."
					+ "\n             ______________________"
					+ "\n/////////////|"
					+ "\n/////////////|   o               > "
					+ "\n/////////////|        _____________"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   v   |/////////////"
					+ "\n/////////////|       |/////////////");
		}
		else if (this.northExit && !this.eastExit && !this.southExit && !this.westExit && !this.stairExit && easterEgg) {
			System.out.println("Type in 'N' to exit the room."
					+ "\n\n/////////////|       |/////////////"
					+ "\n/////////////|   ^   |/////////////"
					+ "\n/////////////|       |/////////////"
					+ "\n/////////////|   o   |/////////////"
					+ "\n/////////////|   _   |/////////////"
			        + "\n/////////////|  |_|  |/////////////"
					+ "\n/////////////|_______|/////////////"
			        + "\n\nYou found a note! The note reads: \"Bababooey.\"");
		}
	}
	// This object method is responsible for the user's movement
	public void moveRooms(String nextDirection) {
			// If the user inputs "N" and there's an exit north or stairs, it allows the user the move up by subtracting one from the yPosition.
		if (nextDirection.equalsIgnoreCase("N") && (this.northExit || this.stairExit)) {
			yPosition--;
		} // If the user inputs "E" and there's an exit east, it allows the user the move to the right by adding one to the xPosition.
			else if (nextDirection.equalsIgnoreCase("E") && this.eastExit) { 
			xPosition++;
		} // If the user inputs "S" and there's an exit south or stairs, it allows the user the move down by adding one from the yPosition.
			else if (nextDirection.equalsIgnoreCase("S") && (this.southExit || this.stairExit)) {
			yPosition++;
		} // If the user inputs "W" and there's an exit west, it allows the user the move to the left by subtracting one to the xPosition.
			else if (nextDirection.equalsIgnoreCase("W") && this.westExit) {
			xPosition--;
		} // If the user inputs anything other than a valid direction, it tells the user they have responded with an invalid response.
			else {
			System.out.println("\nInvalid response.");
		}
	}
}

