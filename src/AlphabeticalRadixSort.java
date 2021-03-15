import java.util.Iterator;

public class AlphabeticalRadixSort {
    public void sort(String[] a){
        StringLinkedList[] list = new StringLinkedList[26]; // create an array of StringLinkedList for 26 letters in alphabets
        int count = 0;
        // initialize all the elements in the array to new StringLinkedList
        for (int i = 0; i < list.length; i++) {
            list[i] = new StringLinkedList();
        }


        // Put the datas in the file according to their third character into the corresponding StringLinkedLists
        // For example, "Zachary" would go to to list[2]
        //while(hit.hasNext())
        for(int j = 0; j < a.length; j++)
        {

            String currentdata = a[j];
            for(int i = 0; i < 26; i++){
                if(currentdata.charAt(2) == (char)(i+97))
                {
                    list[i].addToEnd(currentdata);
                }
            }
            count++;
        }

        // copy sorted sLinks to new StringLinkedList called container
        StringLinkedList container = new StringLinkedList();
        for (int i = 0; i < 26; i++) {
            sLink n = list[i].head;

            while(n != null){
                container.addToEnd(n.data);
                n = n.next;
            }
        }
        // empty all the elements of array
        for (int i = 0; i < list.length; i++) {
            list[i] = new StringLinkedList();
        }

        sLink m = container.head;
        while(m!=null)
        {
            String currentdata = m.data;
            for(int i = 0; i < 26; i++){
                if(currentdata.charAt(1) == (char)(i+97))
                {
                    list[i].addToEnd(currentdata);
                }
            }
            m = m.next;
            count++;
        }
        container = new StringLinkedList();
        for (int i = 0; i < 26; i++) {
            m = list[i].head;

            while(m!=null){
                container.addToEnd(m.data);
                m = m.next;
            }
        }
        for (int i = 0; i < list.length; i++) {
            list[i] = new StringLinkedList();
        }
        m = container.head;

        while(m!=null)
        {
            String currentdata = m.data;

            for(int i = 0; i < 26; i++){
                if(currentdata.charAt(0) == (char)(i+97))
                {
                    list[i].addToEnd(currentdata);
                }
            }
            m = m.next;
            count++;
        }
        container = new StringLinkedList();
        for (int i = 0; i < 26; i++) {
            m = list[i].head;

            while(m!=null){
                //System.out.println("poggers");
                System.out.println(m.data);
                container.addToEnd(m.data);
                m = m.next;
            }
        }
    }
}
