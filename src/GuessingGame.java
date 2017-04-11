import java.util.Scanner;
import java.util.Random;
public class GuessingGame
{
	public static void main (String [] args)
	{

		/*
		 * Starting text...
		 */
		
		System.out.println("Choose a number between 1 and 100...");
		System.out.println("press any 'y', then enter when you've chosen one.");
		
		//Variables
		
		/*
		 * Random Number Generator not needed...
		 * Random randomNumber = new Random();
		 * int computerValue = randomNumber.nextInt(100);
		 * 
		 * Success variable not needed, as we'll just exit cleanly after correctly guessed...
		 * int success = 0;
		 */
		Scanner kbd = new Scanner(System.in);
		int numberOfTries = 0;
		
		/*
		 * Renamed "guess" to "response" 
		 * 
		 * Added "minThreshold" and "maxThreshold" variables
		 * 
		 * Description of "minThreshold" and "maxThreshold":
		 * 		These variables hold the minimum and maximum numbers that the user can choose from
		 * 		This is stored, and will change as the computer narrows the range the user's number could be in
		 */
		
		// Empty input char
		char response = kbd.next().charAt(0);
		
		// Threshold ints
		int minThreshold = 1;
		int maxThreshold = 100;
		int midThreshold = 0;
		
		//Logic and While Loop

		while (true)	// Do this section until program exits
		{
			/*
			 * I don't believe that ints can store decimals, so I apply the modulus (%) to catch odd numbers
			 * This is where the middle value (rounded up) is calculated...
			 */
			if ( (maxThreshold - minThreshold) % 2 == 1 ) {
				// Odd numbers come this way
				midThreshold = maxThreshold - ((maxThreshold - minThreshold + 1) / 2);
			} else {
				// Even numbers come this way...
				midThreshold = maxThreshold - ((maxThreshold - minThreshold) / 2);
			}
			// This if doesn't have to exist, but it looks better if it asks if your number is higher one time, and lower another...
			if (numberOfTries % 2 == 0)		// If "numberOfTries" is even...
			{
				System.out.println("Is your number greater than or equal to " + midThreshold + "? (press y/n)");
				response = kbd.next().charAt(0);
				if (response == 'y') {
					minThreshold = midThreshold;
				}
				if (response == 'n') {
					maxThreshold = midThreshold;
				}
			} else {
				System.out.println("Is your number less than or equal to " + midThreshold + "? (press y/n)");
				response = kbd.next().charAt(0);
				if (response == 'y') {
					maxThreshold = midThreshold;
				}
				if (response == 'n') {
					minThreshold = midThreshold;
				}
			}
			numberOfTries++;
			
			// This chunk runs when it thinks that it knows the answer
			if (maxThreshold - minThreshold == 0) {
				System.out.println("Is your number " + midThreshold + "? (press y/n)");
				response = kbd.next().charAt(0);
				if (response == 'y') {
					System.out.println("It took me " + numberOfTries + " guesses");
					/*
					 * Tell the user good game...
					 * And yes, I did HAVE to use humor somewhere
					 */
					System.out.println("gg m8 #rekt");
					kbd.close();
					System.exit(0);
				}
				if (response == 'n') {
					System.out.println("You're such a liar!");
					kbd.close();
				}
			}
		}
	}
}