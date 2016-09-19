import java.util.concurrent.Semaphore;

/**
 * Buffer
 */
public class Buffer{

    // remember to initialize the semaphores in the constructor
    private Semaphore empty, full, mutex;
    private BufferItem bufferitem;

    //more private fields such as a container object for holding the buffer items

    public Buffer() {
        bufferitem = new BufferItem(Constants.BUFFER_SIZE); //Initialize buffer with capacity of buffer size
        empty = new Semaphore(Constants.BUFFER_SIZE);
        full = new Semaphore(0);
        mutex = new Semaphore(1);



    }

    /**
     * Inserts and item if there is a mutex available and if the buffer is not full.
     * @param item to add
     * @return return code
     * @throws InterruptedException
     */
    public int insert_item(Object item) {

        try {
            //acquire semaphores
            if(!mutex.tryAcquire() || (empty.availablePermits() == 0) ) return -1;
            mutex.acquire();
            empty.acquire();
            full.release();

            //critical section
            //insert the item
            bufferitem.enqueue(item);

            //release semaphores
            mutex.release();
            return 1;


        } catch (InterruptedException e) {return -1;}
          catch (ArrayStoreException e){return -1;}
    }

    public Object remove_item() {
        try {
            //acquire semaphores
            if(!mutex.tryAcquire() || (full.availablePermits() == 0) ) return -1;
            mutex.acquire();
            full.acquire();

            empty.release();

            //critical section
            //get item
            Object toReturn = bufferitem.dequeue();

            //release semaphores
            mutex.release();
            return toReturn;

        } catch (InterruptedException e) {return -1;}
        catch (ArrayStoreException e){return -1;}

    }

    public static void main(String[] args) {
        // your code
        // multiple producer/consumer threads need to be created based on input parameters

    }
}
