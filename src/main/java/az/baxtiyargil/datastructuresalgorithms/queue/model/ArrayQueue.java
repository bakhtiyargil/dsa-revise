package az.baxtiyargil.datastructuresalgorithms.queue.model;

public class ArrayQueue<E> implements Queue<E> {

    private static final int CAPACITY = 10;
    private final E[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    @Override
    public void enqueue(E element) {
        if (sz == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length;
        data[avail] = element;
        sz++;
    }

    @Override
    public E first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

}
