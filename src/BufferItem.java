/**
 * Represents a buffer that utilize a circular queue
 */
public class BufferItem {
    private int rear,front;
    private int capacitiy;
    private int currentSize;
    private Object[] buffer;

    public BufferItem(int size) {
        if(size <= 0) throw new IllegalArgumentException("Size must be greater than 0");
        this.buffer = new Object[size];
        this.capacitiy = size;
        this.front = 0;
        this.rear = 0;
        this.currentSize = 0;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public int size(){
        return currentSize;
    }

    public boolean isFull(){
        return (currentSize == capacitiy);
    }

    public void enqueue(Object item){
        if(isFull()) throw new ArrayStoreException("buffer is full");
        buffer[rear] = item; //Puts item in the rear of the queue
        rear = (rear+1)% capacitiy; // increment rear queue position
        currentSize = currentSize+1;
    }

    public Object dequeue(){
        if(isEmpty()) throw new ArrayStoreException("Buffer is empty");
        Object toReturn = buffer[front];
        buffer[front] = null;
        front = (front+1)%capacitiy; //increment front queue position
        currentSize = currentSize-1;
        return toReturn;
    }
}
