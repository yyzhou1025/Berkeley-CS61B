/**
 * Array based deque.
 * @author YuanyuanZhou
 *
 * @param <T> Anytype
 */

@SuppressWarnings("unchecked")
public class ArrayDeque<T>{
    
    /**
     * instance  variable.
     */
    private static final int FACTOR = 2;
    /**
     * instance variable.
     */
    private static final double USAGE = 0.25;
    /**
     * instance variable.
     */
    private int size;
    /**
     * instance variable.
     */
    private T[] item;
    
    private int head; //mark the head of the array
    
    private int tail; //mark the tail of the array
    
    //create an empty deque
    public ArrayDeque() {
        size = 0;
        head = 0;
        tail = 0;
        item = (T[]) new Object[8];
    }
    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T i) {
        //change the capacity of the array
        if (size == item.length) {
            resize(size * FACTOR);
        }
        if (this.isEmpty()) {
            head = 0;
            tail = 0;
            item[head] = i;
            
        } else {
            if (head == 0) {
                item [item.length - 1] = i;
                head = item.length - 1;
                
            } else {
                item [head - 1] = i;
                head = head - 1;
            }
            
        }
        
        size = size + 1;
        
        
    }
    
    /**
     * Adds an item of type T to the back of the deque.
     * @param i T 
     */
    public void addLast(T i) {
        //change the capacity of the array
        if (size == item.length) {
            resize(size * FACTOR);
        }
        if (this.isEmpty()) {
            head = 0;
            tail = 0;
            item[tail] = i;
        } else {
            if(tail != item.length - 1) {
                tail = tail + 1;
                item[tail] = i;
            } else {
                tail = 0;
                item[tail] = i;
            }
            
            
        }
        size = size + 1;
    }
    
    /**
     *  Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        if (this.isEmpty()) {
            return; 
        } else {
            if (head > tail) {
                for (int i = head; i < item.length; i++) {
                    System.out.print(item[i]);
                    System.out.print(" ");
                }
                for (int i = 0; i < tail; i++) {
                    System.out.print(item[i]);
                    System.out.print(" ");
                    
                }
                System.out.print(item[tail]);
               
            } else { 
                for (int i = head; i < tail; i++) {
                    System.out.print(item[i]);
                    System.out.print(" ");
                }
                System.out.print(item[tail]);
            }
               
                 
            
        }
    }
    
    /**
     * see if the deque is empty or not.
     * @return if it is empty return false, else return true
     */
     public boolean isEmpty() {
         if (size == 0 ) {
             return true;
         } else {
             return false;
         }
     }
    
    /**
     * change the array's capacity.
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newDeque = (T[])new Object[capacity];
        if (head > tail) {
            int some = item.length - head;
            System.arraycopy(item, head, newDeque, 0, some);
            System.arraycopy(item, 0, newDeque, some, size - some);
        } else {
            System.arraycopy(item, 0, newDeque, 0, size);
        }
        
        item = newDeque;
        head = 0;
        tail = size - 1;     
    }
    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return the remove item
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        int oldHead = head;
        head = head + 1;
        size  = size - 1;
        
        
        if (size >= 16 && (size / item.length) < USAGE) {
            resize (size * FACTOR);
        }
        return item[oldHead];
    }
    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            int oldTail = tail;
            if (tail == 0) {
                tail = item.length;
                size = size - 1;
            } else {
                tail = tail - 1;
                size = size - 1;  
            }
            
            if (size >= 16 && (size / item.length) < USAGE) {
                resize (size * FACTOR);
            }
            return item[oldTail];
        }
    }
    /**
     * return the size of the deque.
     * @return int size
     */
    public int size() {
        return size;
    }
    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. 
     * If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }
        if (index < 0 || index > size - 1)  {
            return null;
        }
        return item[index];
         
        
    }
    
    
}