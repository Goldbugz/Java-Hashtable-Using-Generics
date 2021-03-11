public class LinkedList <K,V>{
    Link head;

    public void add(V d, K k){
        if(head == null){
            Link n = new Link(null,d,k);
            head = n;
        }
        else{
            Link n = new Link(head,d,k);
            head = n;
        }
    }
}

class Link <K,V>{
    Link next;
    V data;
    K key;

    Link(Link n, V d, K k){
        next = n;
        data = d;
        key = k;
    }
}


