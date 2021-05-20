//written by Damien King
//iterates through an array of keys and keeps track of whether or not the array has a next item
import java.util.Iterator;

public class HashTableIterator <E>  implements Iterator <E> {

    E[] a;
    int count = 0;

    HashTableIterator(E[] ar){
        a = ar;
    }

    //checks to see if the count has exceeded the length of the array
    //and returns true or false accordingly
    public boolean hasNext() {
        if(count < a.length)
            return true;
        else
            return false;
    }

    //returns the next item in the array and ups count by one
    public E next() {
        count++;
        return a[count-1];
    }

}
