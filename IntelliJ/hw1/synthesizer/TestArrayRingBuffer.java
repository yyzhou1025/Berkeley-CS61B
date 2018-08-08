package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer();
        ArrayRingBuffer a = new ArrayRingBuffer(4);
        assertTrue(a.isEmpty());
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        assertTrue(a.isFull());
        assertEquals(4, a.fillCount);
        assertEquals(1,a.dequeue());
        assertEquals(3,a.fillCount);
        assertEquals(2,a.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
