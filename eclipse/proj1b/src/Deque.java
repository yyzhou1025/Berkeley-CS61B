
public interface Deque<T> {
    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T i);
    /**
     * Adds an item of type T to the back of the deque.
     * @param i T 
     */
    public void addLast(T i);
    
    
    /**
     *  Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque();
    
    
    /**
     * see if the deque is empty or not.
     * @return if it is empty return false, else return true
     */
    public boolean isEmpty();
    
    
    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return the remove item
     */
    public T removeFirst();
    
    
    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast();
    
    
    /**
     * return the size of the deque.
     * @return int size
     */
    public int size();
    
    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. 
     * If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index);
    

   

}
