import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args){
        try {
            File file = new File(args[0]);
            Scanner f = new Scanner(file);
            f.useDelimiter("[^a-zA-Z']");
            HashTable<String,Integer> ht = new HashTable<String,Integer>(50021);
            int wordCount = 0;

            //make sure you decapitalize
            //and dont count words that are just apostraphes
            //and dont count strings of length 0

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

            while(hit.hasNext()){
                String temp = hit.next();
                int tInt = ht.get(temp);
                System.out.println(temp + "   " + tInt);
            }
            System.out.println("Word Count: " + wordCount);



            System.out.println("Sorted List:");

            String [] a = new String[3];
            a[0] = "zach";
            a[1] = "pog";
            a[2] = "damien";


            AlphabeticalRadixSort rs = new AlphabeticalRadixSort();
            rs.sort(a)
            rs.sort(hit);

        }

        catch(FileNotFoundException e){
            System.out.println("File not found! Please input a valid file.");
        }
    }
}
