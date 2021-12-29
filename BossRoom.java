/* JC Abanto (Object-Oriented Programming)
 * 
 * The BossRoom.java class (this class), is a subclass of Room.java.
 * This subclass carries the responsibility for the Boss Room in the game.
 * 
 * I've included alternate endings depending on how much of the map the user 
 * has explored and their decision making (hence, the lengthy if statement). 
 * That is probably one of my favourite parts about this assignment. Adding dialogue
 * and a theme to my game brought more meaning to the assignment itself.
 * 
 */

import java.lang.Math; // Imports the math class for the diceRoll method.
import java.util.Scanner; // Imports the scanner class.

public class BossRoom extends Room { // BossRoom is a subclass of Room
	
	 // Executes the constructor method from Room.java where the subclass inherits the same parameters for the room.
	public BossRoom(boolean n, boolean e, boolean s, boolean w, boolean st, boolean egg) { 
		super(n, e, s, w, st, egg);
	}
	public void drawRoom(Scanner theScanner) { // Overrides the drawRoom method from the Room class for the Boss Room and is found in the Room[][] as BossRoom.
		lost = false; // This ensures that there's no way out and that you can't make attempts to escape during the boss room scene.
		// This prints out the boss room and the user meets the boss.
		System.out.println(
				"\nThe Boss Room" + "\n              ____________________" + "\n/////////////|                    |"
						+ "\n/////////////|   o                |" + "\n/////////////|        ____________|"
						+ "\n/////////////|       |/////////////" + "\n/////////////|   x   |/////////////"
						+ "\n/////////////|       |/////////////" + "\n/////////////|_______|/////////////"
						+ "\n\nDirector X: I've been waiting for you. (Press enter to respond.)");
		theScanner.nextLine(); // Forces the user to press enter so they can read the dialogue at their own pace and adds an interactive feel.
		// The user has lines premade and the boss answers the questions.
		System.out.println("You: Who are you, why am I here, and can you let me out?"
				+ "\n\nDirector X: You can call me X. I can't tell you exactly why you're here but I can let you out under one condition. (Press enter to respond.)");
		theScanner.nextLine(); // Forces the user to press enter so they can read the dialogue at their own pace and adds an interactive feel.
		// The user has to recall what note they saw (if they saw one) as that's their only way out.
		System.out.println("You: What's the condition?"
				+ "\n\nDirection X: There was a note hidden in my dungeon. Can you tell me what it said? (Type in 'Y' if you know, and 'N' or anything else if you don't know.)");
		String answer = theScanner.nextLine(); // This part is interactive as it asks the user whether they saw a note or not.
		if (answer.equalsIgnoreCase("Y")) { // This is our first if statement of many. If the user says yes, the boss asks what it said.
			System.out.println("Director X: Great! What did the note EXACTLY say? (Include appropriate punctuation.)");
			// The note from the main floor is stored in a variable called note.
			String note = "Password.";
			answer = theScanner.nextLine(); // The user's next response is stored in the answer variable.
			if (answer.equals(note)) { // This checks if the answer they replied with is the same as the note from the main floor.
				System.out.println("Director X: Oh, you actually found it! Also, I didn't get your name. (Enter your name.)"); // The boss is happy to see you found the note.
				String userName = theScanner.nextLine(); // Here, the user inputs their own name.
				System.out.println(userName + ". That's a lovely name. Great work " + userName + "!" // The boss congratulates you personally and it draws the escape route.
						+ "\n              ____________________" + "\n/////////////|                    |"
						+ "\n/////////////|                    |" + "\n/////////////|        ____________|"
						+ "\n/////////////|       |/////////////" + "\n/////////////| x     |/////////////"
						+ "\n/////////////|       |/////////////" + "\n/////////////|__   __|/////////////"
						+ "\n/////////////    o    /////////////" + "\n\nYou have escaped!");
			}
			else if (answer.equals("Bababooey.")) { // This checks if the answer they replied with is the same as the note from the basement which is an easter egg I included.
				System.out.println("Director X: Do you think this is some joke? (Press enter to respond.)"); // The boss thinks that the user is playing games with him.
				theScanner.nextLine(); // Forces the user to press enter so they can read the dialogue at their own pace and adds an interactive feel.
				// The user replies with honesty and the boss offers to tell you why the user is here.
				System.out.println("You: No, not at all. I found some note that said \"Bababooey.\" and I thought that was the note you were referring to."
						+ "\n\nDirector X: My previous prisoner must've put that there. Now that you brought that up, would you like to know why you're here? (Type in 'Y' for yes, and 'N' or anything else for no.)");
				answer = theScanner.nextLine(); // This part is interactive as it asks the user whether they would like to know why they're here or not.
				if (answer.equalsIgnoreCase("Y")) { // This checks if the answer they reply with was yes.
					// The boss becomes to be transparent with the user for character development.
					System.out.println("Director X: My name isn't actually Director X, it's actually Carl and I have no family. That's why I kidnapped you. (Press enter to respond.)");
					theScanner.nextLine(); // Forces the user to press enter so they can read the dialogue at their own pace and adds an interactive feel.
					// The user then empathizes with the boss and asks about the previous prisoner. The boss answers with his efforts in trying to keep him.
					System.out.println("You: I'm sorry to hear that. Didn't you also mention that you had a previous prisoner?"
							+ "\n\nCarl: Yeah, he stayed for a bit. I tried to make him feel comfortable by giving him something to draw on, hence the note you found "
							+ "but he has a family of his own so I had to release him. (Press enter to respond.)");
					theScanner.nextLine(); // Forces the user to press enter so they can read the dialogue at their own pace and adds an interactive feel.
					// The user offers to stay with the boss with a condition.
					System.out.println("You: I could stay for a bit if you would like. As long as you could let me out in a couple of hours."
							+ "\n\nCarl: Really? You'd do that for me? (Type in 'Y' for yes, and 'N' or anything else for no.)");
					answer = theScanner.nextLine(); // The user has a chance to take back what he said or continue with it.
					if (answer.equalsIgnoreCase("Y")) { // This checks if the user decided to stay with the boss for a couple hours.
						// The game rewards the user by informing them that they have beaten the game as well as updates the user with Carl's life.
						System.out.println("Because you decided to stay with Carl, his life has changed thanks to you. You have successfully beaten the game.");
					}
					// This checks if the user replies with anything but yes on whether they know what the note(s) said.
					else if (answer != "Y") {
						incorrectAnswerDialogue(theScanner); // This calls the incorrectAnswerDialogue method.
					}
				}
				else if (answer != "Y") { // This checks if the user said anything but yes in knowing why they're kept in the dungeon.
					incorrectAnswerDialogue(theScanner); // This calls the incorrectAnswerDialogue method.
			} else if (answer != note || answer != "Bababooey.") { // This checks if the user replies with anything but the two notes in the dungeon.
				incorrectAnswerDialogue(theScanner); // This calls the incorrectAnswerDialogue method.
				}
			}
		} else if (answer != "Y") { // This checks if the user said no to staying with the boss for a couple hours.
			incorrectAnswerDialogue(theScanner); // This calls the incorrectAnswerDialogue method.
		}
	}

