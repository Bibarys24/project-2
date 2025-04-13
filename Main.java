public class Main {
    public static void main(String[] args) {
        // Тестирование MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        System.out.println("ArrayList: " + java.util.Arrays.toString(arrayList.toArray()));

        // Тестирование MyLinkedList
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(100);
        linkedList.add(200);
        System.out.println("LinkedList: " + java.util.Arrays.toString(linkedList.toArray()));

        // Тестирование MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack pop: " + stack.pop());

        // Тестирование MyQueue
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue dequeue: " + queue.dequeue());

        // Тестирование MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        System.out.println("MinHeap extractMin: " + minHeap.extractMin());
    }
}