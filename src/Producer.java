import interfaces.IBuffer;
import utilities.BufferItem;

import java.util.UUID;

/**
 * Represents the producer
 */
public class Producer implements Runnable {

    private IBuffer buffer;
    private UUID producerId;
    private int itemCounter;
    private Object itemToProduce;

    public Producer(IBuffer buffer, Object item) {
        this.buffer = buffer;
        this.itemCounter = 0;
        itemToProduce = item;
        producerId = UUID.randomUUID();

    }

    /**
     * Run production
     */
    public void run() {
        BufferItem item = new BufferItem(producerId,itemCounter,itemToProduce);
        itemCounter = itemCounter+1;

        //While unavailable... like if full or mutex is unavailable keep trying

        //When done
        printProducedItem(item);
    }


    /**
     * The UUID of the producer
     * @return UUID in string format
     */
    public String getProducerId() {
        return producerId.toString();
    }

    /**
     * current item counter
     * @return int
     */
    public int getItemCounter() {
        return itemCounter;
    }

    /**
     * The item this producer will produce
     * @return Object
     */
    public Object getItemToProduce() {
        return itemToProduce;
    }

    private void printProducedItem(BufferItem item){
        System.out.println("Producer: " + producerId.toString() + " produced item: " + item.getItemId());
    }
}