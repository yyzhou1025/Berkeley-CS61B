package synthesizer;


public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;

    protected int capacity;

    /**
     *
     * @return
     */
    public int capacity() {
        return capacity;
    }

    public int fillCount(){
        return fillCount;
    }
    @Override
    public boolean isEmpty() {
        if (fillCount() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (fillCount() == capacity()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
      * @return
     */
    public abstract T peek();

    /**
     *
     * @return
     */
    public abstract T dequeue();

    /**
     *
     * @param x
     */
    public abstract void enqueue(T x);
}
