package utilities;

import java.util.UUID;

/**
 * wrapper  class for an item to add to the buffer
 */
public class BufferItem {
    private final UUID producerId;
    private final int itemId;
    private Object item;

    public BufferItem(UUID producerId, int itemId, Object item) {
        this.producerId = producerId;
        this.itemId = itemId;
        this.item = item;
    }

    /**
     * Returns the UUID of the producer for this item
     * @return uuid
     */
    public UUID getProducerId() {
        return producerId;
    }

    /**
     * Returns the item id for this item
     * @return int id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Returns the  stored item provided by the producer
     * @return Object
     */
    public Object getItem() {
        return item;
    }
}
