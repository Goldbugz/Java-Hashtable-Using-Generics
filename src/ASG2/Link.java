
    public class Link <K,V>{
        Link<K,V> next;
        V data;
        K key;

        Link(Link<K,V> n, V d, K k){
            next = n;
            data = d;
            key = k;
        }
    }

