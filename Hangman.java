/*
 * Project 1
 * Hangman.java
 * Team: Valerie Quintana, Aditi Pathak, Cheryl Litwinczuk, 
 *       Claudio Sousa, Don Hwan Kim, Yan Ling
 */

package hangman;
// Input scanner to take in all the text the user types
import java.util.Scanner;

// This is the main class where all events will be processed
public class Hangman
{
  public static void main(String[] args)
  {
// This is where our game will start
    Scanner guess = new Scanner(System.in);
// This displays "Hello, and welcome to Hangman!" on screen.
    System.out.println("Hello, and welcome to Hangman!");
    System.out.println("Press 1 to Play!");
// If user presses 1, it will create a Play object called obj and tell it to start 
    int yes = guess.nextInt(); 
    if(yes==1)
    {
      Play obj = new Play();
        obj.Start(yes);
    }
  }
}