	public void incorrectAnswerDialogue(Scanner theScanner) { // This method sets up for the fight scene.
		// The boss informs the user that they aren't intelligent and that they must fight.
		System.out.println("Director X: You really aren't that bright, are you? I guess we gotta fight now. (Press enter to respond.)");
		theScanner.nextLine(); // Forces the user to press enter so they can read the dialogue at their own pace and adds an interactive feel.
		// The user remembers that this is a coding assignment and fights are not school appropriate. The boss is aware of it and has another idea. A dice roll off.
		System.out.println("You: What? Fight?! That's not school appropriate."
				+ "\n\nDirector X: Yes, yes, I know. Which is why we're about to roll dice. We each get one roll and if you roll higher than me, you win this so called \"fight\" and you can escape freely. (Press enter to respond.)");
		theScanner.nextLine(); // Forces the user to press enter so they can read the dialogue at their own pace and adds an interactive feel.
		// Rules are clarified when the user asks if they roll the same number. If they're rolls are equal to another, the boss wins. 
		System.out.println("You: Wait! What if we roll the same number or what if I lose?"
				+ "\n\nDirector X: If we roll the same number, I still win. House rules, boohoo. And if you lose, you're staying with me forever. Ready?"
				+ "\n(Press enter to roll the dice.)");
		theScanner.nextLine(); // The game asks you to roll the dice by pressing enter.
		diceRoll(theScanner); // Calls the diceRoll method.
	}

	public void diceRoll(Scanner theScanner) { // This method holds all dice roll scene dialogue and dice roll number generating.

		int max = 6; // This is the highest number you can roll.
		int min = 1; // This is the lowest number you can roll.
		int range = max - min + 1; // This includes 6 in the range.
		int[] integers = new int[2]; // This creates an array size of 2.

		for (int i = 0; i < integers.length; i++) { // This is a for loop the size of the integers array.
			integers[i] = (int) (Math.random() * range) + min; // This randomly generates two different numbers.
		}
		// This prints out what the user rolled and what the boss rolled.
		System.out.println("You rolled a " + integers[0] + "!" + "\n\nDirector X rolled a " + integers[1] + "!");

		if (integers[0] > integers[1]) { // This checks if the user won
			// The boss is respectful and asks for the user's name.
			System.out.println("\nDirector X: Nice roll. I didn't get your name. (Enter your name.)");
			String userName = theScanner.nextLine(); // Allows the user to input their name.
			System.out.println("Director X: Well played " + userName + ". Well played."); // The boss congratulates the user personally.
			// The escape route is drawn.
			System.out.println("              ____________________" + "\n/////////////|                    |"
					+ "\n/////////////|                    |" + "\n/////////////|        ____________|"
					+ "\n/////////////|       |/////////////" + "\n/////////////| x     |/////////////"
					+ "\n/////////////|       |/////////////" + "\n/////////////|__   __|/////////////"
					+ "\n/////////////    o    /////////////" + "\n\nYou have escaped!");
		} else { // Checks if the integers did anything but satisfy the winning conditions.
			// The boss is rude and you are told you didn't escape and the game is over.
			System.out.println("\nDirector X: Sucks to suck." + "\n\nYou have failed to escape.");
		}
	}
}
