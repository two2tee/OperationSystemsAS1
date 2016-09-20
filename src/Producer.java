import interfaces.IBuffer;
import utilities.BufferItem;

import java.util.UUID;

/**
 * Represents the producer
 */
public class Producer implements Runnable {

    private IBuffer buffer;
    private UUID uuid;
    private int itemCounter;
    private Object itemToProduce;

    public Producer(IBuffer buffer, Object item) {
        this.buffer = buffer;
        this.itemCounter = 0;
        itemToProduce = item;
        uuid = UUID.randomUUID();

    }

    /**
     * Run production
     */
    public void run() {
        BufferItem item = new BufferItem(uuid,itemCounter,itemToProduce);
        itemCounter = itemCounter+1;

        //While unavailable... like if full or mutex is unavailable keep trying

        //When done
    }


    /**
     * The UUID of the producer
     * @return UUID in string format
     */
    public String getUuid() {
        return uuid.toString();
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
}