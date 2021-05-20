//written by Damien King
//takes in a text file places each of the words into a hashtable
//the amount of times each word appears is kept track of in addition to the total amount of words in the book
//will print out the words and their counts unsorted
//then sorts them and prints them out sorted

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args){
        //creates a new file based off of the name given in the command line
        try {
            File file = new File(args[0]);
            Scanner f = new Scanner(file);
            f.useDelimiter("[^a-zA-Z']");
            HashTable<String,Integer> ht = new HashTable<String,Integer>(50021);
            int wordCount = 0;

            //iterates through text file and adds the words into hashtable
            while(f.hasNext()){
                wordCount++;
                String temp = f.next();
                boolean aCheck = false;
                if(temp.length() == 1 && temp.charAt(0) == 39 ) {
                    aCheck = true;
                }
                if(temp.length() != 0 &&  !aCheck){
                    temp = temp.toLowerCase();
                    if(ht.get(temp) == null)
                        ht.put(temp,1);
                    else{
                        int count = ht.get(temp);
                        ht.put(temp,count+1);
                    }
                }
            }
            Iterator<String> hit = ht.iterator();

            //creates an iterator and proceeds to print out unsorted words and their counts
            while(hit.hasNext()){
                String temp = hit.next();
                int tInt = ht.get(temp);
                System.out.println(temp + "   " + tInt);
            }

            Iterator<String> hit2 = ht.iterator();
            int wcount = 0;
            while(hit2.hasNext()){
                wcount++;
                hit2.next();
            }

            //prints out total words in the book and total number of distinct words
            System.out.println(" Total Word Count: " + wordCount);
            System.out.println(" Distinct Word Count: " + wcount);




            System.out.println("Sorted List:");


            Iterator<String> hit3 = ht.iterator();


            //places words from iterator into a new array to pass into sort
            String[] sa = new String[wcount];
            int i = 0;
            while(hit3.hasNext()){
                sa[i] = hit3.next();
                i++;
            }

            //sorts array of words
            AlphabeticalSort bs = new AlphabeticalSort();
            bs.sort(sa);

            //prints out words in sorted order in addtion to their count
            for (int p = 0; p < sa.length; p++)
                System.out.println(sa[p]+ "   " + ht.get(sa[p]));

            //prints out total words in the book and total number of distinct words
            System.out.println(" Total Word Count: " + wordCount);
            System.out.println(" Distinct Word Count: " + wcount);
        }

        //if the file entered on the command line is not found will return this exception
        catch(FileNotFoundException e){
            System.out.println("File not found! Please input a valid file.");
        }
    }
}
