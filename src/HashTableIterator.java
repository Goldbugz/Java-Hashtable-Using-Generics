import java.util.Iterator;

public class HashTableIterator <E>  implements Iterator <E> {

    E[] a;
    int count = 0;

    HashTableIterator(E[] ar){
        a = ar;
    }
    public boolean hasNext() {
        //System.out.println(a.length + " entry one: " + a[0] + a[1] +a[2] );
       // System.out.println("The array length is: "+ a.length + " The count is at: " + count);
        if(count < a.length)
            return true;
        else
            return false;


    }

    //change to generic
    public E next() {
        count++;
        return a[count-1];
    }
}
