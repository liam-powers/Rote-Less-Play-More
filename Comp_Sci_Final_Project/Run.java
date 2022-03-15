/* Liam Powers
 * CSA Final Project
 * Run/Main Method Class */

import java.util.*;
import java.io.*;

public class Run extends UserFxns
{
  public static void main(String args[]) throws IOException //neccessary for readTunes() as this method uses file input from scanner
  {
    readTunes();
    toList();
    System.out.println("\nWelcome to Rote Less, Play More! \nOptions: \n0) exit \n1) output list of tunes held in repository \n2) mark a song in repository as learned \n3) list songs you haven't learned yet\n4) list songs you've learned so far \n5) search the library for a specific set of chords");

    int opt = 1;
    while(opt!=0) //keeps letting the user choose a function until they enter 0 to exit
    {
      Scanner kbReader = new Scanner(System.in);
      System.out.println("\nEnter number of desired option: ");
      int userOpt = kbReader.nextInt();
      opt = userOpt;
      
      if (opt == 1)
        showRepository();
      else if (opt == 2)
        learn();
      else if (opt == 3)
        getToLearn();
      else if (opt == 4)
        getLearned();
      else if (opt == 5)
        simTunes(); 
    }
    
    System.out.println("Thanks for using Rote Less, Play More.");
  }
}