/*
Andrew Achusim
03/11/2025
Purpose: To create a doubly-linked, self-sorting list that can be used in place of the ArrayList used in the Hurricane assignment.
Sources:
    1.) I learned about Doubly Linked List @ https://www.geeksforgeeks.org/introduction-to-doubly-linked-lists-in-java/.
*/
public class DoublyLinkedSortedListNode
{
    // The three private data members of the node
    private HurricaneRowData value;
    private DoublyLinkedSortedListNode next;
    private DoublyLinkedSortedListNode previous;

    // constructor
    public DoublyLinkedSortedListNode(HurricaneRowData value)
    {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    // getters
    public HurricaneRowData getValue(){return value;}
    public DoublyLinkedSortedListNode getNext(){return next;}
    public DoublyLinkedSortedListNode getPrevious(){return previous;}

    // setters
    public void setNext(DoublyLinkedSortedListNode next){this.next = next;}
    public void setPrevious(DoublyLinkedSortedListNode previous){this.previous = previous;}
}
