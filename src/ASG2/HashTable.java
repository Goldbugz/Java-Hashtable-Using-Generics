//written by Damien King
//implements a hashtable using generics
//has get and put functions that will retrieve and place data into the table respectively
//also has an iterator function which returns an iterator object containing the keys in the hash table

import java.util.Iterator;


public class HashTable <K,V> implements Table <K,V> {
    K[] ka;
    int size;

    LinkedList<K,V>[] l;

    HashTable(int s){
        size = s;
       l = new LinkedList [size];
       for(int i = 0; i <s; i++){
           l[i] = new LinkedList<K,V>();
       }
    }

    //will place a value and key into the hashed slot in the table
    public void put(K key, V value) {
        int hashValue = Math.abs(key.hashCode() % size);

        //if nothing is in the list place as head...
        if(l[hashValue].head == null)
            l[hashValue].add(value,key);

        else{
            boolean check = false;
            Link <K,V> t = l[hashValue].head;
            while(t != null && t.key != key){
                if (t.key.equals(key)) {
                    check = true;
                    break;
                }
                t = t.next;
            }
            //if value is not present write as normal
            if(!check)
                l[hashValue].add(value,key);
                //else rewrite because value is already in the linked list
            else {
                t.data = value;
            }


        }

    }

    //goes to the hash slot in the table and loops through the list until the key is found
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % size);
        Link <K,V> t = l[hashValue].head;
        while(t != null){
            if (t.key.equals(key)) {
                return t.data;
            }
            t = t.next;
        }
        return null;
    }

//returns an iterator object which holds an array of keys and can be iterated through
    public Iterator <K> iterator() {
        int count =0;
        Link <K,V> c;
        //counts how many items are in the table
        for(int i = 0; i < l.length; i++){
            if(l[i].head != null){
                c = l[i].head;
                while(c.next != null && c.next.data != c.data){
                    count++;
                    c = c.next;
                }
                count++;
            }

        }

        //creates a key array with the total number of items
        ka = (K[]) new Object[count];
        int countTwo = 0;

        //places items into array
        for(int i = 0; i < l.length; i++){
            if(l[i].head != null){
                c = l[i].head;
                while(c.next != null && c.next.data != c.data){
                    ka[countTwo] = c.key;
                    countTwo++;
                    c = c.next;
                }
                ka[countTwo] = c.key;
                countTwo++;
            }

        }

        //returns iterator
        HashTableIterator <K> n = new HashTableIterator<K>(ka);
        return n;
    }
}
