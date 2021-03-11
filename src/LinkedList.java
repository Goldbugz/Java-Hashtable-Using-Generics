public class LinkedList <K,V>{
    Link <K,V> head;

    public void add(V d, K k){
        if(head == null){
            Link<K,V> n = new Link<K,V>(null,d,k);
            head = n;
        }
        else{
            Link <K,V> n = new Link<K,V>(head,d,k);
            head = n;
        }
    }
}

class Link <K,V>{
    Link <K,V> next;
    V data;
    K key;

    Link(Link <K,V> n, V d, K k){
        next = n;
        data = d;
        key = k;
    }
}


