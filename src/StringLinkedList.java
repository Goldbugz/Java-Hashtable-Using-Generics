public class StringLinkedList {
        public sLink head;

        public void init() {
            this.head = null;
        }

        public sLink FindTail() {
            sLink current = head;
            if (current == null) {
                System.out.println("The linklist is empty");
                return null;
            } else if (current.next == null) {
                return current;
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                return current;
            }
        }

        public void addToEnd(String m){
            if(head == null){
                head = MakesLink(m);
            }else{
                sLink tail;
                tail = findTail(head);
                tail.next = MakesLink(m);
            }
        }

        public sLink MakesLink(String s) {
            sLink newsLink = new sLink(s);
            return newsLink;

        }

        public void InsertAfter(sLink spot, String s) {
            sLink mysLink = MakesLink(s);
            mysLink.next = spot.next;
            spot.next = mysLink;
        }

        public void showList() {
            sLink current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

        public sLink findTail(sLink head) {
            sLink current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }

        public void addhead(String s){
            sLink mysLink = MakesLink(s);
            sLink j = head;
            mysLink.next=j;
            head = mysLink;
        }

        public void insertBefore(sLink n, String m) {
            sLink mysLink = MakesLink(m);
            sLink j = head;
            while (j.next != n) {
                j = j.next;
            }
            mysLink.next = n;
            j.next = mysLink;
        }

        public void showSpec(String start)
        {
            sLink n = this.head;
            while(n != null)
            {
                if(n.data.startsWith(start))
                {
                    System.out.println(n.data);
                }
                n = n.next;
            }
        }

        public static StringLinkedList AddAList(StringLinkedList onelist, StringLinkedList anotherlist)
        {
            StringLinkedList sumlist = new StringLinkedList();
            sLink lastsLink = onelist.head;
            while(lastsLink.next != null)
            {
                sumlist.addToEnd(lastsLink.data);
                lastsLink = lastsLink.next;
            }

            lastsLink = anotherlist.head;
            while(lastsLink != null)
            {
                sumlist.addToEnd(lastsLink.data);
                lastsLink = lastsLink.next;
            }
            return sumlist;
        }

        public void deletesLink(String data)
        {
            sLink current = this.head;
            while (current != null) {
                if (current.next.data.equals(data)) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }
        public void section(String str)
        {
            sLink current = this.head;
            int count =0 ;
            while(current != null)
            {
                if(current.data.startsWith(str)){
                    count = count+1;
                    System.out.println(current.data);
                }
                current = current.next;
            }
        }
    }
    /*
    sLink head;

    public void addTohead(String d){
        sLink n = new sLink(head,d);
        head = n;
    }

    public void addToEnd(String d){
        sLink temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        sLink n = new sLink(null,d);
        temp.next = n;
    }
   
     */




