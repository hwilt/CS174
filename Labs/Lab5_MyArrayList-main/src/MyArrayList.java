/**
 * This is a vanilla implementation of Java's ArrayList class, which
 * provides a flexible array-like container with constant random access,
 * but which resizes adaptively to accommodate new elements
 * @author You!
 * @param <Item> The type that this container will hold 
 */
public class MyArrayList<Item> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] items; // Underlying array that holds everything
    private int N; // size of the arraylist
    
    /**
     * Initialize an ArrayList object with a particular 
     * starting capacity
     * @param startSize Initial capacity of the array
     */
    public MyArrayList(int startSize) {
        items = new Object[startSize];
        N = 0;
    }
    /**
     * Initialize an ArrayList object with the underlying array
     * having the default capacity
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Double the capacity of the underlying array by creating
     * a new underlying array and copying everything over that 
     * was there before up to N
     */
    private void doubleCapacity() {
        // TODO: Fill this in
        int newSize = items.length*2;
        Object[] newItems = new Object[newSize];
        for(int i = 0; i < N; i++){
            newItems[i] = items[i];
        }
        items = newItems;
    }
    
    /**
     * Halve the capacity of the array that holds the elements
     * @throws RuntimeException if half of the current size wouldn't be
     *         enough to hold the elements that are there
     */
    private void halveCapacity() {
        int newSize = items.length/2;
        if (newSize < N) {
            throw new RuntimeException("Trying to halve storage but not enough space to hold what's there");
        }
        Object[] newItems = new Object[newSize];
        for (int i = 0; i < N; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }
    
    /**
     * Copy out the elements into a fixed array
     * @return An array holding the elements currently
     *         in this arraylist
     */
    public Object[] toArray() {
        Object[] ret = new Object[N];
        for (int i = 0; i < N; i++) {
            ret[i] = items[i];
        }
        return ret;
    }
    
    /**
     * Clear all of the elements from the arraylist.
     * It's as simple as setting N to be 0!
     */
    public void clear() {
        N = 0;
    }
    
    /**
     * Return how many elements are stored in the arraylist
     * @return N
     */
    public int size() {
        return N;
    }
    
    /**
     * Put an item at a particular index
     * @param index Index to which to add element
     * @param item Item to add
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, Item item) {
        items[index] = item;
    }
    
    /**
     * Add an item to the end of the list and update its size
     * TODO: Update this so that if there isn't enough space
     * in the underlying array, that it doubles the capacity of 
     * the array first (hint: use your doubleCapacity() method to do this)
     * @param item Item to add
     */
    public void add(Item item) {
        // TODO: Update this so that it doubles the capacity of the
        // underlying array if it's run out of space, so that there
        // is always enough room to add an element
        if (N < items.length) {
            items[N] = item;
            N++;
        }
        else {
            doubleCapacity();
            items[N] = item;
            N++;
        }
    }
    
    /**
     * Add an item to the middle of the list at a specified index, and
     * move everything to the right of it over by one index.  Be sure
     * to double the capacity if needed
     * @param index The index at which to insert the element
     * @param item The element to insert
     */
    public void add(int index, Item item) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        else{
            Object[] newItems = new Object[N + 1];
            for(int i = size(); i >= 0; i--){
                if(i < index){
                    newItems[i] = items[i];
                }
                else if(i == index){
                    newItems[i] = item;
                    N++;
                }
                else{
                    if(size() >= items.length){
                        doubleCapacity();
                        newItems[i] = items[i - 1];
                    }
                    else{
                        newItems[i] = items[i - 1];
                    } 
                }
            }
            items = newItems;
        }
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    public Item get(int index) {
        return (Item)items[index];
    }
    
    /**
     * Return the index of the first occurrence of a particular
     * item, or -1 if the item does not exist in the list
     * @param item Item we're searching for
     * @return Index of the first occurrence of the item, or -1 if
     *         it's not in the list
     */
    public int indexOf(Item item) {
        int index = -1;
        boolean found = false;
        for (int i = 0; i < N && !found; i++) {
            if (items[i].equals(item)) {
                index = i;
                found = true;
            }
        }
        return index;
    }
    
    
    /**
     * Remove an item at a particular index and return it.
     * You should also move everything to the right of this
     * index over one to the left and update the size N.
     * Finally, if the new number of elements being stored is 
     * small enough, you should halve the capacity
     * @param index The index at which to obtain and remove the item
     * @return The item that was removed
     */
    public Item remove(int index) {
        Item ret = null;
        for(int i = index; i <= size(); i++){
            if(i == index){
                ret = (Item)items[i];
                items[i] = items[i+1];
                N--;
            }
            else{
                items[i - 1] = items[i];
            }
        }
        if(size() <= items.length/2){
            halveCapacity();
        }
        return ret;
    }
    
    /**
     * Remove the first occurrence of a particular item
     * from the list if it is present and return it
     * (HINT: Make use of the indexOf method and the overloaded version of
     *        remove above that takes an index so you don't have to 
     *        rewrite so much code)
     * @param item The item to remove
     * @return The item if it was found, or null if it was not found
     *         in the list
     */
    public Item remove(Item item) {
        Item ret = null;
        ret = remove(indexOf(item));
        return ret;
    }
    
    public String toString() {
        String ret = "[";
        for (int i = 0; i < N; i++) {
            ret += items[i].toString();
            if (i < N-1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
    
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        arr.add(1, 100);
        arr.add(5, 60);
        System.out.println(arr);
    }
}
