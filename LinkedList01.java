// Creating the linkedList from scratch with no in-built methods

// node of the linkedlist
class Node {
    int data; // holds data
    Node next; // the next of the node, given null on default

    Node (int data) { // default contructor of the node
        this.data = data;
        next = null;
    }
}

class OwnLinkedList {
    Node head; // head of LL
    int size = 0; // keep track of size in LL

    public void add (int element) // adding the element into the tail of the LL
    {
        // check if head is created else create a new one
        if (head == null) {
            head = new Node(element);
            size++;
            return; // then stop
        }

        // The node which needs to be added to the tail
        Node input = new Node(element);
        //store the head pointer
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next; // this will update temp to the end of the LL
        }

        // Add a new node to the end
        temp.next = input;
        size++;
    }

    public void printList()
    {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
        System.out.println();
    }

    public void addAndSort(int value)
    {
        // create the input node
        Node nValue = new Node(value);

        // find the node which has a data that is bigger than value
        // so to insert it in later
        Node prev = null, curr = head;
        while (curr != null && curr.data < value) {
            prev = curr;
            curr = curr.next;
        }
        // if found a node which has a bigger value than value,
        // update the new node to point to the current node, and the prev node to the new node
        // if the value is bigger than all of them, it will point to a null
        nValue.next = curr;
        prev.next = nValue;

        size ++;
    }

    public void swapValues(int indexOne, int indexTwo)
    {
        // index and the node # are the same thing in this case.

        // if both index are the same do nothing
        if (indexOne == indexTwo) return;

        int counter = 0;
        Node prevOne = null, currOne = head;

        // traverse through the ll based on index
        while (currOne != null && counter != indexOne) {
            prevOne = currOne;
            currOne = currOne.next;
            counter++;
        }

        int counter2 = 0;
        Node prevTwo = null, currTwo = head;
        while (currTwo != null && counter2 != indexTwo) {
            prevTwo = currTwo;
            currTwo = currTwo.next;
            counter2++;
        }

        if(prevOne != null) {
            prevOne.next = currTwo;
        } else {
            head = currTwo;
        }

        if(prevTwo != null) {
            prevTwo.next = currOne;
        } else {
            head = currOne;
        }


        // swapping the pointers
        Node temp = currOne.next;
        currOne.next = currTwo.next;
        currTwo.next = temp;

    }

    public int findValue(int searchVal)
    {
        int indexPos = 0;

        Node prev = null, curr = head; // same as before
        // search for the value
        while (curr != null && curr.data != searchVal) {
            prev = curr;
            curr = curr.next;
            indexPos++;
        }


        // if searchVal could not be found, meaning the curr == null then
        if (curr == null) {
            System.out.println("searchVal could not be found in linked list");
            return -1;
        }

        return indexPos;
    }
}

public class LinkedList01 {
    public static void main(String[] args) {
        OwnLinkedList ll = new OwnLinkedList();

        ll.add(1);
        ll.add(3);
        ll.add(5);
        ll.add(7);
        ll.add(9);
        ll.add(11);

        ll.printList();

        ll.addAndSort(6);
//        ll.addAndSort(13);

        ll.printList();

        ll.swapValues(1, 4);

        ll.printList();

        OwnLinkedList ll2 = new OwnLinkedList();

        int min = 1000;
        int max = 9999;
        for (int i=0; i < 500; i++) {
            int random = (int) (Math.random() * (max-min+1) + min);
            ll2.add(random); // populating the linked list
        }

        int searchVal = (int) (Math.random() * (max-min+1) + min);
        System.out.println("Search value: " + searchVal);
        System.out.println("The index of the searched value is: " + ll2.findValue(searchVal));
    }
}