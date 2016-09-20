import interfaces.IBuffer;
import utilities.CircularQueue;
import utilities.Constants;

/**
 * This class is used to encapsulate the creation of the buffer and producer and consumer threads.
 * The main() function initializes the buffer and create the separate producer and consumer threads.
 * Once it has created the producer and consumer threads,
 * the main () function will sleep for a period of time and, upon awakening, will terminate the application.
 */
public class Main {

    /**
     * Creates the buffer and the producer/consumer threads based on input parameters
     * @param args 0 (how long to sleep before terminating), 1 (number of producer threads) and 2 (number of consumer threads)
     */
    public static void main(String[] args)
    {
        /* 1. Get command line arguments argv[1], argv[2], argv[3]*/
        int sleepInterval = Integer.parseInt(args[0]);
        int producerAmount = Integer.parseInt(args[1]);
        int consumerAmount = Integer.parseInt(args[2]);

        /* 2. Initialize buffer */
        IBuffer sharedBuffer = new BoundedBuffer(new CircularQueue(Constants.BUFFER_SIZE));

        /* 3. Create producer threads --- use for loops to create many */
        Producer producer = new Producer(sharedBuffer,"item");

        /* 4. Create consumer threads --- use for loops to create many */
        Consumer consumer = new Consumer(sharedBuffer);

        /* 5. Sleep */


        /* 6. Exit */
    }

}
