import interfaces.IBuffer;
import interfaces.IQueue;
import utilities.Constants;

import java.util.concurrent.Semaphore;

/**
 * This program implements the bounded buffer with semaphores and a mutex lock.
 */
public class BoundedBuffer implements IBuffer {

    private Semaphore empty, full, mutex;
    private IQueue bufferQueue;

    // More private fields such as a container object for holding the buffer items

    // Initialize semaphores
    public BoundedBuffer(IQueue bufferQueue)
    {
        this.bufferQueue = bufferQueue;
        empty = new Semaphore(Constants.BUFFER_SIZE);
        full = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    /**
     * Inserts item if there is a mutex available and if the buffer is not full.
     * @param item to add
     * @return return code
     * @throws InterruptedException
     */
    public synchronized int insert_item(Object item)
    {
        try
        {
            // Acquire semaphores
            if(!mutex.tryAcquire() || (empty.availablePermits() == 0) ) { return -1; }
            mutex.acquire();
            empty.acquire();
            full.release();

            // Critical section
            // Insert the item
            bufferQueue.enqueue(item);

            // Release semaphores
            mutex.release();
            return 1;
        }
        catch (InterruptedException e) { return -1; }
        catch (ArrayStoreException e) { return -1; }
    }

    /**
     * Removes item if there is a mutex available and the buffer is not full.
     * @return the item removed
     */
    public synchronized Object remove_item() {
        try
        {
            //acquire semaphores
            if(!mutex.tryAcquire() || (full.availablePermits() == 0) ) { return -1; }
            mutex.acquire();
            full.acquire();

            empty.release();

            //critical section
            //get item
            Object toReturn = bufferQueue.dequeue();

            //release semaphores
            mutex.release();
            return toReturn;

        }
        catch (InterruptedException e) { return -1; }
        catch (ArrayStoreException e) { return -1; }

    }

}
