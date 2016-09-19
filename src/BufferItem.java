/**
 * Created by DennisThinhTan on 19-09-2016.
 */
public class BufferItem {
    private int rear,front;
    private int capacitiy;
    private Object[] buffer;

    public BufferItem(int size) {
        if(size <= 0) throw new IllegalArgumentException("Size must be greater than 0");
        this.buffer = new Object[size];
        this.capacitiy = size;
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public int size(){
        if (rear > front)
            return (rear-front);
        else
            return (capacitiy - front + rear);
    }

    public boolean isFull(){
        return (rear-front == -1 || capacitiy == -1);
    }

    public void enqueue(Object item){
        if(isFull()) throw new ArrayStoreException("buffer is full")k;
        buffer[rear] = item; //Puts item in the rear of the queue
        rear = (rear+1)% capacitiy; // increment rear queue position
    }

    public Object dequeue(){
        if(isEmpty()) throw new ArrayStoreException("Buffer is empty");
        Object toReturn = buffer[front];
        buffer[front] = null;
        front = (front+1)%capacitiy; //increment front queue position
        return toReturn;
    }
}
