/*
Andrew Achusim
03/11/2025
Purpose: To create a doubly-linked, self-sorting list that can be used in place of the ArrayList used in the Hurricane assignment.
Sources:
    1.) I learned about Doubly Linked List @ https://www.geeksforgeeks.org/introduction-to-doubly-linked-lists-in-java/.
*/
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface
{
    // Private variables
    private DoublyLinkedSortedListNode head; // First node.
    private DoublyLinkedSortedListNode tail; // Last node.
    private int size; // Size of the list.

    // constructor
    public DoublyLinkedSortedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // An override of the HurricanRowData object in DoublyLinkedSortedListInterface.
    @Override
    public HurricaneRowData getValue()
    {
        // An if loop that checks if the DoublyLinkedSortedListNode object has a value,
        // then gets the value if true.
        if(head != null){return head.getValue();}
        return null;
    }

    // An override of a boolean method in DoublyLinkedSortedListInterface.
    @Override
    public boolean hasNext()
    {
        // Returns true if both head and hean.getNext() have value.
        return head != null && head.getNext() != null;
    }

    // An override of a void method in DoublyLinkedSortedListInterface.
    @Override
    public void setNext(DoublyLinkedSortedListNode next)
    {
        // An if loop that checks if the DoublyLinkedSortedListNode object has a value,
        // then sets the value of the next part of the list.
        if(head != null){head.setNext(next);}
    }

    // An override of the DoublyLinkedSortedList object in DoublyLinkedSortedListInterface.
    @Override
    public DoublyLinkedSortedList getNext()
    {
        // An if loop that checks if the DoublyLinkedSortedNode object has a value,
        // then return the next node if true.
        if(head != null){return this;}
        return null;
    }

    // An override of a boolean method in DoublyLinkedSortedListInterface.
    @Override
    public boolean hasPrevious()
    {
        // Returns true if both head and getPrevious() have value.
        return head != null && head.getPrevious() != null;}

    // An override of a void method in DoublyLinkedSortedListInterface.
    @Override
    public void setPrevious(DoublyLinkedSortedListNode previous)
    {
        // An if loop that checks if the DoublyLinkedSortedListNode object has a value,
        // then sets the value of the previous part of the list.
        if(head != null){head.setPrevious(previous);}}

    // An override of the DoublyLinkedSortedList object in DoublyLinkedSortedListInterface.
    @Override
    public DoublyLinkedSortedList getPrevious()
    {
        // An if loop that checks if the DoublyLinkedSortedNode object has a value,
        // then return the previous node if true.
        if(head != null){return this;}
        return null;
    }

    // An override of the DoublyLinkedSortedList object in DoublyLinkedSortedListInterface.
    @Override
    public DoublyLinkedSortedList getFirst(){return this;}

    // An override of the DoublyLinkedSortedList object in DoublyLinkedSortedListInterface.
    @Override
    public DoublyLinkedSortedList getLast(){return this;}

    // An override of the DoublyLinkedSortedList object in DoublyLinkedSortedListInterface.
    @Override
    public DoublyLinkedSortedList remove(HurricaneRowData toRemove)
    {
        // A new DoublyLinkedSortedListNode object.
        DoublyLinkedSortedListNode current = head;
        // A while loop the runs till it reaches the end of the list.
        while(current != null)
        {
            // An if loop that checks if the value in the DoublyLinkedSortedListNode object is equal to the value of
            // the HurricaneRowData object.
            if(current.getValue().equals(toRemove))
            {
                // An if loop that checks if the DoublyLinkedSortedNode object has a value.
                if(current.getPrevious() != null)
                {
                    // Updates the DoublyLinkedSortedNode object to the next position.
                    current.getPrevious().setNext(current.getNext());
                }
                // Updates the DoublyLinkedSortedNode object if it was removed.
                else{head = current.getNext();}

                // An if loop that checks if the DoublyLinkedSortedNode object has a value.
                if(current.getNext() != null)
                {
                    //Updates the DoublyLinkedSortedNode object to the previous position.
                    current.getNext().setPrevious(current.getPrevious());
                }
                // Updates the DoublyLinkedSortedNode object if it was removed.
                else{tail = current.getPrevious();}

                // Shrinks the list by one to avoid creating empty nodes.
                size--;
                return this;
            }
            // If the value in the DoublyLinkedSortedListNode object is not equal to the value of
            // the HurricaneRowData object, move to the next node.
            current = current.getNext();
        }
        return null;
    }

    // An override of a void method in DoublyLinkedSortedListInterface.
    @Override
    public void insert(HurricaneRowData newValue)
    {
        // A new DoublyLinkedSortedListNode object.
        DoublyLinkedSortedListNode newNode = new DoublyLinkedSortedListNode(newValue);
        
        // An if loop that checks if DoublyLinkedSortedListNode object is empty,
        //then sets both head and tail to eachother and to newNode.
        if(head == null){head = tail = newNode;}
        else
        {
            // A new DoublyLinkedSortedListNode object.
            DoublyLinkedSortedListNode current = head;
            // A while loop that runs till both the DoublyLinkedSortedListNode object has value and that value is 
            // less than the value found in newValue.getAce().
            while(current != null && current.getValue().getAce() < newValue.getAce())
            {
                // Moves the DoublyLinkedSortedListNode object to the next node.
                current = current.getNext();
            }

            // An if loop that checks if the value of the DoublyLinkedSortedListNode object
            // equals the value of head.
            if(current == head)
            {
                // Sets the next node value the DoublyLinkedSortedListNode object to head.
                newNode.setNext(head);
                // Sets the previous node value of the DoublyLinkedSortedListNode object to newNode.
                head.setPrevious(newNode);
                // Sets the value of the DoublyLinkedSortedListNode object to newNode.
                head = newNode;
            }
            // An else if loop that checks if the DoublyLinkedSortedListNode object is empty.
            else if(current == null)
            {
                // Sets the next node value of the DoublyLinkedSortedListNode object to newNode.
                tail.setNext(newNode);
                // Sets the previous node value of the DoublyLinkedSortedListNode object to tail.
                newNode.setPrevious(tail);
                tail = newNode;
            }
            // If all else fails...
            else
            {
                // Sets the previous node value of the DoublyLinkedSortedListNode object
                // to the value of current.getPrevious().
                newNode.setPrevious(current.getPrevious());
                // Sets the next node value of the DoublyLinkedSortedListNode object
                // to the value of current.
                newNode.setNext(current);
                // Sets the previous node value of the DoublyLinkedSortedListNode object
                // to the next node value of newNode.
                current.getPrevious().setNext(newNode);
                // Sets the previous node of the DoublyLinkedSortedListNode object to newNode.
                current.setPrevious(newNode);
            }
        }
        // Grows the list by one to accompidate the new node.
        size++;
    }

     // An override of a String object in DoublyLinkedSortedListInterface.
    @Override
    public String toString() 
    {
        // A new String object.
        String result = "";
        // A new DoublyLinkedSortedListNode object.
        DoublyLinkedSortedListNode current = head;
        // A while loop that runs until the DoublyLinkedSortedListNode object is empty.
        while(current != null)
        {
            // Adds the value of the DoublyLinkedSortedListNode object to the String object.
            result += current.getValue().toString() + "\n";
            // Sets the value of the DoublyLinkedSortedListNode object to the next node.
            current = current.getNext();
        }
        return result;
    }

}
