/**
 * Linked list deque.
 * @author YuanyuanZhou
 *
 * @param <T>
 */
public class LinkedListDeque<T> {
    
    public class Node{
        private T item;
        private Node next;
        private Node prev;
        
        public Node(Node p, T i, Node n){
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }
    
    private Node sentinel;
    
    private int size;
    
    private final T x = null;
    /**
     * create  an empty linked list deque.
     */
    public LinkedListDeque(){
        size = 0;
        sentinel = new Node (this.sentinel, x, this.sentinel);    
    }
    
    /**
     * Returns true if deque is empty, false otherwise.
     * @return true or false
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }
    /**
     * Adds an item of type T to the front of the deque.
     * @param i T
     */
    public void addFirst(T i) {
        if (this.isEmpty()) {
            this.sentinel.next = new Node(this.sentinel, i, this.sentinel);
            this.sentinel.prev = this.sentinel.next;
        } else {
            
            this.sentinel.next = new Node (this.sentinel, i, this.sentinel.next);
        }      
        size = size + 1;
        
    }
    
    /**
     * Adds an item of type T to the back of the deque.
     * @param i T
     */
    public void addLast(T i) {
        if (this.isEmpty()) {
            this.sentinel.next = new Node (this.sentinel, i, this.sentinel);
        } else {
            Node oldLast = this.sentinel.prev;
            this.sentinel.prev = new Node(this.sentinel.prev, i, this.sentinel);
            oldLast.next = this.sentinel.prev;
            
        }
        size = size + 1;
    }
    /**
     * calculate size of the linked list.
     * @return size
     */
    public int size() {
        return size;
        
    }
    /**
     * display deque.
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        if (this.isEmpty()) {
            return;
        }
        Node firstItem = this.sentinel.next;
        while (firstItem != this.sentinel) {
                System.out.print(firstItem.item);
                System.out.print(" ");
                firstItem = firstItem.next;
        }
        
    }
    
    /**
     *  Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.
     * @return T
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
           Node first = this.sentinel.next;
           this.sentinel.next = first.next;
           this.sentinel.next.prev = this.sentinel;
           size = size - 1;
           return first.item;
        }      
    }
    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            Node last = this.sentinel.prev;
            this.sentinel.prev = last.prev;
            last.prev.next = this.sentinel;
            size = size - 1;
            return last.item;
        }
    }
    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. 
     * Must not alter the deque!
     * @param index which value you want to get
     * @return the value according to the index
     */
    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }
        if (index < 0 || index >= this.size) {
            return null;
        }
        Node X = this.sentinel;
        for (int i = 0; i < index + 1; i++) {
            X = X.next;
        }
        return X.item;
    }
    
    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    public T getRecursive(int index) {
        if (index < 0 || index > this.size()) {
            return null;
        }
        if (this.isEmpty()) {
            return null;
        }
        Node p = this.sentinel.next;
        return getHelper(p,index);
    }
   

    private T getHelper(Node p, int index) {
        /*base cases*/
        if (index == 0) {
            return p.item;
        }
        return getHelper(p.next,index - 1);
    }

    
}
