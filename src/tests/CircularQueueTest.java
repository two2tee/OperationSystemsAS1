package tests;

import junit.framework.TestCase;

/**
 * Test for the circular queue implemented in utilities.CircularQueue
 */
public class CircularQueueTest extends TestCase {
    private final int BUFFER_SIZE = 5;
    String mockItem = "item";
    CircularQueue SUT;


    public void setUp() {
        SUT = new CircularQueue(BUFFER_SIZE);
    }

    public void testIsEmpty() {
        assertTrue("initial buffer is not empty",SUT.isEmpty());
    }

    public void testSize() throws Exception {
        SUT.enqueue(mockItem);
        assertTrue("returned " + SUT.size()+" but should be 1",SUT.size() == 1);

    }

    public void testEnqueueWhenFull() throws Exception {
        assertFalse("Buffer is full without being full",SUT.isFull());
        boolean isFail = false;
        try {
            for (int i = 0; i < BUFFER_SIZE + 2; i++) {
                SUT.enqueue(mockItem);
            }
        }catch (ArrayStoreException e){
            isFail = true;
            assertTrue(isFail);
        }
        assertTrue("exception not thrown",isFail);
    }

    public void testDequeueWhenEmpty() {
        assertTrue("Buffer is not empty",SUT.isEmpty());
        boolean isFail = false;
        try {
            SUT.dequeue();
        }catch (ArrayStoreException e){
            isFail = true;
            assertTrue(isFail);
        }
        assertTrue("exception not thrown",isFail);
    }

    public void testEnqueue() throws Exception {
        assertTrue(SUT.isEmpty());
        SUT.enqueue(mockItem);
        assertTrue("returned " + SUT.size()+" but should be 1",SUT.size() == 1);
    }

    public void testDequeue() throws Exception {
        assertTrue(SUT.isEmpty());
        SUT.enqueue(mockItem);
        assertTrue("returned " + SUT.size()+" but should be 1",SUT.size() == 1);
        String returnedItem = (String) SUT.dequeue();
        assertTrue("buffer should be empty after dequeue",SUT.isEmpty());
    }
}