/*
 * Project 1
 * Hangman.java
 */

package hangman;
import java.util.Scanner;
public class Hangman
{
  public static void main(String[] args)
  {
    Scanner guess = new Scanner(System.in);
    System.out.println("Hello, and welcome to Hangman!");
    System.out.println("Press 1 to Play!");
    int yes = guess.nextInt(); 
    if(yes==1)
    {
      Play obj = new Play();
        obj.Start(yes);
    }
  }
}
