import java.util.Scanner;
public class GuessingGame
{
	public static void main (String [] args)
	{

		/*
		 * Starting text...
		 */

		System.out.println("Choose a number between 1 and 100...");
		System.out.println("Press any letter, then enter when you've chosen one.");

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
			if ( (maxThreshold - minThreshold) % 2 == 1 ) {
				midThreshold = maxThreshold - ((maxThreshold - minThreshold + 1) / 2);
			} else {
				midThreshold = maxThreshold - ((maxThreshold - minThreshold) / 2);
			}
			if (numberOfTries % 2 == 0)
			{
				System.out.println("Is your number greater than or equal to " + midThreshold + "? (press y/n)");
				response = kbd.next().charAt(0);
				if (response == 'y') {
					minThreshold = midThreshold;
				}
				if (response == 'n') {
					maxThreshold = midThreshold - 1;
				}
			} else {
				System.out.println("Is your number less than or equal to " + midThreshold + "? (press y/n)");
				response = kbd.next().charAt(0);
				if (response == 'y') {
					maxThreshold = midThreshold;
				}
				if (response == 'n') {
					minThreshold = midThreshold + 1;
				}
			}

			numberOfTries++;

			/*
			 * Only do stuff below this on the last two guesses
			 * 
			 * Guess the bottom number
			 */

			if (maxThreshold - minThreshold <= 1) {
				System.out.println("Is your number " + minThreshold + "? (press y/n)");
				response = kbd.next().charAt(0);
				if (response == 'y') {
					System.out.println("It took me " + numberOfTries + " guesses");
					System.out.println("gg m8 #rekt");
					kbd.close();
					System.exit(0);
				} else {
					numberOfTries++;
					System.out.println("Is your number " + maxThreshold + "? (press y/n)");
					response = kbd.next().charAt(0);
					if (response == 'y') {
						System.out.println("It took me " + numberOfTries + " guesses");
						System.out.println("gg m8 #rekt");
						kbd.close();
						System.exit(0);
					}
					if (response == 'n') {
						System.out.println("You're such a liar!");
						kbd.close();
						System.exit(0);
					}
				}
			}
		}
	}
}