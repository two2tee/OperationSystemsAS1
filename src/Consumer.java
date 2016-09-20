import interfaces.IBuffer;
import utilities.BufferItem;

import java.util.UUID;

/**
 * Represents the consumer
 */
public class Consumer implements Runnable {

    private IBuffer buffer;
    private UUID consumerId;

    public Consumer(IBuffer buffer) {
        this.buffer = buffer;
        consumerId = UUID.randomUUID();
        // your code
    }

    public void run() {
        // your code

        //Do while loop to keep consuming if buffer is unavailable
        BufferItem item = buffer.remove_item();

        //Prints the result
        printItem(item);
    }

    /**
     * Prints the consumed item id and producer id
     * @param item consumed item
     */
    private void printItem(BufferItem item)
    {
        System.out.println("Consumer: " + consumerId.toString() + " received item: " + item.getItemId() + " from producer: " + item.getProducerId());
    }
}

