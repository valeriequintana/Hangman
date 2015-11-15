/*
 * Project 1
 * Play.java
 */

package hangman;

import java.util.Random;
import java.util.Scanner;
public class Play
{
    public Play()
    {
      
    }
    public void Start(int yes)
    {
      //String of words and hints
      String words[] = new String[26];
      String hints[] = new String[26];
      switch(yes)
      {
        case 1:
          
          words[0] = "cat";
          hints[0] = "Animal";
          words[1] = "dog";
          hints[1] = "Animal";
          words[2] = "book";
          hints[2] = "Reading";
          words[3] = "breakfast";
          hints[3] = "Meals";
          words[4] = "telephone";
          hints[4] = "Communication";
          words[5] = "mixture";
          hints[5] = "Noun";
          words[6] = "music";
          hints[6] = "Form of Expression";
          words[7] = "animal";
          hints[7] = "Think cat, dog, tiger, etc.";
          words[8] = "school";
          hints[8] = "Building";
          words[9] = "plant";
          hints[9] = "Think grass, tree, flower, etc.";
          words[10] = "pen";
          hints[10] = "Office tool.";
          words[11] = "pencil";
          hints[11] = "Office tool.";
          words[12] = "paper";
          hints[12] = "Office tool.";
          words[13] = "note";
          hints[13] = "You can pass it around.";
          words[14] = "fog";
          hints[14] = "Form of percipitation.";
          words[15] = "smoke";
          hints[15] = "Comes from fire.";
          words[16] = "bake";
          hints[16] = "Cooking.";
          words[17] = "alone";
          hints[17] = "Without Others.";
          words[18] = "drive";
          hints[18] = "Car.";
          words[19] = "town";
          hints[19] = "Form of community.";
          words[20] = "city";
          hints[20] = "Form of community.";
          words[21] = "sunny";
          hints[21] = "Sunlight.";
          words[22] = "shine";
          hints[22] = "Glisten.";
          words[23] = "polish";
          hints[23] = "Clean.";
          words[24] = "cap";
          hints[24] = "Head.";
          words[25] = "hat";
          hints[25] = "Head.";
      }
      //Create blanks
      String word;
      Random rand = new Random();
      int w1 = rand.nextInt(26);
      word = words[w1];
      String hint = hints[w1];
      String guess = "";
      int wl = word.length()+1;
      for(int i=1;i<wl;i++)
      {
        guess += "-";
      }
      //Start the guessing!
      String lu = "";
      int tt = 0;
      boolean canPlay = true;
      Main(guess, tt, canPlay, lu, word, hint);
    }
    public void Main(String guess, int tt, boolean canPlay, String lu, String word, String hint)
    {
      if(tt==6)
      {
       canPlay = false;
       Lose(); 
      }else{
        /*
          Put man here
          --
          o |
         /|\|
         / \|
         _____
        */
        String man[] = new String[7];
        man[0] = " --\n   |\n   |\n   |\n_____\n";
        man[1] = " --\n o |\n   |\n   |\n_____\n";
        man[2] = " --\n o |\n/  |\n   |\n_____\n";
        man[3] = " --\n o |\n/| |\n   |\n_____\n";
        man[4] = " --\n o |\n/|\\|\n   |\n_____\n";
        man[5] = " --\n o |\n/|\\|\n/  |\n_____\n";
        man[6] = " --\n o |\n/|\\|\n/ \\|\n_____\n";
        char g1[] = guess.toCharArray();
        char w2[] = word.toCharArray();
        System.out.println(man[0]);
        for(int x=0;x<g1.length;x++)
        {
          System.out.print(g1[x]);
        }
        System.out.println();
        Guess(guess, tt, canPlay, lu, word, g1, w2, man, hint);
       }
    }
    public void Guess(String guess, int tt, boolean canPlay, String lu, String word, char g1[], char w2[], String man[], String hint)
    {
        String tg1 = new String(g1);
        String tg2 = new String(w2);
        if(tg1.equals(tg2))
        {
        Win();
        }else{
        if(tt == 6)
        {
          System.out.println("\n\nYou Lost! The word was: "+word);
          
          Lose();
        }else{
      Scanner input = new Scanner(System.in);
      System.out.print("Guess("+hint+"): ");
      String letter = input.next();
      if(word.contains(letter))
      {
        if(lu.contains(letter))
        {
          tt +=1;
          System.out.println("Wrong!");
        }else{
        int wl = word.length();
        for(int i=0;i<wl;i++)
        {
          char aChar = letter.charAt(0);
          char bChar = w2[i];
          if(bChar==aChar)
          {
            g1[i] = aChar;
          }
        }
       }
      }else{
        tt +=1;
        System.out.println("Wrong!");
        lu += letter;
      }
      System.out.println();
      System.out.println(man[tt]);
      for(int x=0;x<g1.length;x++)
        {
          System.out.print(g1[x]);
        }
        System.out.println("\n\n");
        lu += letter;
        Guess(guess, tt, canPlay, lu, word, g1, w2, man, hint);
        }
      }
    }
    public void Lose()
    {
      Scanner input1 = new Scanner(System.in);
      System.out.print("\nPlay Again?(Y/N): ");
      String pa1 = input1.next();
      if(pa1.contains("y") || pa1.contains("Y"))
      {
          Play obj = new Play();
          obj.Start(1);
    }else{
      }
    }
    public void Win()
    {
    System.out.println("\n\n\\o/\n | \n/ \\");
      System.out.println("You Won!\n");
      Scanner input2 = new Scanner(System.in);
      System.out.print("\nPlay Again?(Y/N): ");
      String pa = input2.next();
      if(pa.contains("y") || pa.contains("Y"))
      {
        Play obj = new Play();
        obj.Start(1);
      }else{
      }
    }
}
