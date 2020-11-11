import java.util.Arrays;
import java.util.Iterator;

/**
 * Our very own deque collection class!  
 * @param <Item> We use a "generic" so that it can be a list of any object type
 */
public class Deque<Item> implements Iterable {
    
    /**
     * An "inner class" that's only accessible from within LinkedList.
     * This encapsulates what it means to be a node in a list
     */
    private class Node {
        private Node next; // Reference to next node
        private Item value; // What's being stored in this node
        private Node prev; //Reference to last node
        /**
         * Make a new node to store a particular value
         * with a null next pointer by default
         * @param value Value to store
         */
        public Node(Item value) {
            next = null;
            prev = null;
            this.value = value;
        }
        /**
         * Update the reference pointer to point to this node
         * @param newRef Node to which to point
         */
        public void updateNextReference(Node newRef) {
            next = newRef;
        }
        /**
         * Update the reference pointer to point to this node
         * @param newRef Node to which to point
         */
        public void updatePrevReference(Node newRef) {
            prev = newRef;
        }
        /**
         * Update the value stored at this node
         * @param value Value to store
         */
        public void setValue(Item value) {
            this.value = value;
        }
        /**
         * Return the item stored at this node
         * @return Item
         */
        public Item getValue() {
            return value;
        }
    }
    
    private class LLIterator implements Iterator<Item> {
        private Node forwardCursor;
        private Node backwardCursor;
        private Deque list;
        
        public LLIterator(Deque list) {
            this.list = list;
            forwardCursor = head;
            backwardCursor = tail;
        }
        
        @Override
        public boolean hasNext() {
            return forwardCursor != null;
        }

        @Override
        public Item next() {
            Item item = null;
            if (forwardCursor != null) {
                item = forwardCursor.value;
                forwardCursor = forwardCursor.next;
            }
            return item;
        }
        
        
        public boolean hasPrev(){
            return backwardCursor != null;
        }
        
        public Item prev(){
            Item item = null;
            if(backwardCursor != null){
                item = backwardCursor.value;
                backwardCursor = backwardCursor.prev;
            }
            return item;
        }
    }
    
    public Iterator iterator() {
        return new LLIterator(this);
    }
    
    private Node head; // All the linked list needs for us to 
    // iterate through it is a reference to the head node, 
    // which is null by defalut
    private Node tail; //End of the Deque & points to prev but no next
    private int size = 0; //Size of the deque
    public Deque() {
        head = null;
        tail = null;
    }
    
    
    /**
     * Add an item to the end of the deque
     * This method should run in constant time
     * @param value Item to add
     */
    public void addLast(Item value) {
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }
    
    /**
     * Add an item to the beginning of the deque
     * This method should run in constant time
     * @param value 
     */
    public void addFirst(Item value) {
        Node newNode = new Node(value);
        if(tail == null){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
    
    /**
     * Remove and return the first item from the deque, or return
     * null if nothing is there
     * This method should run in constant time
     * @return The first item in the deque, or null if empty
     */
    public Item removeFirst() {
        Item value = null;
        if(head != null){
            value = head.getValue();
            head = head.next;
            size--;
        }
        return value;
    }
    
    /**
     * Remove and return the last item from the deque, or return null
     * if nothing is there
     * This method should run in constant time
     * @return The last item in the deque, or null if empty
     */
    public Item removeLast() {
        Item value = null;
        if(tail != null){
            value = tail.getValue();
            tail = tail.prev;
            size--;
        }
        return value;
    }
    
    /**
     * Remove and return the first occurrence of an item from the 
     * deque, if it exists.  Otherwise, return null
     * (This method does not have to run in constant time, and should
     * probably use a while or do while loop)
     * @param value The value to remove
     * @return The value if found, or null if not found
     */
    public Item remove(Item value) {
        Item revalue = null;
        Node newNode = new Node(value);
        if(head != null) {
            if(head.getValue().equals(value)) { // finds if head is the value
                revalue = removeFirst();
            }
            else if(tail.getValue().equals(value)){ //finds if tail is the value
                revalue = removeLast();
            }
            else {
                Node last = head;
                Node node = head.next;
                Node next = node.next;
                while (node != null && !node.value.equals(value)) { //finds if its inbetween
                    last = node;
                    node = node.next;
                    next = next.next;
                }
                if (node != null) { //once while loop is done, sees if its null (if null means it is not found)
                    revalue = newNode.getValue();
                    last.next = node.next;
                    next.prev = node.prev;
                    size--;
                }
            }
        }
        return revalue;
    }
    
    /**
     * Return how many elements are currently stored in the deque.
     * This method should run in constant time.
     * The easiest way to do this is by storing a private variable 
     * that tracks the size as different operations are performed.
     * @return Number of elements stored in the deque
     */
    public int size() {
        return size;
    }
    
    /**
     * Return an array representation of the items in the deque.
     * If there are N elements, the array should be of length N.
     * Because of some Java weirdness, we have to return an array of
     * type Object instead of type Item, but ever class is a subclass
     * of Object, so the cast will happen automatically upon assignment
     * @return An array of items in this deque
     */
    public Object[] toArray() {
        // TODO: Fill this in
        Object[] arr = new Object[size];
        Node node = head;
        for(int i = 0; i < size && node.getValue() != null; i++){
            arr[i] = node.getValue();
            node = node.next;
        }
        return arr;
    }
    
    /**
     * Clear the entire deque
     * This should run in constant time (Hint: you should
     * just have to set your head/tail to null, and everything
     * in the collection will be dereferenced)
     */
    public void clear() {
        this.head = null;
        this.tail = null;
    }
    
    public static void main(String[] args) {
        // Put some code in here to test your method
        // implementations as you're going along        
        Deque d = new Deque();
        d.addLast(1);
        d.addFirst(2);
        d.addLast(3);
        d.remove(3);
        Object[] ar = d.toArray();
        for(int i = 0; i < ar.length; i++){
            System.out.print(ar[i] + ", ");
        }
    }
}