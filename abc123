import java.util.Scanner;
import java.util.Random;
public class GuessingGame
{
   public static void main (String [] args)
   {


  //Variables
  Random randomNumber = new Random();
  Scanner kbd = new Scanner(System.in);
  int computerValue = randomNumber.nextInt(100);
  int numberOfTries = 0;
  int success = 0;
  int guess = 0;


  //Logic and While Loop



   while (success ==0)
     {
        System.out.println("please enter an integer betwen 1 and 100 inclusive: ");
        guess = kbd.nextInt();
        numberOfTries++;

           if (guess < 1 || guess > 100){
              System.out.println("Invalid input");
           }

           else if (guess == computerValue){
              success++;
              System.out.println("Congratulations you won! Your numbers of tries was: " + numberOfTries + " and the number was: " + computerValue);

           }
           else if (guess < computerValue){
              System.out.println("Your guess is too low!");
           }
           else if (guess > computerValue){
              System.out.println("Your guess is too high!");
    }
    }



   }
}