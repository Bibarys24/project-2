public class MyQueue<T> {
    private final MyLinkedList<T> list = new MyLinkedList<>();


    public void enqueue(T item) {
        list.addLast(item);
    }


    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return list.removeFirst();
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }


    public boolean isEmpty() {
        return list.size() == 0;
    }


    public int size() {
        return list.size();
    }
}