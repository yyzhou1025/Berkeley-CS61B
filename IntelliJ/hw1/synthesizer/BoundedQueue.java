package synthesizer;
import java.util.Iterator;

/**
 * @author YuanyuanZhou
 */
public interface BoundedQueue<T> extends Iterable<T> {
    /**
     *
     * @return size of the buffer.
     */
    int capacity();

    /**
     *
     * @return  number of items currently in the buffer.
     */
    int fillCount();

    /**
     *  add item x to the end.
     * @param x  the item
     */
    void enqueue(T x);

    /**
     *  delete and return item from the front.
     * @return item from the front
     */
    T dequeue();

    /**
     *
     * @return (but do not delete) item from the front.
     */
    T peek();

    /**
     * s the buffer empty (fillCount equals zero)?
     * @return true if is empty, false otherwise
     */
    default boolean isEmpty() {
        if (fillCount() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * is the buffer full (fillCount is same as capacity)?
     * @return true if is full, false otherwise
     */
    default boolean isFull() {
        if (fillCount() == capacity()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    Iterator<T> iterator();



}
