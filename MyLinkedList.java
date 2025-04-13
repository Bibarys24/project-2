import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private static class MyNode<T> {
        T element;
        MyNode<T> prev, next;

        MyNode(T element, MyNode<T> prev, MyNode<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode<T> head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        getNode(index).element = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode<T> current = getNode(index - 1);
            MyNode<T> newNode = new MyNode<>(item, current, current.next);
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item, null, head);
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item, tail, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return head.element;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return tail.element;
    }

    @Override
    public void remove(int index) {
        MyNode<T> current = getNode(index);
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    @Override
    public void sort() {
        Object[] arr = toArray();
        java.util.Arrays.sort(arr);
        clear();
        for (Object obj : arr) {
            add((T) obj);
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        for (int i = 0; current != null; i++, current = current.next) {
            if (current.element.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        for (int i = size - 1; current != null; i--, current = current.prev) {
            if (current.element.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode<T> current = head;
        for (int i = 0; current != null; i++, current = current.next) {
            arr[i] = current.element;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current = index < (size >> 1) ? head : tail;
        for (int i = index < (size >> 1) ? 0 : size - 1;
             index < (size >> 1) ? i < index : i > index;
             i += index < (size >> 1) ? 1 : -1) {
            current = index < (size >> 1) ? current.next : current.prev;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private class LinkedListIterator implements Iterator<T> {
        private MyNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            T element = current.element;
            current = current.next;
            return element;
        }
    }}
