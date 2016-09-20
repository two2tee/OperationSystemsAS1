package interfaces;

/**
 * This is an interface for the Buffer class used to outline the methods that it should implement.
 */
public interface IBuffer {

    /**
     * Insert an item into the Buffer.
     * NB: this may be either a blocking or non-blocking operation.
     */
    public abstract int insert_item(Object item);

    /**
     * Remove an item from the Buffer.
     * NB: this may be either a blocking or non-blocking operation.
     */
    public abstract Object remove_item();

}
