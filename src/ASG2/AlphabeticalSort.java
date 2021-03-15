//Written by Damien King
//Sorts a string array alphabetically using a bubble sort
public class AlphabeticalSort {
    public void sort(String word[]) {
        
        for (int i = 0; i < word.length - 1; i++) {
            for (int a = 0; a < word.length - 1 - i; a++) {
                
                //grabs the lengths of the words about to be sorted
                int lengthLeft = word[a].length();
                int lengthRight = word[a + 1].length();
                //keeps track of minimum length word between the two about to be sorted
                int minLength = Math.min(lengthLeft, lengthRight);
                
                for (int b = 0; b < minLength; b++) {
                    
                    int leftLetter = word[a].charAt(b);
                    int rightLetter = word[a + 1].charAt(b);
                    
                    //compares words letter by letter if left letter is greater it will swap the words
                    if (leftLetter > rightLetter) {
                        String temp = word[a];
                        word[a] = word[a + 1];
                        word[a + 1] = temp;
                        break;
                    }
                    //if letters are the same continue...
                    else if (leftLetter == rightLetter)
                       continue;
                    //if the left letter is not greater than the right letter then they don't need to swap yet
                    else
                        break;
                }
            }
        }
    }
}
