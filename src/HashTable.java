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
    public void put(K key, V value) {
        int hashValue = Math.abs(key.hashCode() % size);

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
            if(!check)
                l[hashValue].add(value,key);
                //else rewrite because value is already in the linked list
            else {
                t.data = value;
            }


        }

    }

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


    public Iterator <K> iterator() {
        int count =0;
        Link <K,V> c;
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


        ka = (K[]) new Object[count];
        int countTwo = 0;

        for(int i = 0; i < l.length; i++){
            if(l[i].head != null){
                c = l[i].head;
                while(c.next != null && c.next.data != c.data){
                    //fix this no casts bad
                    ka[countTwo] = c.key;
                  //  ka[countTwo].equals(c.key);
                    countTwo++;
                    c = c.next;
                }
                //fix this no casts bad
                ka[countTwo] = c.key;
                countTwo++;
            }

        }

        HashTableIterator <K> n = new HashTableIterator<K>(ka);
        return n;
    }
}
