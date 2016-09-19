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

    public int insert_item(Object item) throws InterruptedException {

        if(!mutex.tryAcquire() || (empty.availablePermits() == 0) ) return -1;

        empty.release();
        full.acquire();
        //acquire semaphores
        //critical section
        //insert the item

        //release semaphores
    }

    public Object remove_item() {

        //acquire semaphores

        //critical section
        //remove the item

        //release semaphores

        //return the item

    }

    public static void main(String[] args) {
        // your code
        // multiple producer/consumer threads need to be created based on input parameters

    }
}
