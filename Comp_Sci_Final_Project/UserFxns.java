/* Liam Powers
 * CSA Final Project
 * UserFxns Class */

import java.util.*;
import java.io.*; //imports required for exception handling of the scanner file object

public abstract class UserFxns
{
  public static String[][] masterList = new String[7][2]; //number of rows MUST match number of songs in standards.txt
  public static void readTunes() throws IOException /*reads the custom CSV standards.txt in specified directory into 2D array masterList
   * automatically ran at beginning of runtime as this is essential for the program to function */
  {
    Scanner standards = new Scanner(new File("C:\\Users\\22powersl\\Desktop\\Comp_Sci_Final_Project\\standards.txt"));
                                              //YOUR directory for standards.txt should go here.
    int songIndx = 0;
    int chordIndx = 0;
    for(int k = 0; standards.hasNext(); k++)
    {
      if((k % 2) == 0) /*if you're on an EVEN numbered line, you must be looking at a SONG in standards.txt, so this goes into
       * the left column (0) of standards and the next index down (songIndx)*/
      {
        masterList[songIndx][0] = standards.nextLine();
        songIndx++;
      }
      else /*if you're on an ODD numbered line, you must be looking at a CHORD PROGRESSION in standards.txt, so this goes into
       * the right column (0) of standards and the next index down (chordIndx)*/
      {
        masterList[chordIndx][1] = standards.nextLine();
        chordIndx++;
      }
    }
    standards.close(); //closes standards.txt, as its information is now all kept in masterList[][]
  }
  
  public static ArrayList<String> notLearned = new ArrayList<String>(500);
  public static ArrayList<String> learned = new ArrayList<String>(500);
  
  public static void toList() /*reads all of the song titles into the notLearned ArrayList. Also runs automatically at runtime since
   * this is essential for the function of keeping track of songs the user has learned */
  {
    for(int i = 0; i < masterList.length; i++)
    {
      notLearned.add(i, masterList[i][0]);
    }
  }
  
  public static void showRepository() //outputs all of the song titles from standards.txt
  {
    for(int i = 0; i < masterList.length; i++)
    {
      System.out.println(masterList[i][0]);
    }
  }
  
  public static void learn() //takes a user-specified song out of the notLearned ArrayList and into the learned ArrayList
  {
    Scanner kbReader = new Scanner(System.in);
    System.out.println("Enter name of tune on list you've learned: ");
    String tune = kbReader.nextLine();
    int ind = notLearned.indexOf(tune);
    if (ind >= 0) /*negative return from indexOf would mean the song isn't in notLearned,
      /*so we can handle incorrect user input in the else*/
    {
      learned.add(tune);
      notLearned.remove(ind);
      System.out.println("Success! Good job!");
    }
    else
      System.out.println("Error: tune not held in list.");
  }
  
  public static void getLearned() //returns songs the user has marked as learned using public static void learn()
  {
    learned.trimToSize(); //our learned ArrayList is currently size 500, so we don't want to print out a bunch of empty lines
    for(int i = 0; i < learned.size(); i++)
    {
      System.out.println(learned.get(i));
    }
  }
  
  public static void getToLearn() //returns songs the user hasn't marked as learned
  {
    notLearned.trimToSize(); //our notLearned ArrayList is currently size 500, so we don't want to print out a bunch of empty lines
    for(int i = 0; i < notLearned.size(); i++)
    {
      System.out.println(notLearned.get(i));
    }
  }
  
  public static void simTunes() /*searches chords of songs, held in second column of masterList,
    and outputs the songs that have the same chords in the same order*/
  {
    Scanner kbReader = new Scanner(System.in);
    System.out.println("Enter chords you're looking for in the format given by README: ");
    String userChords = kbReader.nextLine();
    boolean srchSuccess = false; /*boolean for keeping track of if program finds chords or not, starts as false as it'll become true
     * if even just one song is found with the chords. we use this in our if else on line 109*/
    for(int i = 0; i < masterList.length; i++)
    {
      int indChords = masterList[i][1].indexOf(userChords);
      if(indChords >= 0)
      {
        System.out.println(masterList[i][0]);
        srchSuccess = true;
      }
    }
    
    if (srchSuccess == true)
    {
      System.out.println("Search successful. Go check out these tunes in a resource like The Real Book, iReal Pro, or jazzstudies.us!");
    }
    else
    {
      System.out.println("Sorry, none of the songs in the repository have this sequence of chords!");
    }
  }  
}